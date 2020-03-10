
package com.hexaware.MLP191.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP191.model.History;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * HistoryMapper class used to obtain History from database.
 * @author Santhosh-hexware
 */
public class HistoryMapper implements ResultSetMapper<History> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final History map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return History
       */
    return new History(rs.getInt("rating"), rs.getString("feedback"), rs.getInt("ord_id"), rs.getInt("cus_id"));
  }
}
