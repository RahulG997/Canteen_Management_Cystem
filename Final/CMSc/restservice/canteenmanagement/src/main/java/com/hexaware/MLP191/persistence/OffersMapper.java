package com.hexaware.MLP191.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP191.model.Offers;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * HistoryMapper class used to obtain History from database.
 * @author Santhosh-hexware
 */
public class OffersMapper implements ResultSetMapper<Offers> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Offers map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return offers
       */
    return new Offers(rs.getString("COUPON_CODE"), rs.getDate("DATE_OF_COUPON"), rs.getInt("CUS_ID"), rs.getDate("DATE_OF_COUPON_END"));
  }
}
