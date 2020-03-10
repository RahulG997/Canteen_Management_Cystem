package com.hexaware.MLP191.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hexaware.MLP191.factory.CustomerFactory;
//import com.hexaware.MLP191.model.Customer;
import com.hexaware.MLP191.persistence.CustomerDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Customer.
 */
@RunWith(JMockit.class)
public class CustomerTest {

  private Date pDate = new Date();
  private Date pDate1 = new Date();
  private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");;

  /**
   * setup method.
   *
   * @throws ParseException exception
   */
  @Before
  public final void initInput() throws ParseException {
     //customer = new Customer();
    String custdob1 = "26/12/1998";
    String custdob2 = "26/12/1998";
    sdf.setLenient(false);
    pDate = sdf.parse(custdob1);
    pDate1 = sdf.parse(custdob1);
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testCustomer() {
    //Customer c = new Customer();
    Customer c1 = new Customer();
    Customer c2 = new Customer();
    assertNotEquals(c1, null);
    assertNotEquals(c2, null);
    assertEquals(c1.getCusId(), new Customer().getCusId());
    assertEquals(c1.getCusName(), new Customer().getCusName());
    assertEquals(c1.getcusPhone(), new Customer().getcusPhone());
    //assertEquals(c1.getCusDob(), new Customer().getCusDob());
    assertEquals(c1.getCusEmail(), new Customer().getCusEmail());
    assertEquals(c1.getCurrAmt(), new Customer().getCurrAmt());
    assertEquals(c1.getpassword(), new Customer().getpassword());
    c2.setCusId(10);
    assertEquals(10, c2.getCusId());
    c2.setCusName("carolin");
    assertEquals("carolin", c2.getCusName());
    c2.setCusPhone(1234567890L);
    assertEquals(1234567890, c2.getcusPhone());
    c2.setCusEmail("carolin@gmail.com");
    assertEquals("carolin@gmail.com", c2.getCusEmail());
    c2.setCurrAmt(1000);
    assertEquals(1000, c2.getCurrAmt());
    c2.setpassword("carolin123");
    assertEquals("carolin123", c2.getpassword());
    assertNotEquals(c2, new Customer());
    assertEquals(c1.hashCode(), new Customer().hashCode());
    assertEquals(c1, new Customer());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final CustomerDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Customer>();
      }
    };
    new MockUp<CustomerFactory>(
    ) {
      @Mock
      CustomerDAO dao() {
        return dao;

      }
    };
    Customer[] me = CustomerFactory.showCustomer();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final CustomerDAO dao) {
    final Customer c1 = new Customer();
    final Customer c2 = new Customer();
    final ArrayList<Customer> mn = new ArrayList<Customer>();
    new Expectations() {
      {
        mn.add(c1);
        mn.add(c2);
        dao.show(); result = mn;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerDAO dao() {
        return dao;
      }
    };
    Customer[] mn1 = CustomerFactory.showCustomer();
    assertEquals(2, mn1.length);

    assertEquals(new Customer().getCusId(),
        mn1[0].getCusId());
    assertEquals(new Customer().getCusId(),
        mn1[1].getCusId());
  }
/** */
  @Test
  public final void testDefaultConstructor() {
    Customer customer = new Customer();
    assertEquals(customer.hashCode(), new Customer().hashCode());
  }


  /**
   * to test the getters for Customer.
   */
  @Test
  public final void testGettersCustomers() {
    Customer customer = new Customer(1, "Mahima", 7894561230L,  pDate, "mahima.26@gmail.com", 1000, "mahima123");
    assertEquals(1, customer.getCusId());
    assertEquals("Mahima", customer.getCusName());
    assertNotEquals(8109934355L, customer.getcusPhone());
    assertEquals("mahima.26@gmail.com", customer.getCusEmail());
    assertEquals(1000, customer.getCurrAmt(), 0);
    assertEquals("mahima123", customer.getpassword());
    assertEquals(pDate, customer.getCusDob());
  }

   /**
   * to test the setters for customer.
   */
  @Test
  public final void testSettersCustomersId() {
    Customer customer = new Customer(1, "Mahima", 7894561230L, pDate,  "mahima.26@gmail.com", 1000, "mahima123");
    customer.setCusId(1);
    assertEquals(1, customer.getCusId());
  }
  /**
   * to test the setters for customer.
   */
  @Test
  public final void testSettersCustomersName() {
    Customer customer = new Customer(1, "Mahima", 7894561230L, pDate,  "mahima.26@gmail.com", 1000, "mahima123");
    customer.setCusName("Mahima");
    assertEquals("Mahima", customer.getCusName());
  }
  /**
   * to test the setters for customer.
   */
  @Test
  public final void testSettersCustomersEmail() {
    Customer customer = new Customer(1, "Mahima", 7894561230L, pDate,  "mahima.26@gmail.com", 1000, "mahima123");
    customer.setCusEmail("mahima.26@gmail.com");
    assertEquals("mahima.26@gmail.com", customer.getCusEmail());
  }
  /**
   * to test the setters for customer.
   */
  @Test
  public final void testSettersCustomersAmt() {
    Customer customer = new Customer(1, "Mahima", 7894561230L, pDate,  "mahima.26@gmail.com", 1000, "mahima123");
    customer.setCurrAmt(1000);
    assertEquals(1000, customer.getCurrAmt(), 0);
  }
   /**
   * to test the setters for customer.
   */
  @Test
  public final void testSettersCustomerspassword() {
    Customer customer = new Customer(1, "Mahima", 7894561230L, pDate,  "mahima.26@gmail.com", 1000, "mahima123");
    customer.setpassword("mahima123");
    assertEquals("mahima123", customer.getpassword());
  }
  /**
   * to test the setters for customer.
   */
  @Test
  public final void testSettersCustomersDob() {
    Customer customer = new Customer(1, "Mahima", 7894561230L, pDate,  "mahima.26@gmail.com", 1000, "mahima123");
    customer.setCusDob(pDate);
    assertEquals(pDate, customer.getCusDob());
  }
}
