package com.hexaware.MLP191.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLP191.model.Menu;
import com.hexaware.MLP191.factory.MenuFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Path("/showMenu")
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }

/**
 * @param newMenu menu
 * @return menu
 */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/addmenu")
  public final String addMenu(final Menu newMenu) {
    String comment = "";
    final int menuIns = MenuFactory.insertMenu(newMenu.getFoodId(), newMenu.getFoodName(), newMenu.getFoodCost(), newMenu.getAvailQuantity());
    if (menuIns > 0) {
      comment = "{\" value \" : \" Menu added successfully \"}";
    } else {
      comment = "{\" value \" : \" Menu not added  \"}";
    }

    return comment;

  }
/**
 * @param newMenu menu
 * @return menu
 */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateMenu")
  public final String updateMenu(final Menu newMenu) {
    String comment = "";
    final int menuUpdate = MenuFactory.updateMenu(newMenu.getFoodCost(), newMenu.getFoodId());
    if (menuUpdate > 0) {
      comment = "{\" value \" : \" Menu updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Menu not updated  \"}";
    }

    return comment;

  }

/**
 * @param menuId id
 * @return id
 */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/selectMenu/{id}")
  public final Menu selectMenu(@PathParam("id") final int menuId) {
    final Menu menu = MenuFactory.selectMenu(menuId);
    return menu;
  }

  /**
   * Returns Menu details.
   * @param type type of food
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/foodMenu/{type}")
  public final Menu[] foodMenu(@PathParam("type") final String type) {
    final Menu[] menu = MenuFactory.foodMenu(type);
    return menu;
  }


  /**
 * @param quant quantity
 * @param menuId foodid
 * @return menu
 */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateMenuQuantity/{quan}/{id}")
  public final String updateMenuQuantity(@PathParam("quan") final int quant, @PathParam("id") final int menuId) {
    String comment = "";
    //final int MenuIns = MenuFactory.insertMenu(newMenu);
    final int menuUpdateQuan = MenuFactory.updateQuantity(quant, menuId);
    if (menuUpdateQuan > 0) {
      comment = "{\" value \" : \" Menu updated successfully \"}";
    } else {
      comment = "{\" value \" : \" Menu not updated  \"}";
    }

    return comment;
  }


 /**
 * @param menuId id
 * @return id
 */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/selectMenuPrice/{id}")
  public final int selectMenuPrice(@PathParam("id") final int menuId) {
    final int menu = MenuFactory.selectMenuprice(menuId);
    return menu;
  }
}
