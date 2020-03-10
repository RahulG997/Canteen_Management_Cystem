package com.hexaware.MLP191.factory;

import com.hexaware.MLP191.persistence.VendorDAO;
import com.hexaware.MLP191.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP191.model.Vendor;
/**
 * VendorFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   * Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }

  /**
   * Call the data base connection.
   * adding vendor.
   * @param id entered by the user for adding vendor.
   * @param name entered by the user for adding name.
   * @param pass entered by the user for adding password.
   * @return vendor.
   */
  public static int addVendor(final String name, final long id, final String pass) {
    int i = dao().addVend(name, id, pass);
    return i;
  }


  /**
   * Call the data base connection.
   * adding vendor.
   * @param id entered by the user for updating vendor.
   * @param pass entered by the user for updating vendor.
   * @return Status whether updated or not.
   */
  public static int updateVendorr(final String pass, final long id) {
    int k = dao().updateVend(pass, id);
    return k;
  }
  /**
   * @param lpagevenid id.
   * @param lpagevenpass password
   * @return list
   */
  public static Vendor check(final long lpagevenid, final String lpagevenpass) {
    Vendor v = dao().checkvendor(lpagevenid, lpagevenpass);
    return v;
  }

 /**
   * @param stat id
   * @return integer
   */
  public static int updateVenStatus(final String stat) {
    int k = dao().updateStatus(stat);
    return k;
  }

    /**
   * @param id id
   * @param oid order id
   * @return integer
   */
  public static int updatingVenWallet(final int id, final int oid) {
    int k = dao().updateVenWallet(id, oid);
    return k;
  }

  /**
   * @param oid order id
   * @param cId order id
   * @return money
   */
  public static int deductVenWallet(final int cId, final int oid) {
    int ded = dao().deduceVenWallet(cId, oid);
    return ded;
  }

   /**
   * @param id id
   * @return integer
   *
  public static int updatingVenWalletoff(final int id) {
    int k = dao().updateVenWalletoff(id);
    return k;
  }*/

  /**
   * @param phno phone no.
   * @return value
   */
  public static Vendor displayVendorDetails(final long phno) {
    Vendor v = dao().vendetails(phno);
    return v;
  }
   /**
   * @param id id
   * @return integer
   */
  public static int updateCustId(final int id) {
    int k = dao().updateCusId(id);
    return k;
  }


}
