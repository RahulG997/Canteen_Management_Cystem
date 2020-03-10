package com.hexaware.MLP191.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP191.model.History;
import com.hexaware.MLP191.factory.HistoryFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/History")
public class HistoryRest {
  /**
   * Returns orders details.
   * @return the orders details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final History[] listOrders() {
    final History[] history = HistoryFactory.showHistory();
    return history;
  }
/**
 *
 * @param newHistory history
 * @return added successfully
 */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addhistory")
  public final String addhistory(final History newHistory) {
    String comment = "";
    final int hisIns = HistoryFactory.addrating(newHistory.getRating(), newHistory.getFeedback(), newHistory.getCusId());
    if (hisIns > 0) {
      comment = "{\" value \" : \" success \"}";
    } else {
      comment = "{\" value \" : \" not success \"}";
    }

    return comment;

  }
}
