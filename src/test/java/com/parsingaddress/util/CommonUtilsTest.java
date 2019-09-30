package com.parsingaddress.util;

import org.junit.Test;


public class CommonUtilsTest {

   @Test
    public void containsGivenTypeOfStringTest_Return_True() {
        //Act //Arrange
        Boolean result = CommonUtils.containsGivenTypeOfString("No");
        //Assert
        assert (result).equals(true);
    }

    @Test
    public void containsGivenTypeOfStringTest_Return_False() {
        //Act //Arrange
        Boolean result = CommonUtils.containsGivenTypeOfString("Address");
        //Assert
        assert (result).equals(false);
    }


}