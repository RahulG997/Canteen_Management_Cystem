
package com.hexaware.MLP191.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP191.model.Offers;
import com.hexaware.MLP191.factory.OffersFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/OffersRest")
public class OffersRest {
  /**
   * Returns offers details.
   *
   * @return the offers details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Offers[] listOrders() {
    final Offers[] offers = OffersFactory.showOffers();
    return offers;
  }
/**
 *
 * @param newOffers offers
 * @return offers
 */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addoffRest")
  public final String addoffRest(final Offers newOffers) {
    String comment = "";
    LocalDate couDate = newOffers.getDateOfcoupon().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate couEndDate = newOffers.getDateOfcouponend().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    final int offIns = OffersFactory.addoffers(newOffers.getCouponCode(), couDate, couEndDate, newOffers.getCusId());
    if (offIns > 0) {
      comment = "{\" value \" : \" Offers added successfully \"}";
    } else {
      comment = "{\" value \" : \" Offers not added  \"}";
    }
    return comment;
  }

  /**
   *
   *
   * @return Offers
   * @param cusid offers.
   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/checkcoupcusRest/{cusid}")
  public final String checkcoupRest(@PathParam("cusid")final int cusid) {
    String comment = "";
    final int checkcoup = OffersFactory.checkcoupcus(cusid);
    if (checkcoup > 0) {
      comment = "{\" value \" : \"  success \"}";
    } else {
      comment = "{\" value \" : \" not success  \"}";
    }

    return comment;

  }

  /**
   * Returns Vendor details.
   *
   * @return the Vendor details
   * @param cusid vendor.
   */
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/endcoupondateRest/{cusid}")
  public final String endcoupondateRest(@PathParam("cusid")final int cusid) {
    String comment = "";
    final Date enddate = OffersFactory.endcoupondate(cusid);
    if (enddate != null) {
      comment = "{\" value \" : \"  success \"}";
    } else {
      comment = "{\" value \" : \" not success  \"}";
    }

    return comment;

  }
}
