package com.hexaware.MLP191.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

import com.hexaware.MLP191.model.Vendor;
/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from vendors")
    @Mapper(VendorMapper.class)
    List<Vendor> show();

    /**
     * @param id for adding vendor id.
     * @param name for adding name.
     * @param pass for adding password.
     * @return all the details.
     */
  @SqlUpdate("Insert into vendors(VEN_ID, VEN_NAME, VEN_PASS)" + "values (:id, :name, :pass)")
    int addVend(@Bind("name") String name, @Bind("id") long id, @Bind("pass") String pass);


  /**
     * @param id for updating Vendor details.
     * @param pass for updating Vendor password.
     * @return all the details.
     */
  @SqlUpdate("update vendors set VEN_PASS = (:pass) where VEN_ID = (:id)")
     int updateVend(@Bind("pass") String pass, @Bind("id") long id);
    /**
     * @param lpagevenid id
     * @param lpagevenpass password
     * @return login
     */
  @SqlQuery("Select * from VENDORS Where VEN_ID= :lpagevenid and VEN_PASS= :lpagevenpass")
  @Mapper(VendorMapper.class)
      Vendor checkvendor(@Bind("lpagevenid") long lpagevenid, @Bind("lpagevenpass") String lpagevenpass);

      /**
 * @param cusid getting customer id
 * @param oid order id.
 * @return integer
 */
  @SqlUpdate("update vendors inner join orders on ORDERS.CUS_ID = VENDORS.CUS_ID SET VENDORS.VEN_WALLET "
       + " = (VENDORS.VEN_WALLET + ORDERS.TOTAL) where VENDORS.CUS_ID = :cusid and ORDERS.ORD_ID = :oid")
   int updateVenWallet(@Bind("cusid") int cusid, @Bind("oid") int oid);

 /**
  * @param status getting status
  * @return integer
  */
  @SqlUpdate("update VENDORS set VEN_STATUS = :status")
  int updateStatus(@Bind("status") String status);

/**
* @param cid customer id.
* @param oid order id.
* @return updated rows.
*/
  @SqlUpdate("update vendors inner join orders on ORDERS.CUS_ID = VENDORS.CUS_ID SET VENDORS.VEN_WALLET "
      + " = (VENDORS.VEN_WALLET - ORDERS.TOTAL) where VENDORS.CUS_ID = :cid and ORDERS.ORD_ID = :oid")
  int deduceVenWallet(@Bind("cid") int cid, @Bind("oid") int oid);


 /* /**
 * @param cusid getting customer id
 * @return integer
 *
  @SqlUpdate("update vendors inner join orders on ORDERS.CUS_ID = VENDORS.CUS_ID SET VENDORS.VEN_WALLET "
      + " = VENDORS.VEN_WALLET + ORDERS.TOTAL where ORDERS.CUS_ID = :cusid")
      int updateVenWalletoff(@Bind("cusid") int cusid); */


/**
 * @param phno customerid
 * @return Customer datails
 */
  @SqlQuery("Select * from VENDORS Where VEN_ID= :phno")
  @Mapper(VendorMapper.class)
    Vendor vendetails(@Bind("phno") long phno);


/**
  * @param cusid cusid
  * @return integer
  */
  @SqlUpdate("update vendors set CUS_ID = :cusid")
  int updateCusId(@Bind("cusid") int cusid);


}
