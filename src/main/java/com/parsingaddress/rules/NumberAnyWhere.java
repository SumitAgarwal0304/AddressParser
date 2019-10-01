package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;
import com.parsingaddress.util.CommonUtils;

import java.util.Arrays;

/**
 * This class is used when number is not in first and Last
 */
public class NumberAnyWhere implements IRule {

    @Override
    public boolean checkRule(String givenAddress) {
        return Arrays.stream(givenAddress.split(" ")).anyMatch(s -> s.matches(CONSTANT_REGEX));
    }

    @Override
    public Address getTheValueFromRule(String givenAddress) {

        Address address = new Address();
        //Split given string based on space
        String[] givenStringArray = givenAddress.split(" ");

        //check if the Number is followed by any given string and number is not in last
        if(CommonUtils.containsGivenTypeOfString(givenStringArray[0]) && givenStringArray[1].matches(CONSTANT_REGEX)){
            address.setHousenumber(givenStringArray[0] +" "+ givenStringArray[1]);
            address.setStreet(givenAddress.replace(address.getHousenumber(),"").trim());
        }
        else{
            //Get the last number in the address if there are multiple numbers
            String number = Arrays.stream(givenStringArray).filter(s -> s.matches(CONSTANT_REGEX)).reduce((first, second) -> second).orElse(null);
            if(number != null) {
                address.setHousenumber(givenAddress.substring(givenAddress.indexOf(number)).replace(",", "").trim());
                address.setStreet(givenAddress.substring(0, givenAddress.indexOf(number)).replace(",", "").trim());
            }
        }
        return address;
    }
}
