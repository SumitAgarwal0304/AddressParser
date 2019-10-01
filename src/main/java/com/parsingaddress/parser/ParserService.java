package com.parsingaddress.parser;

import com.parsingaddress.dto.Address;
import com.parsingaddress.rules.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParserService {

    /**
     * This method is used to parse address
     * @param givenAddress
     * @return Address
     */
    public Address parseTheAddress(String givenAddress) {

        Address address = new Address();
        IRule rule = getIRule(givenAddress);

        if (rule == null)
            address.setStreet(givenAddress);
        else
            address = rule.getTheValueFromRule(givenAddress);

        return address;
    }

    /**
     * This method is used to get the correct rule based on predicate
     * @param givenAddress
     * @return IRule
     */
    private IRule getIRule(String givenAddress) {
        List<IRule> ruleList = setRulesForParsing();

        return ruleList.stream().filter(r -> r.checkRule(givenAddress))
                .findFirst().orElse(null);
    }

    /**
     * Private method to set all the rules
     *
     * @return List of IRules
     */
    private final List<IRule> setRulesForParsing() {
        List<IRule> ruleList = new ArrayList<>();
        ruleList.add(new HaveOnlyOneString());
        ruleList.add(new NumberInLast());
        ruleList.add(new NumberInFirst());
        ruleList.add(new NumberAnyWhere());
        return ruleList;
    }

}
