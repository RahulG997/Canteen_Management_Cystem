package com.hexaware.MLP191.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP191.model.Menu;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author thanuja-hexware
 */
public class MenuMapper implements ResultSetMapper<Menu> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Menu map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu*/
    return new Menu(rs.getInt("FOOD_ID"), rs.getString("FOOD_NAME"),
    rs.getInt("FOOD_COST"), rs.getInt("AVAIL_QUANTITY"), rs.getString("FOOD_TYPE"));
  }
}
