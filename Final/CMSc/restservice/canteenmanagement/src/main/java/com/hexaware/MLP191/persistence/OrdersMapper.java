package com.hexaware.MLP191.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP191.model.Orders;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * ordersMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orders
       */
    return new Orders(rs.getInt("ORD_ID"), rs.getDate("ORD_DATE"),
     rs.getInt("FOOD_ID"), rs.getInt("QUANTITY"), rs.getInt("TOTAL"), rs.getInt("CUS_ID"),
     rs.getString("ORD_STATUS"), rs.getInt("TOKEN"));
  }
}



