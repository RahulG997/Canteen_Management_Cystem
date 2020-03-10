package com.hexaware.MLP191.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;
import java.util.List;

import com.hexaware.MLP191.model.Customer;
import com.hexaware.MLP191.model.Orders;

/**
 * ordersDAO class used to fetch data from data base.
 *
 * @author hexware
 */

public interface OrdersDAO {

   /**
    * @param cusId customer id
    * @return the all the orders record.
    */
  @SqlQuery("Select * from Orders where CUS_ID = :cusId")
   @Mapper(OrdersMapper.class)
   List<Orders> show(@Bind("cusId") int cusId);

   /**
    * @return the all the orders record.
    */
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> showFullOrders();

   /**
    * @return the all the orders record.
    * @param ordId to get order id
    */
  // @SqlQuery("Select * from Orders where ORD_ID = :ordId")
  //  @Mapper(OrdersMapper.class)
  //  int selectOrdering(@Bind("ordId") int ordId);

   /**
    * @param cusId for storing email id.
    * @return calculated the grand total of the order.
  @SqlUpdate("update ORDERS SET GRAND_TOTAL=SUM(TOTAL) GROUP BY CUS_ID = cusId")
   int calGrandTotal(@Bind("cusId") String cusId); */

   /**
    * @param cusId customer id
    * @return order id
    */
  @SqlQuery("select * from ORDERS where ORD_DATE = (SELECT max(ORD_DATE) FROM ORDERS WHERE CUS_ID = :cusId)")
   @Mapper(OrdersMapper.class)
   Orders genOrdId(@Bind("cusId") int cusId);

   /**
    * @return Updated order.
    * @param ordid to update order
    */
  @SqlUpdate("update ORDERS inner join MENU on MENU.FOOD_ID=ORDERS.FOOD_ID set ORDERS.TOTAL"
         + "= (ORDERS.QUANTITY * MENU.FOOD_COST) where ORDERS.ORD_ID = :ordid")
   int calTotal(@Bind("ordid") int ordid);

   /**
    * @param foodId   add food id
    * @param quantity add quantity
    * @param cusId    add cus id
    * @param d1    add order date.
    * @return added orders
    */
  @SqlUpdate("insert into ORDERS(CUS_ID, QUANTITY, FOOD_ID, ORD_DATE) values(:cusId, :quantity, :foodId, :orddate)")
   int addOrders(@Bind("cusId") int cusId, @Bind("quantity") int quantity, @Bind("foodId") int foodId,
         @Bind("orddate") Date d1);



  /**
   * @param cid to delete
   * @return after deletion orders
   */
  @SqlQuery("select * from CUSTOMER where CUS_ID =:cid")
  @Mapper(CustomerMapper.class)
    Customer getAmount(@Bind("cid") int cid);
/**
 * @param token token
 * @param ordid order id
 * @return integer
 */
  @SqlUpdate("update ORDERS set TOKEN = :token where ORD_ID = :ordid")
    int updateToken(@Bind("token") int token, @Bind("ordid") int ordid);

  /**
   * @param ordid token.
   * @param ordStatus order status.
   * @return integer
   */
  @SqlUpdate("Update ORDERS set ORD_STATUS = :ordStatus where ORD_ID = :ordid")
    int orderStatus(@Bind("ordStatus") String ordStatus, @Bind("ordid") int ordid);

  /**
 *
 * @param cid d
 * @return int
 */
  @SqlQuery("select * from ORDERS where CUS_ID =:cid")
  @Mapper(OrdersMapper.class)
    Orders checkcoup(@Bind("cid") int cid);

   /**
    * @param foodId   add food id
    * @param quantity add quantity
    * @param cusId    add cus id
    * @param d1    add order date.
    * @param finalprice ff
    * @return added orders
    */
  @SqlUpdate("insert into ORDERS(CUS_ID, QUANTITY, FOOD_ID, ORD_DATE, TOTAL) values(:cusId, :quantity, :foodId, :orddate, :finalprice)")
    int addOrderoff(@Bind("cusId") int cusId, @Bind("quantity") int quantity, @Bind("foodId") int foodId,
          @Bind("orddate") Date d1, @Bind("finalprice") int finalprice);



}






