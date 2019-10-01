package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;

/**
 * This class is used when only one string is present in given address
 */
public class HaveOnlyOneString implements IRule{

    @Override
    public boolean checkRule(String address) {
        return address.split(" ").length == 1;
    }

    @Override
    public Address getTheValueFromRule(String givenAddress) {
        Address address = new Address();
        if(givenAddress.matches(CONSTANT_REGEX)){
            address.setHousenumber(givenAddress);
        }
        else{
            address.setStreet(givenAddress);
        }
        return address;
    }
}
