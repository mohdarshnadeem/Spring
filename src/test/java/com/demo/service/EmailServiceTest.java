package com.demo.service;

import com.demo.domain.Order;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class EmailServiceTest{

   private EmailService emailService;

   @Before
   public void setUp(){
      //using singleton instance, for simplicity
      emailService = EmailService.getInstance();
   }

   @Test
   public void testSendEmailWithoutCc_ShouldThrowRuntimeNotificationAndNotNotify(){
      Order order = new Order(1,"something",100);
      RuntimeException runtimeException = assertThrows(RuntimeException.class, ()->emailService.sendEmail(order));
      assertEquals("An Exception Occurred", runtimeException.getMessage());
      assertFalse(order.isCustomerNotified());
   }

   @Test
   public void testSendEmailWithCc_ShouldReturnTrueAndNotify(){
      Order order = new Order(1,"something",100.0);
      boolean result = emailService.sendEmail(order,"arsh@gmail.com");
      assertTrue(result);
      assertTrue(order.isCustomerNotified());
   }
}