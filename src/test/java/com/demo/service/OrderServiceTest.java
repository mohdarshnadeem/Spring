package com.demo.service;

import com.demo.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private OrderService orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrderWithoutCc_ShouldThrowExceptionAndNotNotifyCustomer() {
        Order order = new Order(1, "something", 100.0);
        doThrow(new RuntimeException("An Exception Occurred")).when(emailService).sendEmail(any(Order.class));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> orderService.placeOrder(order));
        assertEquals("An Exception Occurred", exception.getMessage());
        assertFalse(order.isCustomerNotified());
    }

    @Test
    public void testPlaceOrderWithCc_ShouldReturnTrueAndNotifyCustomer() {
        Order order = new Order(1, "something", 100.0);
        when(emailService.sendEmail(order, "arsh@gmail.com")).thenReturn(true);

        boolean isNotified = orderService.placeOrder(order, "arsh@gmail.com");

        assertTrue(isNotified);
        verify(emailService).sendEmail(order, "arsh@gmail.com");
        assertEquals(240.0, order.getPriceWithTax(), 0.001);
        assertTrue(order.isCustomerNotified());
    }
}
