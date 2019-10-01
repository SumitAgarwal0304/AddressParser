package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;
import com.parsingaddress.util.CommonUtils;

/**
 * This class is used when number is in Last
 */
public class NumberInLast implements IRule {

    @Override
    public boolean checkRule(String address) {
        return address.substring(address.lastIndexOf(" ")).matches(CONSTANT_REGEX);
    }

    @Override
    public Address getTheValueFromRule(String givenAddress) {

        Address address = new Address();
        String[] givenStringArray = givenAddress.split(" ");
        int length = givenStringArray.length;

        //check if the string before number contains any string no.,no,Number,NO
        if (CommonUtils.containsGivenTypeOfString(givenStringArray[length - 2])) {
            address.setHousenumber(givenStringArray[length - 2] + " " + givenStringArray[length - 1]);
            address.setHousenumber(address.getHousenumber().replace(",", "").trim());
        } else {
            address.setHousenumber(givenStringArray[length - 1].replace(",", "").trim());
        }
        address.setStreet(givenAddress.replace(address.getHousenumber(), "").replace(",", "").trim());
        return address;
    }
}
