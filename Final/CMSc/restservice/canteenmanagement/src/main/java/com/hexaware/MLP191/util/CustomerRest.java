package com.hexaware.MLP191.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP191.model.Customer;
import com.hexaware.MLP191.factory.CustomerFactory;

/**
 * This class provides a REST interface for the customer entity.
 */
@Path("/customer")
public class CustomerRest {
  /**
   * Returns Customer details.
   * @return the Customer details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] listCustomer() {
    final Customer[] customer = CustomerFactory.showCustomer();
    return customer;
  }
   /**
   * @param newCustomer new customer
   * @return status.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addCustomer")
  public final String addCustomer(final Customer newCustomer) {
    String comment = "";
    final int cusadd = CustomerFactory.addCustomer(newCustomer.getCusName(), newCustomer.getcusPhone(), newCustomer.getCusEmail(),
        newCustomer.getCurrAmt(), newCustomer.getpassword(), newCustomer.getCusDob());
    SendMail.otpgen(newCustomer.getCusEmail());
    if (cusadd > 0) {
      comment = "{\" value \" : \" Customer added successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer not added  \"}";
    }
    return comment;
  }

   /**
   * Returns Customer details.
   * @return the Customer details
   * @param newCustomer customer.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateCustomer")
  public final String updateCustomer(final Customer newCustomer) {
    String comment = "";
    final int customerUpdate = CustomerFactory.updateCustomer(newCustomer.getpassword(), newCustomer.getCusId());
    if (customerUpdate > 0) {
      comment = "{\" value \" : \" Customer updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Customer not updated  \"}";
    }

    return comment;

  }
   /**
   *
   * @return Customer
   * @param cname customer.
   * @param cpwd customer.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/check/{cname}/{cpwd}")
  public final Customer check(@PathParam("cname")final String cname, @PathParam("cpwd")final String cpwd) {

    final Customer i = CustomerFactory.check(cname, cpwd);
    return i;

  }


  /**
   * Returns Customer details.
   * @return the Customer details
   * @param email Customer.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/displayDetails/{email}")
  public final Customer displayDetails(@PathParam("email") final String email) {
    final Customer customer = CustomerFactory.displayDetails(email);
    return customer;
  }
   /**
    * Returns Customer details.
    @return the.
    @param cusid for.
    @param ordid for.
    */
  @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/deductAmount/{cusid}/{ordid}")
   public final String deductAmount(@PathParam("cusid") final int cusid, @PathParam("ordid") final int ordid) {
    String comment = "";
    final int amountdeduct = CustomerFactory.deductAmount(cusid, ordid);
    if (amountdeduct > 0) {
      comment = "{\" value \" : \" Amount updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Amount not updated  \"}";
    }

    return comment;

  }
  /**
   * Returns Customer details.
   * @return the Customer details
   * @param cusid cuatomer.
   * @param curramt current amount.
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addmoney/{curramt}/{cusid}")
  public final String addmoney(@PathParam("curramt")final int curramt, @PathParam("cusid")final int cusid) {
    String comment = "";
    final int moneyAdd = CustomerFactory.addMoney(curramt, cusid);
    if (moneyAdd > 0) {
      comment = "{\" value \" : \" Money added successfully \"}";
    } else {
      comment = "{\" value \" : \" Money not added  \"}";
    }
    return comment;
  }
  /**
    * Returns Customer details.
    @return the.
    @param cusid for.
    @param ordid for.
    */
  @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/returnMoney/{cusid}/{ordid}")
    public final String returnMoney(@PathParam("cusid")final int cusid, @PathParam("ordid")final int ordid) {
    String comment = "";
    final int moneyreturn = CustomerFactory.returnMoney(cusid, ordid);
    if (moneyreturn > 0) {
      comment = "{\" value \" : \" Amount returned successfully \"}";
    } else {
      comment = "{\" value \" : \" Amount not returned  \"}";
    }
    return comment;
  }
  /**
    * Returns Customer details.
    @return the.
    @param newCustomer for.
    */
  @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deductAmountoff")
    public final String deductAmountoff(final Customer newCustomer) {
    String comment = "";
    final int moneyreturn = CustomerFactory.deductAmountoff(newCustomer.getCusId(), newCustomer.getCurrAmt());
    if (moneyreturn > 0) {
      comment = "{\" value \" : \" Amount deducted successfully \"}";
    } else {
      comment = "{\" value \" : \" Amount not deducted \"}";
    }
    return comment;
  }
}



