package com.hexaware.MLP191.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP191.model.Customer;

/**
 * MenuDAO class used to fetch data from data base.
 * @author guru-hexware
 */
public interface CustomerDAO {
  /**
   * @return the all the Customer record.
   */
  @SqlQuery("Select * from Customer")
  @Mapper(CustomerMapper.class)
  List<Customer> show();

  /**
   * @return the all the Customer record.
   * @param dob     setvalue
   * @param name    setvalue
   * @param phno    setvalue
   * @param email   setvalue
   * @param amt     setvalue
   * @param passcon setpassword
   */
  @SqlUpdate("Insert into Customer (CUS_NAME, CUS_PHONE, CUS_DOB, CUS_EMAIL, CURR_AMT,CURR_PASS)"
      + "value(:name, :phno, :dob, :email, :amt, :passcon)")
  int addCustomer(@Bind("name") String name, @Bind("phno") Long phno,
      @Bind("email") String email, @Bind("amt") int amt, @Bind("passcon") String passcon, @Bind("dob") Date dob);

/**
 * @param upid updateid
 * @param uppass password
 * @return upid
 */
  @SqlUpdate("update Customer set CURR_PASS = (:uppass) WHERE CUS_ID = (:upid)")
  int updateCustomer(@Bind("uppass")String uppass, @Bind("upid")int upid);
  /**
 * @param cusemail customeremail
 * @param cuspass customerpassword
 * @return Customer datails
 */
  @SqlQuery("Select * from CUSTOMER Where CUS_EMAIL= :cusemail and CURR_PASS= :cuspass")
  @Mapper(CustomerMapper.class)
    Customer checkCustomer(@Bind("cusemail") String cusemail, @Bind("cuspass") String cuspass);

/**
 * @param email customerid
 * @return Customer datails
 */
  @SqlQuery("Select * from CUSTOMER Where CUS_EMAIL= :email")
  @Mapper(CustomerMapper.class)
    Customer customerDetails(@Bind("email") String email);

/**
 * @param cusid customer id
 * @param ordId order id
 * @return integer
 */
  @SqlUpdate("update CUSTOMER inner join ORDERS on CUSTOMER.CUS_ID= ORDERS.CUS_ID set CUSTOMER.CURR_AMT"
      + " = (CUSTOMER.CURR_AMT - ORDERS.TOTAL) where CUSTOMER.CUS_ID = :cusid and ORDERS.ORD_ID = :ordId")
    int updateWallet(@Bind("cusid") int cusid, @Bind("ordId") int ordId);

/**
* @param money money
* @param cusid customer id.
* @return money added.
*/
  @SqlUpdate("update CUSTOMER set CURR_AMT = (CURR_AMT + :money) where CUS_ID = :cusid")
    int addMoney(@Bind("money") int money, @Bind("cusid") int cusid);
/**
* @param cid customer id
* @param ordId order id
* @return integer
*/
  @SqlUpdate("update CUSTOMER inner join ORDERS on CUSTOMER.CUS_ID= ORDERS.CUS_ID set CUSTOMER.CURR_AMT"
      + " = (CUSTOMER.CURR_AMT + ORDERS.TOTAL) where CUSTOMER.CUS_ID = :cid and ORDERS.ORD_ID = :ordId")
    int returnCusMoney(@Bind("cid") int cid, @Bind("ordId") int ordId);

/**
* @param finalprice d
* @param cid id.
* @return m.
*/
  @SqlUpdate("update CUSTOMER set CURR_AMT = :finalprice where CUS_ID = :cid")
    int updateWalletoff(@Bind("finalprice") int finalprice, @Bind("cid") int cid);


}
