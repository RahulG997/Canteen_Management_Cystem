package com.hexaware.MLP191.factory;

import com.hexaware.MLP191.persistence.OrdersDAO;
import com.hexaware.MLP191.persistence.DbConnection;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.hexaware.MLP191.model.Orders;

/**
 * MenuFactory class used to fetch menu data from database.
 * @author Carolin-hexware
 */
public class OrdersFactory {
  /**
   * Protected constructor.
   */
  protected OrdersFactory() {

  }

  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    final DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

  /**
   * @param cusId customer id.
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Orders[] showOrders(final int cusId) {
    final List<Orders> orders = dao().show(cusId);
    return orders.toArray(new Orders[orders.size()]);
  }

  /**
   * Call the data base connection.
   * @return int.
   * @param upordId set value
   */
  public static int updateOrdersTotal(final int upordId) {
    int i = dao().calTotal(upordId);
    return i;
  }

  /**
   * @param cId customer
   * @return integer
   */
  public static Orders gettOrdId(final int cId) {
    Orders i = dao().genOrdId(cId);
    return i;
  }

  /**
   *
   *
   * @param afoodId  for food Id.
   * @param quantity for storing quantity.
   * @param cusId    for storing cust id.
   * @param d1 for storing date.
   * @return int
   */
  public static int addOrders(final int cusId, final int quantity, final int afoodId, final Date d1) {
    int i = dao().addOrders(cusId, quantity, afoodId, d1);
    return i;
  }

/**
   * @param seordId for selecting order id
   * @return String
   */
/*   public static int selectOrders(final int seordId) {
    int i = dao().selectOrdering(seordId);
    return i;

  } */
  /**
   * @param cemail for getting email id
   * @return String
   */
 /*  public static int grandTotal(final String cemail) {
    int i = dao().calGrandTotal(cemail);
    return i;
  } */

/**
 * @param ordid ordid
 * @return integer
 */
  public static int updateOrdersToken(final int ordid) {
    int[] nums = new int[1000];
    Random randomGenerator = new Random();
    for (int f = 0; f < nums.length; ++f) {
      nums[f] = randomGenerator.nextInt(1000);
    }
    int f = 0;
    int i = dao().updateToken(nums[f], ordid);
    f = f + 1;
    return i;
  }

  /**
   * @param toke token
   * @param status status
   * @return integer
   */
  public static int updateStatus(final String status, final int toke) {
    int i = dao().orderStatus(status, toke);
    return i;
  }
  /**
   * @param cid s
   * @return dd
   */
  public static int checkcoup(final int cid) {
    Orders i = dao().checkcoup(cid);
    int j = i.getCusId();
    return j;
  }

  /**
   *
   *
   * @param afoodId  for food Id.
   * @param quantity for storing quantity.
   * @param cusId    for storing cust id.
   * @param d1 for storing date.
   * @param finalprice dd
   * @return int
   */
  public static int addOrdersoff(final int cusId, final int quantity, final int afoodId, final Date d1, final int finalprice) {
    int i = dao().addOrderoff(cusId, quantity, afoodId, d1, finalprice);
    return i;
  }
  /**
     * @return message.
     * @param  newOrders for orders.
     * */
  public static int insertingorder(final Orders newOrders) {
    final int i = dao().addOrders(newOrders.getCusId(), newOrders.getQuantity(), newOrders.getFoodId(), newOrders.getOrdDate());
    return i;
  }

  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Orders[] showFullOrders() {
    final List<Orders> orders = dao().showFullOrders();
    return orders.toArray(new Orders[orders.size()]);
  }

}


