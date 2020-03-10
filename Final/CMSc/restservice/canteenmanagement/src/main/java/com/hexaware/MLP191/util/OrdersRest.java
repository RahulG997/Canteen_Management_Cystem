package com.hexaware.MLP191.util;




import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP191.model.Orders;


import com.hexaware.MLP191.factory.OrdersFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orders")
public class OrdersRest {
  /**
   * Returns order details.
   * @return the order details.
   * @param cusid for.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/listorders/{cusid}")
  public final Orders[] listOrders(@PathParam("cusid") final int cusid) {
    final Orders[] orders = OrdersFactory.showOrders(cusid);
    return orders;
  }

    /**
   * Returns order details.
   * @return the order details.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/fullorders")
  public final Orders[] listFullOrders() {
    final Orders[] orders = OrdersFactory.showFullOrders();
    return orders;
  }
 /**
   * Returns order details.
   * @return the order details
   * @param newOrders orders are return.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/placeOrder")
  public final String insertOrders(final Orders newOrders) {
    String comment = "";
    String comment1 = "";
    String comment2 = "";
    final int ordIns = OrdersFactory.insertingorder(newOrders);
    if (ordIns > 0) {
      //comment = "{\" value \" : \" Order added successfully \"}";
      int cId = newOrders.getCusId();
      if (cId > 0) {
        comment1 = "{\" value \" : \" cusid got successfully \"}";
        return comment1;
      }
      Orders orddid = OrdersFactory.gettOrdId(cId);
      int upordId = orddid.getOrdId();
      if (upordId > 0) {
        comment2 = "{\" value \" : \" upid got successfully \"}";
      }
      OrdersFactory.updateOrdersTotal(upordId);
      comment = "{\" value \" : \" Order added successfully \"}";
    } else {
      comment = "{\" value \" : \" Order not added  \"}";
      return comment;
    }

    return comment2;

  }






  //


     /**
   * Returns orders details.
   * @return the orders details
   * @param ordid orders .
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateorderstotal/{ordid}")
  public final String  updateOrdersTotal(@PathParam("ordid") final int ordid) {
    String comment = "";
    final int ordersUpdate = OrdersFactory.updateOrdersTotal(ordid);
    if (ordersUpdate > 0) {
      comment = "{\" value \" : \"  updated successfully... \"}";
    } else {
      comment = "{\" value \" : \"  not updated..  \"}";
    }

    return comment;

  }
  /**
   * Returns order details.
   * @return the order details.
   * @param cusid for orders.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/getordid/{cusid}")
  public final Orders  gettOrdId(@PathParam("cusid") final int cusid) {
    final Orders i = OrdersFactory.gettOrdId(cusid);
    return i;
  }

     /**
   * Returns order details.
   * @return the order details
   * @param ordid order.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateorderstoken/{ordid}")
  public final String  updateOrdersToken(@PathParam("ordid") final int ordid) {
    String comment = "";
    final int ordersUpdatetoken = OrdersFactory.updateOrdersToken(ordid);
    if (ordersUpdatetoken > 0) {
      comment = "{\" value \" : \"  updated token  successfully \"}";
    } else {
      comment = "{\" value \" : \" token not updated  \"}";
    }

    return comment;

  }
    /**
   * Returns order details.
   * @return the order details
   * @param status order.
   * @param ordId order id.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatestatus/{status}/{ordId}")
  public final String  updateStatus(@PathParam("status") final String status, @PathParam("ordId") final int ordId) {
    String comment = "";
    final int updatestatus = OrdersFactory.updateStatus(status, ordId);
    if (updatestatus > 0) {
      comment = "{\" value \" : \"  updated status  successfully \"}";
    } else {
      comment = "{\" value \" : \" status not updated  \"}";
    }

    return comment;

  }

  /**
   * Returns order details.
   * @return the order details.
   * @param cusid for orders.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/checkcoup/{cusid}")
  public final int  checkcoup(@PathParam("cusid") final int cusid) {
    final int i = OrdersFactory.checkcoup(cusid);
    return i;
  }

  /**
   * Returns order details.
   * @return the order details.
   * @param newOrders order details.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addordersoff")
  public final String addOrdersoff(final Orders newOrders) {
    String comment = "";
    final int ordersIns = OrdersFactory.addOrdersoff(newOrders.getCusId(), newOrders.getQuantity(), newOrders.getFoodId(), newOrders.getOrdDate(), newOrders.getTotal());
    if (ordersIns > 0) {
      comment = "{\" value \" : \" orders added successfully \"}";
    } else {
      comment = "{\" value \" : \" order is not added  \"}";
    }

    return comment;

  }


}
