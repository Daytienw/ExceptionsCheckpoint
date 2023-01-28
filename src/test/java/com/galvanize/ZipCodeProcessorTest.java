package com.galvanize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZipCodeProcessorTest {
    // write your tests here
    @Test
    public void zipCodeThatStartsWithOneThrowsNoServiceException() {
        ZipCodeProcessor code = new ZipCodeProcessor(new Verifier());

        NoServiceException exception = assertThrows(NoServiceException.class, () -> code.process("12345"));

        assertEquals("We're sorry, but the zip code you entered is out of our range.", exception.getMessage());
    }
    @Test
    public void zipCodeThatIsNotFiveDigitsThrowsInvalidFormatException() {
        ZipCodeProcessor code = new ZipCodeProcessor(new Verifier());

        InvalidFormatException exception = assertThrows(InvalidFormatException.class, () -> code.process("12345"));

        assertEquals("The zip code you entered was the wrong length.", exception.getMessage());
    }


}