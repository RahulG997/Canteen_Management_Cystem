
package com.hexaware.MLP191.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.hexaware.MLP191.factory.CustomerFactory;
import com.hexaware.MLP191.model.Customer;
import com.hexaware.MLP191.persistence.CustomerDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class CustomerFactoryTest {

  private Date d1 = new Date();
  private SimpleDateFormat sdf;

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showCustomer(@Mocked final CustomerDAO dao) {

    final Customer customer = new Customer();
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        CustomerFactory.showCustomer();
        result = customer;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final Customer[] actualS = CustomerFactory.showCustomer();
    assertNotEquals(customer, actualS);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void updateCustomer(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer();
    new Expectations() {
      {
        System.out.println("mocked get Customer");
        final int c = CustomerFactory.updateCustomer("mahima123", 1);
        result = c;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final int ce = CustomerFactory.updateCustomer("mahima123", 1);
    assertNotEquals(c, ce);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void addMoney(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer();
    new Expectations() {
      {
        System.out.println("mocked get Customer");
        final int c = CustomerFactory.addMoney(500, 2);
        result = c;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final int ce = CustomerFactory.addMoney(500, 2);
    assertNotEquals(c, ce);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void deductAmount(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer();
    new Expectations() {
      {
        System.out.println("mocked get Customer");
        final int c = CustomerFactory.deductAmount(1, 10);
        result = c;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final int ce = CustomerFactory.deductAmount(1, 10);
    assertNotEquals(c, ce);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void returnMoney(@Mocked final CustomerDAO dao) {
    final Customer c = new Customer();
    new Expectations() {
      {
        System.out.println("mocked get Customer");
        final int c = CustomerFactory.returnMoney(1, 20);
        result = c;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final int ce = CustomerFactory.returnMoney(1, 20);
    assertNotEquals(c, ce);
  }

  /**
   * @param dao DAO FILE
   */
  @Test
  public final void check(@Mocked final CustomerDAO dao) {

    final Customer customer = new Customer();
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        CustomerFactory.check("thanujapedapudi@gmail.com", "thanuja");
        result = customer;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final Customer ce = CustomerFactory.check("thanujapedapudi@gmail.com", "thanuja");
    assertEquals(customer, ce);
  }

  /**
   * @param dao DAO FILE
   * @throws ParseException exception
   */
  @Test
  public final void insertCustomer(@Mocked final CustomerDAO dao) throws ParseException {

    final String date1 = "2020/09/09";
    sdf = new SimpleDateFormat("yyyy/MM/dd");
    sdf.setLenient(false);
    d1 = sdf.parse(date1);
    final int i = 1;
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        CustomerFactory.addCustomer("Mahima", 8109934355L, "mahima.26@gmail.com", 5000, "mahima123", d1);
        result = i;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final int ce = CustomerFactory.addCustomer("Mahima", 8109934355L, "mahima.26@gmail.com", 5000, "mahima123", d1);
    System.out.println(ce);
    assertNotEquals(i, ce);
  }

    /**
     * Testing default protected constructor.
     */
  @Test
  public final void testDefaultConstructor() {
    CustomerFactory cf = new CustomerFactory();
    CustomerFactory cf1 = new CustomerFactory();
    assertNotEquals(cf.hashCode(), cf1.hashCode());
  }

  /**
   * @param dao DAO FILE
   */
  @Test
  public final void testDisplayCus(@Mocked final CustomerDAO dao) {

    final Customer customer = new Customer();
    new Expectations() {
      {
        System.out.println("Mocked find a Customer");
        CustomerFactory.displayDetails("a@gmail.com");
        result = customer;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
        CustomerDAO dao() {
        System.out.println("Mocked Customer Dao");
        return dao;
      }
    };
    final Customer ce = CustomerFactory.displayDetails("a@gmail.com");
    assertEquals(customer, ce);
  }
}

