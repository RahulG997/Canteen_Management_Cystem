package com.hexaware.MLP191.model;

import java.util.Date;

/**
 * Menu class used to display menu information.
 * @author Carolin-hexware
 */
public class Orders {
  /**
   * foodId to store foodId.
   */
  private int ordId;
  private Date ordDate;
  private int foodId;
  private int quantity;
  private int total;
  private int cusId;
  private int token;
  private String ordStatus;
   /**
   * Default Constructor.
   */
  public Orders() {

  }

/**
 *@param argOrdId to initialize order id
 *@param argOrdDate to initialize order date
 *@param argFoodId to initialize food id
 *@param argQuantity to initialize quantity
 *@param argTotal to initialize total
 * @param argCusId to initialise customer id
 * @param argOrdStatus to initialise token
 * @param argToken to initialise token
 * used to get details through constructor.
 */
  public Orders(final int argOrdId, final Date argOrdDate, final int argFoodId, final int argQuantity,
      final int argTotal, final int argCusId, final String argOrdStatus, final int argToken) {
    this.ordId = argOrdId;
    this.ordDate = new Date(argOrdDate.getTime());
    this.foodId = argFoodId;
    this.quantity = argQuantity;
    this.total = argTotal;
    this.cusId = argCusId;
    this.ordStatus = argOrdStatus;
    this.token = argToken;
  }
  /**
   * @param argToken to find order
   */
  public Orders(final int argToken) {
    this.token = argToken;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders other = (Orders) obj;
    if (cusId == 0) {
      if (other.cusId != 0) {
        return false;
      }
    } else if (cusId != other.cusId) {
      return false;
    }
    if (foodId == 0) {
      if (other.foodId != 0) {
        return false;
      }
    } else if (foodId != other.foodId) {
      return false;
    }
    if (ordDate == null) {
      if (other.ordDate != null) {
        return false;
      }
    } else if (!ordDate.equals(other.ordDate)) {
      return false;
    }
    if (ordId == 0) {
      if (other.ordId != 0) {
        return false;
      }
    } else if (ordId != other.ordId) {
      return false;
    }
    if (quantity != other.quantity) {
      return false;
    }
    if (token != other.token) {
      return false;
    }
    if (total != other.total) {
      return false;
    }
    if (ordStatus == null) {
      if (other.ordStatus != null) {
        return false;
      }
    } else if (!ordStatus.equals(other.ordStatus)) {
      return false;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    //result = prime * result + ((cusId == null) ? 0 : cusId.hashCode());
    //result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
    //result = prime * result + ((ordDate == null) ? 0 : ordDate.hashCode());
    //result = prime * result + ((ordId == null) ? 0 : ordId.hashCode());
    //result = prime * result + ((ordStatus == null) ? 0 : ordStatus.hashCode());
    result = prime * result + quantity;
    result = prime * result + token;
    result = prime * result + total;
    return result;
  }
  /**
     * @return this order ID.
     */
  public final int getOrdId() {
    return ordId;
  }
  /**
     * @param argordId gets the food id.
     */

  public final void setOrdId(final int argordId) {
    this.ordId = argordId;
  }
   /**
     * @return this order date.
     */
  public final Date getOrdDate() {
    return new Date(ordDate.getTime());
  }
   /**
     * @param argordDate gets the order date.
     */
  public final void setOrdDate(final Date argordDate) {
    this.ordDate = new Date(argordDate.getTime());
  }
   /**
     * @return this food ID.
     */
  public final int getFoodId() {
    return foodId;
  }
   /**
     * @param argfoodId gets the food id.
     */

  public final void setFoodId(final int argfoodId) {
    this.foodId = argfoodId;
  }
   /**
     * @return this quantity.
     */
  public final int getQuantity() {
    return quantity;
  }
   /**
     * @param argquantity gets the quantity.
     */

  public final void setQuantity(final int argquantity) {
    this.quantity = argquantity;
  }
   /**
     * @return this food ID.
     */
  public final int getTotal() {
    return total;
  }
   /**
     * @param argtotal gets the total.
     */

  public final void setTotal(final int argtotal) {
    this.total = argtotal;
  }
   /**
     * @return this food ID.
     */
  public final int getCusId() {
    return cusId;
  }
    /**
     * @param argcusId gets the customer id.
     */

  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }
   /**
     * @return this food ID.
     */
  public final int getToken() {
    return token;
  }
    /**
     * @param argtoken gets the token.
     */
  public final void setToken(final int argtoken) {
    this.token = argtoken;
  }
   /**
     * @return this order status.
     */
  public final String getOrdStatus() {
    return ordStatus;
  }
  /**
     * @param argordStatus gets the token.
     */
  public final void setOrdStatus(final String argordStatus) {
    this.ordStatus = argordStatus;
  }


  @Override
  public final String toString() {
    return "Orders [cusId=" + cusId + ", foodId=" + foodId + ", grandTotal=" + ", ordDate=" + ordDate
        + ", ordId=" + ordId + ", ordStatus=" + ordStatus + ", quantity=" + quantity + ", token=" + token + ", total="
        + total + "]";
  }
}






