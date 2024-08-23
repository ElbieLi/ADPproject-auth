package com.webage;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.webage.api.TokenAPI;
import com.webage.domain.Customer;

public class TokenAPITest {

    @Mock
    private Customer customer;

    @Spy
    @InjectMocks
    private TokenAPI tokenAPI;

    @BeforeEach
    public void setUp(){
        //initialize mockito
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTokenForCustomer(){
        //create values for testing purpose
        when(customer.getName()).thenReturn("Amy");
        when(customer.getPassword()).thenReturn("pw123");

        //make checkPassword return true for testing purpose
        doReturn(true).when(tokenAPI).checkPassword("Amy","pw123");

        //call the method
        ResponseEntity<?> response = tokenAPI.createTokenForCustomer(customer);

        //verify using assert
        assertEquals(HttpStatus.OK, response.getStatusCode());


    }

}
