package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;

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
