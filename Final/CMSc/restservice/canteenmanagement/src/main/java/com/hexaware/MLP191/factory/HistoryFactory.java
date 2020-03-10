package com.hexaware.MLP191.factory;

import com.hexaware.MLP191.persistence.HistoryDAO;
import com.hexaware.MLP191.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP191.model.History;
/**
 * HistoryFactory class used to fetch History data from database.
 * @author Santhosh-hexware
 */
public class HistoryFactory {
  /**
   *  Protected constructor.
   */
  protected HistoryFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static HistoryDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(HistoryDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of History object.
   */
  public static History[] showHistory() {
    List<History> history = dao().show();
    return history.toArray(new History[history.size()]);
  }
/**
 * @param rate r
 * @param feedback f
 * @param cusid c
 * @return v
 */
  public static int addrating(final int rate, final String feedback, final int cusid) {
    int i = dao().addrating(rate, feedback, cusid);
    return i;
  }
}

