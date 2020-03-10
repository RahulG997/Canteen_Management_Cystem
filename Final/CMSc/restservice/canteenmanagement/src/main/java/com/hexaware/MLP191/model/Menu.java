package com.hexaware.MLP191.model;

/**
 * Menu class used to display menu information.
 * @author thanuja-hexware
 */
public class Menu {
  private int foodId;
  private  String foodName;
  private int foodCost;
  private int availQuantity;
  private String foodType;
/**
 *
 */
  public Menu() {
  }
  /**
   * @param argfoodId to initialize foodId.
   * @param argfoodName to initialize foodName.
   * @param argfoodCost to initialize foodCost.
   * @param argquantity to initialize QUANTITY.
   * @param argfoodType to initialise food type.
   */
  public Menu(final int argfoodId, final String argfoodName, final int argfoodCost, final int argquantity, final String argfoodType) {
    this.foodId = argfoodId;
    this.foodName = argfoodName;
    this.foodCost = argfoodCost;
    this.availQuantity = argquantity;
    this.foodType = argfoodType;
  }
  /**
   * @return argfoodId
   */
  public final int getFoodId() {
    return foodId;
  }
/**
 * @param argfoodId id
 * */
  public final void setFoodId(final int argfoodId) {
    this.foodId = argfoodId;
  }
/**
 * @return argfoodName
 */
  public final String getFoodName() {
    return foodName;
  }
/**
 * @param argfoodName name
 */
  public final void setFoodName(final String argfoodName) {
    this.foodName = argfoodName;
  }
/**
 * @return argfoodCost
 */
  public final int getFoodCost() {
    return foodCost;
  }
/**
 * @param argfoodCost cost
 */
  public final void setFoodCost(final int argfoodCost) {
    this.foodCost = argfoodCost;
  }
/**
 * @return argfoodType
 */
  public final String getFoodType() {
    return foodType;
  }
/**
 * @param argfoodType food types
 */
  public final void setFoodType(final String argfoodType) {
    this.foodType = argfoodType;
  }
   /**
   * @return the quantity
   */
  public final int getAvailQuantity() {
    return availQuantity;
  }
  /**
   * @param argquantity the quantity to set
   */
  public final void setAvailQuantity(final int argquantity) {
    this.availQuantity = argquantity;
  }



  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
*/

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + availQuantity;
    result = prime * result + foodCost;
   // result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
   // result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
    //result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */

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
    Menu other = (Menu) obj;
    if (availQuantity != other.availQuantity) {
      return false;
    }
    if (foodCost != other.foodCost) {
      return false;
    }
    if (foodId == 0) {
      if (other.foodId != 0) {
        return false;
      }
    } else if (foodId != other.foodId) {
      return false;
    }
    if (foodName == null) {
      if (other.foodName != null) {
        return false;
      }
    } else if (!foodName.equals(other.foodName)) {
      return false;
    }
    if (foodType == null) {
      if (other.foodType != null) {
        return false;
      }
    } else if (!foodType.equals(other.foodType)) {
      return false;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * @see java.lang.Object#toString()
   */

  @Override
  public final String toString() {
    return "Menu [availQuantity=" + availQuantity + ", foodCost=" + foodCost + ", foodId=" + foodId + ", foodName="
        + foodName + ", foodType=" + foodType + "]";
  }

}

