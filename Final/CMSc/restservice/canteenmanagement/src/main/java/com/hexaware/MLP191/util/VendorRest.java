package com.hexaware.MLP191.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.MLP191.factory.VendorFactory;
import com.hexaware.MLP191.model.Vendor;



/**
 * displaying vendor details.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns Vendor details.
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] listVendor() {
    final Vendor[] vendor = VendorFactory.showVendor();
    return vendor;
  }

    /**
   * Returns Customer details.
   * @return the Customer details
   * @param phno vendor
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/vendetails/{phno}")
  public final Vendor displayVenDetails(@PathParam("phno") final long phno) {
    final Vendor vendor = VendorFactory.displayVendorDetails(phno);
    return vendor;
  }

  /**
   * @param newVendor new vendor
   * @return status.
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addVendor")
  public final String addVendor(final Vendor newVendor) {
    String comment = "";
    final int venadd = VendorFactory.addVendor(newVendor.getVenName(), newVendor.getVenId(), newVendor.getvenPassword());
    if (venadd > 0) {
      comment = "{\" value \" : \" Vendor added successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not added  \"}";
    }
    return comment;

  }
  /**
   * @param newVendor new vendor
   * @return vendor
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateVendor")
  public final String updateVendor(final Vendor newVendor) {
    String comment = "";
    //final int carIns = CarFactory.insertCar(newCar);
    final int vendUpdate = VendorFactory.updateVendorr(newVendor.getvenPassword(), newVendor.getVenId());
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" Vendor updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor not updated  \"}";
    }
    return comment;

  }


   /**
   * @param newVendor new vendor
   * @return comment
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateVendorStatus")
  public final String updateVenStatuss(final Vendor newVendor) {
    String comment = "";
    final int vendUpdate = VendorFactory.updateVenStatus(newVendor.getVenStatus());
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" Vendor status updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor status not updated  \"}";
    }
    return comment;

  }

   /**
   * @param cusid new vendor
   * @param ordid new order.
   * @return comment
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateVendorWallet/{cusid}/{ordid}")
  public final String updatingVenWallett(@PathParam("cusid") final int cusid, @PathParam("ordid") final int ordid) {
    String comment = "";
    final int vendUpdate = VendorFactory.updatingVenWallet(cusid, ordid);
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" Vendor Wallet updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor Wallet not updated  \"}";
    }
    return comment;

  }

   /**
   * @param cusid new vendor
   * @param ordid new order.
   * @return comment
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/deductvendorwallet/{cusid}/{ordid}")
  public final String deductVenWallett(@PathParam("cusid") final int cusid, @PathParam("ordid") final int ordid) {
    String comment = "";
    final int vendUpdate = VendorFactory.deductVenWallet(cusid, ordid);
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" Vendor Wallet deducted successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor Wallet not deducted   \"}";
    }
    return comment;

  }

/*   /**
   * @param newVendor new vendor
   * @return comment
   *
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatingvendorofferwallet")
  public final String updatingVenWallettoff(final Vendor newVendor) {
    String comment = "";
    final int vendUpdate = VendorFactory.updatingVenWalletoff(newVendor.getCusId());
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" Vendor offers Wallet updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Vendor offers Wallet not updated   \"}";
    }
    return comment;

  } */

  /**
   * @param venId Vendor details.
   * @param password password
   * @return the Vendor details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/checkVendor/{venId}/{password}")
  public final Vendor checkk(@PathParam("venId") final long venId, @PathParam("password") final String password) {
    final Vendor vendor = VendorFactory.check(venId, password);
    return vendor;
  }
 /**
   * @param cusid new vendor
   * @return comment
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updatecustid/{cusid}")
  public final String updateCustId(@PathParam("cusid") final int cusid) {
    String comment = "";
    final int vendUpdate = VendorFactory.updateCustId(cusid);
    if (vendUpdate > 0) {
      comment = "{\" value \" : \" customer id updated successfully \"}";
    } else {
      comment = "{\" value \" : \" customer id not updated  \"}";
    }
    return comment;

  }


}
