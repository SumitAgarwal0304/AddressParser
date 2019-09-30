package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class HaveOnlyOneStringTest {

    private static final HaveOnlyOneString systemUnderTest = new HaveOnlyOneString();

    @Test
    public void checkRule_True() {
        //Arrange
        String checkAddress = "3";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertTrue(result);
    }

    @Test
    public void checkRule_False() {
        //Arrange
        String checkAddress = "Address 1234";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertFalse(result);
    }


    @Test
    public void getTheValueFromRule_With_Only_Integer() {
        //Arrange
        String checkAddress = "12345";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertEquals(address.getHousenumber(),"12345");
        assertNull(address.getStreet());
    }

    @Test
    public void getTheValueFromRule_With_Only_String() {
        //Arrange
        String checkAddress = "Address";
        //Act
        Address address =  systemUnderTest.getTheValueFromRule(checkAddress);
        //Assert
        assertEquals(address.getStreet(),"Address");
        assertNull(address.getHousenumber());
    }
}