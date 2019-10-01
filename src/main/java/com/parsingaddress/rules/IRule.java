package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;

/**
 * Interface for all the rules
 */
public interface IRule {

    String CONSTANT_REGEX = ".*\\d.*";
    boolean checkRule(String address);
    Address getTheValueFromRule(String address);
}
