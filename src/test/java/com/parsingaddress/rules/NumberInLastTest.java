package com.parsingaddress.rules;

import com.parsingaddress.dto.Address;
import org.junit.Test;

import static org.junit.Assert.*;


public class NumberInLastTest {

    private static final NumberInLast systemUnderTest = new NumberInLast();

    @Test
    public void checkRule_True() {

        //Arrange
        String checkAddress = "Winterallee 3";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertTrue(result);
    }

    @Test
    public void checkRule_True_When_Contains_Number() {

        //Arrange
        String checkAddress = "Calle 39 No 1540";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertTrue(result);
    }

    @Test
    public void checkRule_False() {

        //Arrange
        String checkAddress = "4, rue de la revolution";
        //Act
        boolean result = systemUnderTest.checkRule(checkAddress);
        //Assert
        assertFalse(result);
    }

    @Test
    public void getTheValueFromRule_When_String_Contains_No_In_Address() {

        //Arrange
        String checkAddress = "Calle 39 No 1540";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);

        //Assert
        assertEquals(address.getStreet(),"Calle 39");
        assertEquals(address.getHousenumber(),"No 1540");
    }

    @Test
    public void getTheValueFromRule_When_String_Contains_AlphaNumericAsLastNumber() {

        //Arrange
        String checkAddress = "Blaufeldweg 123B";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);

        //Assert
        assertEquals(address.getStreet(),"Blaufeldweg");
        assertEquals(address.getHousenumber(),"123B");
    }

    @Test
    public void getTheValueFromRule_When_String_Contains_NumericAsLastNumber() {

        //Arrange
        String checkAddress = "Am Bächle 23";
        //Act
        Address address = systemUnderTest.getTheValueFromRule(checkAddress);

        //Assert
        assertEquals(address.getStreet(),"Am Bächle");
        assertEquals(address.getHousenumber(),"23");
    }
}