package com.hexaware.MLP191.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP191.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch customer data from database.
 * @author guru-hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    return new Customer(rs.getInt("CUS_ID"), rs.getString("CUS_NAME"),
     rs.getLong("CUS_PHONE"), rs.getDate("CUS_DOB"), rs.getString("CUS_EMAIL"),
    rs.getInt("CURR_AMT"), rs.getString("CURR_PASS"));
  }
}

