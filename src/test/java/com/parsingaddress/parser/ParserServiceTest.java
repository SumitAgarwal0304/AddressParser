package com.parsingaddress.parser;

import com.parsingaddress.dto.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ParserServiceTest {

    ParserService parserService = new ParserService();

    @Test
    public void addressParserTest_If_Number_Is_At_Last(){

        //Arrange
        String testString = "Winterallee 3";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getStreet(),"Winterallee");
        assertEquals(address.getHousenumber(),"3");

    }

    @Test
    public void addressParserTest_If_AlphaNumeric_Is_At_Last(){

        //Arrange
        String testString = "Blaufeldweg 123B";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getStreet(),"Blaufeldweg");
        assertEquals(address.getHousenumber(),"123B");

    }

    @Test
    public void addressParserTest_If_Number_Is_At_First(){

        //Arrange
        String testString = "4, rue de la revolution";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getStreet(),"rue de la revolution");
        assertEquals(address.getHousenumber(),"4");

    }

    @Test
    public void addressParserTest_If_Number_Is_At_Last_And_Contains_String_Number(){

        //Arrange
        String testString = "Calle 39 No 1540";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getStreet(),"Calle 39");
        assertEquals(address.getHousenumber(),"No 1540");

    }

    @Test
    public void addressParserTest_If_Number_Is_In_Between(){

        //Arrange
        String testString = "Auf der Vogelwiese 23 b";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getStreet(),"Auf der Vogelwiese");
        assertEquals(address.getHousenumber(),"23 b");

    }

    @Test
    public void addressParserTest_If_There_Is_No_Number(){

        //Arrange
        String testString = "Auf der Vogelwiese";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getStreet(),"Auf der Vogelwiese");
        assertNull(address.getHousenumber());

    }

    @Test
    public void addressParserTest_If_There_Is_Only_Number(){

        //Arrange
        String testString = "12345";

        //Act
        Address address = parserService.parseTheAddress(testString);

        //Assert
        assertEquals(address.getHousenumber(),"12345");
        assertNull(address.getStreet());

    }

}