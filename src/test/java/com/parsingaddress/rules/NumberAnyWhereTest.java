package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberAnyWhereTest {

    private static final NumberAnyWhere systemUnderTest = new NumberAnyWhere();

    @Test
    public void checkRule_When_True() {
        //Arrange
        String checkAddress = "Winterallee 3";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertTrue(result);
    }

    @Test
    public void checkRule_When_False() {
        //Arrange
        String checkAddress = "Winterallee";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertFalse(result);
    }

    @Test
    public void getTheValueFromRuleTest() {
        //Arrange
        String checkAddress = "Auf der Vogelwiese 23 b";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertEquals(address.getStreet(),"Auf der Vogelwiese");
        assertEquals(address.getHousenumber(),"23 b");
    }

    @Test
    public void getTheValueFromRuleTest_When_At_Start_There_Is_Number_String() {
        //Arrange
        String checkAddress = "No 23b Auf der Vogelwiese 23 b";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertEquals(address.getStreet(),"Auf der Vogelwiese 23 b");
        assertEquals(address.getHousenumber(),"No 23b");
    }

    @Test
    public void getTheValueFromRuleTest_When_At_There_Is_No_Number() {
        //Arrange
        String checkAddress = "No Auf der Vogelwiese";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertNull(address.getStreet());
        assertNull(address.getHousenumber());
    }

    @Test
    public void getTheValueFromRuleTest_When_There_Is_Multiple_Number() {
        //Arrange
        String checkAddress = "1234 2345 der 12345 B";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertEquals(address.getStreet(),"1234 2345 der");
        assertEquals(address.getHousenumber(),"12345 B");
    }

}