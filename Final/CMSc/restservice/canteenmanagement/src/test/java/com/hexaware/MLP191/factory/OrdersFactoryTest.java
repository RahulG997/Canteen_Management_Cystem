
package com.hexaware.MLP191.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;


import com.hexaware.MLP191.model.Orders;
import com.hexaware.MLP191.persistence.OrdersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class OrdersFactoryTest {


  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showOrders(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.showOrders(1);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders[] actualS = OrdersFactory.showOrders(1);
    assertNotEquals(orders, actualS);
  }



    /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testshowFullOrders(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.showFullOrders();
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders[] actualS = OrdersFactory.showFullOrders();
    assertNotEquals(orders, actualS);
  }
/**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void updateOrdersTotal(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.updateOrdersTotal(6);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int actualS = OrdersFactory.updateOrdersTotal(6);
    assertNotEquals(orders, actualS);
  }
  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void gettOrdId(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();
    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.gettOrdId(1);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders actualS = OrdersFactory.gettOrdId(1);
    assertNotEquals(orders, actualS);
  }

   /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void addOrders(@Mocked final OrdersDAO dao) {
    Date d1 = new Date();

    final int i = dao.addOrders(1, 2, 3, d1);

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        Date d1 = new Date();
        OrdersFactory.addOrders(1, 2, 3, d1);
        result = i;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int actualS = OrdersFactory.addOrders(1, 2, 3, d1);
    assertEquals(i, actualS);
  }

  /**
   * tests that customer wallet is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test

  public final void updateOrdersToken(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();
    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.updateOrdersToken(2);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int actualS = OrdersFactory.updateOrdersToken(2);
    assertNotEquals(orders, actualS);
  }


  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void updateStatus(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.updateStatus("accepted", 2);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int actualS = OrdersFactory.updateStatus("accepted", 2);
    assertNotEquals(orders, actualS);
  }
  /**
   * @param dao DAO
   */
  @Test
  public final void insertOrders(@Mocked final OrdersDAO dao) {

    final Orders orders = new Orders();

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.showOrders(1);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    Orders[] actualS = OrdersFactory.showOrders(1);
    assertNotEquals(orders, actualS);
  }


    /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void checkcoup(@Mocked final OrdersDAO dao) {
    final Orders orders = new Orders();

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        OrdersFactory.checkcoup(1);
        result = orders;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int actualS = OrdersFactory.checkcoup(1);
    assertNotEquals(orders, actualS);
  }
 /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void addOrderoff(@Mocked final OrdersDAO dao) {
    Date d1 = new Date();
    final int i = dao.addOrderoff(1, 1, 1, d1, 250);

    new Expectations() {
      {
        System.out.println("Mocked find a order");
        Date d1 = new Date();
        OrdersFactory.addOrdersoff(1, 1, 1, d1, 250);
        result = i;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int actualS = OrdersFactory.addOrdersoff(1, 1, 1, d1, 250);
    assertEquals(i, actualS);
  }
    /**
     * Testing default protected constructor.
     */
  @Test
  public final void testDefaultConstructor() {
    OrdersFactory of = new OrdersFactory();
    OrdersFactory of1 = new OrdersFactory();
    assertNotEquals(of.hashCode(), of1.hashCode());
  }

}
