package com.hexaware.MLP191.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
//import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.util.List;

//import com.hexaware.MLP191.factory.MenuFactory;
import com.hexaware.MLP191.model.Menu;

/**
 * MenuDAO class used to fetch data from data base.
 * @author thanuja-hexware
 */
public interface MenuDAO {
  /**
   * @return the all the Menu record.
   */
  @SqlQuery("Select * from Menu")
  @Mapper(MenuMapper.class)
  List<Menu> show();

  /**
   * @return the all the Menu records which matches the condition.
   * @param argId used as binding variable.
   */
  @SqlQuery("Select * from Menu where FOOD_ID = :argId")
  @Mapper(MenuMapper.class)
    Menu selectMenu(@Bind("argId") int argId);

  /**
   * @param fId food id.
   * @param fquantity quantity
   * @param fName food name
   * @param fCost food cost

   * @return inserted values
   */
  @SqlUpdate("INSERT INTO Menu(FOOD_ID, FOOD_NAME, FOOD_COST)" + " VALUES (:fId, :fName, :fCost)")
    int insertMenu(@Bind("fId") int fId, @Bind("fName") String fName, @Bind("fCost") int fCost, @Bind("fquantity") int fquantity);


  /**
   * @param cos for cost.
   * @param id id
   * @return integer
   */
  @SqlUpdate("Update Menu set FOOD_COST = :cos where FOOD_ID = :id")
   int updateMenu(@Bind("cos") int cos, @Bind("id") int id);


 /**
   * @param fid FOOD ID
   * @param quan quantity
   * @return integer
   */
  @SqlUpdate("update MENU set AVAIL_QUANTITY = (AVAIL_QUANTITY - :quan) where FOOD_ID = :fid")
   int updateQuantity(@Bind("quan") int quan, @Bind("fid") int fid);


   /**
   * @return the all the Menu records which matches the condition.
   * @param argtype used as binding variable.
   */
  @SqlQuery("Select * from Menu where FOOD_TYPE = :argtype")
  @Mapper(MenuMapper.class)
  List<Menu> typeMenu(@Bind("argtype") String argtype);


}

