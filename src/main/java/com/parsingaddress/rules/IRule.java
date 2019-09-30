package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;

public interface IRule {

    String CONSTANT_REGEX = ".*\\d.*";
    boolean checkRule(String address);
    Address getTheValueFromRule(String address);
}
