package com.webapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HashingServiceTest {


    private HashingService hashingService = new HashingService();

    @Test
    public void encode_lessThan62() {
        assertEquals("k", hashingService.encode(10));
    }

    @Test
    public void encode_moreThan62() {
        assertEquals("bq", hashingService.encode(78));
    }


}