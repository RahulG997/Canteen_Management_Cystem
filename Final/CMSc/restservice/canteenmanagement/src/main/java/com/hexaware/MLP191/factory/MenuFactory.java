package com.hexaware.MLP191.factory;

import com.hexaware.MLP191.persistence.MenuDAO;
import com.hexaware.MLP191.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP191.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author thanuja-hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> me = dao().show();
    return me.toArray(new Menu[me.size()]);
  }
  /**
   * @param foodId for food id.
   * @return integer
   */
  public static Menu selectMenu(final int foodId) {
    Menu menu = dao().selectMenu(foodId);
    //System.out.println(menu.getFoodName());
    return menu;
  }
  /** @return message.
   * @param fid gets food id.
   * @param fname gets food name.
   * @param fquantity gets food quantity.
   * @param fcost gets food cost.
   */
  //Scanner sc=new Scanner(System.in);
  public static int insertMenu(final int fid, final String fname, final int fcost, final int fquantity) {

    int i = dao().insertMenu(fid, fname, fcost, fquantity);
    return i;
  }
  /**
   * @param fcost for cost.
   * @param fid for id
   * @return integer
   */
  public static int updateMenu(final int fcost, final int fid) {
    int i = dao().updateMenu(fcost, fid);
    return i;
  }

/**
   * @param ftype for deleting
   * @return integer
   */
  public static Menu[] foodMenu(final String ftype) {
    List<Menu> menu = dao().typeMenu(ftype);
    return menu.toArray(new Menu[menu.size()]);
  }



  /**
   * @param fid for food id.
   * @param quan for quantity.
   * @return integer
   */
  public static int updateQuantity(final int quan, final int fid) {
    int i = dao().updateQuantity(quan, fid);
    return i;
  }
 /**
   * @param foodId for food id.
   * @return integer
   */
  public static int selectMenuprice(final int foodId) {
    Menu u = dao().selectMenu(foodId);
    int i = u.getFoodCost();
    return i;
  }
}
