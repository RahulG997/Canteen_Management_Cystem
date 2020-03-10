package com.hexaware.MLP191.factory;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.hexaware.MLP191.model.Offers;
import com.hexaware.MLP191.persistence.DbConnection;
import com.hexaware.MLP191.persistence.OffersDAO;
/**
 * OffersFactory class used to fetch History data from database.
 * @author Santhosh-hexware
 */
public class OffersFactory {
  /**
   *  Protected constructor.
   */
  protected OffersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OffersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OffersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of offers object.
   */
  public static Offers[] showOffers() {
    List<Offers> offers = dao().show();
    return offers.toArray(new Offers[offers.size()]);
  }
  /**
   *
   * @param cod yy
   * @param dateend yy
   * @param datetoday u
   * @param cid yy
   * @return rows
   */
  public static int addoffers(final String cod, final LocalDate datetoday, final LocalDate dateend, final int cid) {
    int i = dao().addoffers(cod, datetoday, dateend, cid);
    return i;
  }
  /**
   *
   * @param cid f
   * @return integer
   */
  public static int deleteoffers(final int cid) {
    int j = dao().deleteoffers(cid);
    return j;
  }
/**
 *
 * @param cid g
 * @return g
 */
  public static int checkcoupcus(final int cid) {
    Offers i = dao().checkcoupcus(cid);
    int j = i.getCusId();
    return j;
  }
  /**
   * @param cid d
   * @return integer
   */
  //public static Date startcoupondate(final int cid) {
    //Offers u = dao().coupondate(cid);
    //Date i = u.getDateOfcoupon();
    //return i;
  //}

  /**
   * @param cid d
   * @return integer
   */
  public static Date endcoupondate(final int cid) {
    Offers u = dao().coupondate(cid);
    Date i = u.getDateOfcouponend();
    return i;
  }

}

