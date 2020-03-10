
package com.hexaware.MLP191.factory;

import com.hexaware.MLP191.persistence.CustomerDAO;
import com.hexaware.MLP191.persistence.DbConnection;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP191.model.Customer;
/**
 * MenuFactory class used to fetch customer data from database.
 * @author guru-hexware
 */
public class CustomerFactory {
  /**
   *  Protected constructor.
   */
  protected CustomerFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   */
  public static Customer[] showCustomer() {
    List<Customer> customer = dao().show();
    return customer.toArray(new Customer[customer.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param dob ss
   * @param name insertname.
   * @param phno insertphonenumber.
   * @param email insertemailid.
   * @param amt insertaddress.
   * @param passcon password
   */
  public static int addCustomer(final String name, final Long phno, final String email, final int amt, final String passcon, final Date dob) {
    int i =  dao().addCustomer(name, phno, email, amt, passcon, dob);
    return i;
  }
  /**
   * Call the data base connection.
   * @return the array of customer object.
   * @param upid updateid.
   * @param uppass updatepassword.
   */
  public static int updateCustomer(final String uppass, final int upid) {
    int i = dao().updateCustomer(uppass, upid);
    return i;
  }
  /**
   * @param lpagecusemail dispalys
   * @param lpagecuspass display
   * @return check
   */
  public static Customer check(final String lpagecusemail, final String lpagecuspass) {
    Customer c = dao().checkCustomer(lpagecusemail, lpagecuspass);
    return c;
  }

  /**
   * @param email dispalys.
   * @return check
   */
  public static Customer displayDetails(final String email) {
    Customer d = dao().customerDetails(email);
    return d;
  }

  /**
   * @param cusId customer id
   * @param ordId order id
   * @return integer
   */
  public static int deductAmount(final int cusId, final int ordId) {
    int i = dao().updateWallet(cusId, ordId);
    return i;
  }

   /**
   * @param cusId customer id.
   * @param money money.
   * @return money.
   */
  public static int addMoney(final int money, final int cusId) {
    int i = dao().addMoney(money, cusId);
    return i;
  }
  /**
   * @param cId order id
   * @param ordId order id
   * @return money
   */
  public static int returnMoney(final int cId, final int ordId) {
    int ded = dao().returnCusMoney(cId, ordId);
    return ded;
  }
 /**
  *
  * @param cid d
  * @param finalprice f
  * @return u
  */
  public static int deductAmountoff(final int cid, final int finalprice) {
    int i = dao().updateWalletoff(cid, finalprice);
    return i;
  }




}








