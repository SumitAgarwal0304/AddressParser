package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;

public class NumberInFirst implements IRule {

    @Override
    public boolean checkRule(String givenAddress) {

        return givenAddress.substring(0, givenAddress.indexOf(" ")).matches(CONSTANT_REGEX);
    }

    @Override
    public Address getTheValueFromRule(String givenAddress) {

        Address address = new Address();
        int index = givenAddress.indexOf(" ");
        address.setHousenumber(givenAddress.substring(0, index).replace(",","").trim());
        address.setStreet(givenAddress.substring(index).replace(",","").trim());
        return address;
    }
}
