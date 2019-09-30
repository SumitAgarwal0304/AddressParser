package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberInFirstTest {

    private static final NumberInFirst systemUnderTest = new NumberInFirst();

    @Test
    public void checkRule_True() {
        //Arrange
        String checkAddress = "200 Broadway Av";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertTrue(result);
    }

    @Test
    public void checkRule_False() {
        //Arrange
        String checkAddress = "Winterallee 3";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertFalse(result);
    }

    @Test
    public void getTheValueFromRuleTest() {
        //Arrange
        String checkAddress = "200 Broadway Av";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertEquals(address.getStreet(),"Broadway Av");
        assertEquals(address.getHousenumber(),"200");
    }
}