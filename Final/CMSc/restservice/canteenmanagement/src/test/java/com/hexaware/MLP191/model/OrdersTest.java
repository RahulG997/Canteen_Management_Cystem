
package com.hexaware.MLP191.model;

import com.hexaware.MLP191.persistence.OrdersDAO;
import com.hexaware.MLP191.factory.OrdersFactory;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class OrdersTest {

  private Date d1 = new Date();
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testOrders() {
    Orders o1 = new Orders();
    Orders o2 = new Orders();
    assertNotEquals(o1, null);
    assertNotEquals(o2, null);
    assertEquals(o1.getOrdId(), new Orders().getOrdId());
    //assertEquals(o1.getOrdDate(), new Orders().getOrdDate());
    assertEquals(o1.getFoodId(), new Orders().getFoodId());
    assertEquals(o1.getQuantity(), new Orders().getQuantity());
    assertEquals(o1.getTotal(), new Orders().getTotal());
    assertEquals(o1.getCusId(), new Orders().getCusId());
    assertEquals(o1.getToken(), new Orders().getToken());
    assertEquals(o1.getOrdStatus(), new Orders().getOrdStatus());
    o2.setOrdId(1);
    o2.setOrdDate(d1);
    o2.setFoodId(1);
    o2.setQuantity(20);
    o2.setTotal(20);
    o2.setToken(24);
    o2.setCusId(1);
    o2.setOrdStatus("Accepted");
    assertNotEquals(o2, new Orders());
    assertEquals(o1.hashCode(),
        new Orders().hashCode());
    assertNotEquals(o1, new Orders());
  }


    /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllOrders(@Mocked final OrdersDAO dao) {
    new Expectations() {
      {
        dao.showFullOrders();
        result = new ArrayList<Orders>();
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] me = OrdersFactory.showFullOrders();
    assertEquals(0, me.length);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OrdersDAO dao) {
    new Expectations() {
      {
        dao.show(1);
        result = new ArrayList<Orders>();
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] me = OrdersFactory.showOrders(1);
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OrdersDAO dao) {
    final Orders o1 = new Orders();
    final Orders o2 = new Orders();
    final ArrayList<Orders> mn = new ArrayList<Orders>();
    new Expectations() {
      {
        mn.add(o1);
        mn.add(o2);
        dao.show(1);
        result = mn;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        return dao;
      }
    };
    Orders[] order = OrdersFactory.showOrders(1);
    assertEquals(2, order.length);
    assertEquals(new Orders().getOrdId(),
        order[0].getOrdId());
    assertEquals(new Orders().getOrdId(),
        order[1].getOrdId());
  }

    /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testDefaultConstructor() {
    Orders orders = new Orders();
    assertEquals(orders.hashCode(), new Orders().hashCode());
  }
  /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersOrderId() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(1, orders.getOrdId());
  }
  /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersOrderDate() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(d1, orders.getOrdDate());
  }
   /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersFoodId() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(1, orders.getFoodId());
  }
   /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersQuantity() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(1, orders.getQuantity());
  }
   /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersOrderTotal() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(50, orders.getTotal());
  }
   /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersCustomerId() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(1, orders.getCusId());
  }
   /**
   * to test the getters for vendor.
   */
  @Test
  public final  void testGettersOrderStatus() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals("placed", orders.getOrdStatus());
  }
   /**
   * to test the getters for order.
   */
  @Test
  public final  void testGettersGetToken() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    assertEquals(74, orders.getToken());
  }

    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersOrders() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setOrdId(27);
    assertEquals(27, orders.getOrdId());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersOrderdate() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setOrdDate(d1);
    assertEquals(d1, orders.getOrdDate());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersfoodId() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setFoodId(10);
    assertEquals(10, orders.getFoodId());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersQuantity() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setQuantity(4);
    assertEquals(4, orders.getQuantity());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersTotal() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setTotal(1900);
    assertEquals(1900, orders.getTotal());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersCustomerId() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setCusId(11);
    assertEquals(11, orders.getCusId());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersOrderStatus() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setOrdStatus("placed");
    assertEquals("placed", orders.getOrdStatus());
  }
    /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersToken() {
    Orders orders = new Orders(1, d1, 1, 1, 50, 1, "placed", 74);
    orders.setToken(67);
    assertEquals(67, orders.getToken());
  }
    /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testSingleParamConstructor() {
    Orders orders = new Orders(23);
    Orders orders1 = new Orders(23);
    assertEquals(orders.hashCode(), orders1.hashCode());
  }
}
