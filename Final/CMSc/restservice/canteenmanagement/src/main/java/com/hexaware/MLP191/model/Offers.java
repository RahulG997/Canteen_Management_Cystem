
package com.hexaware.MLP191.model;

//import java.time.LocalDate;
import java.util.Date;

/**
 * offers class used to display menu information.
 * @author santhosh-hexware
 */
public class Offers {

  private String couponCode;
  private Date dateOfcoupon;
  private Date dateOfcouponend;
  private int cusId;

    /**
     *
     */
  public Offers() {
  }

    /**
     * @param argcouponCode c
     * @param argdateOfcoupon c
     * @param argdateOfcouponend c
     * @param argcusId c
     */
  public Offers(final String argcouponCode, final Date argdateOfcoupon, final int argcusId,
      final Date argdateOfcouponend) {
    this.couponCode = argcouponCode;
    this.dateOfcoupon = argdateOfcoupon;
    this.cusId = argcusId;
    this.dateOfcouponend = argdateOfcouponend;
  }

    /**
     * @return the coupon_code
     */
  public final String getCouponCode() {
    return couponCode;
  }

    /**
     * @param argcouponCode the coupon_code to set
     */
  public final void setCouponCode(final String argcouponCode) {
    this.couponCode = argcouponCode;
  }

    /**
     * @return the dateOfcoupon
     */
  public final Date getDateOfcoupon() {
    return dateOfcoupon;
  }
    /**
     * @param argdateOfcoupon the dateOfcoupon to set
     */
  public final void setDateOfcoupon(final Date argdateOfcoupon) {
    this.dateOfcoupon = argdateOfcoupon;
  }

    /**
     * @return the cus_id
     */
  public final int getCusId() {
    return cusId;
  }

    /**
     * @param argcusId the cus_id to set
     */
  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }

  /**
     * @return the dateOfcouponend
     */
  public final Date getDateOfcouponend() {
    return dateOfcouponend;
  }
      /**
       * @param argdateOfcouponend the dateOfcoupon to set
       */
  public final void setDateOfcouponend(final Date argdateOfcouponend) {
    this.dateOfcouponend = argdateOfcouponend;
  }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */

  @Override
    public final int hashCode() {
    final int prime = 31;
    int result = 1;
    //result = prime * result + ((coupon_code == null) ? 0 : coupon_code.hashCode());
    result = prime * result + cusId;
    //result = prime * result + ((dateOfcoupon == null) ? 0 : dateOfcoupon.hashCode());
    return result;
  }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     * */

  @Override
    public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Offers)) {
      return false;
    }
    Offers other = (Offers) obj;
    if (couponCode == null) {
      if (other.couponCode != null) {
        return false;
      }
    } else if (!couponCode.equals(other.couponCode)) {
      return false;
    }
    if (cusId != other.cusId) {
      return false;
    }
    if (dateOfcoupon == null) {
      if (other.dateOfcoupon != null) {
        return false;
      }
    } else if (!dateOfcoupon.equals(other.dateOfcoupon)) {
      return false;
    }
    if (dateOfcouponend == null) {
      if (other.dateOfcouponend != null) {
        return false;
      }
    } else if (!dateOfcouponend.equals(other.dateOfcouponend)) {
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
    return "Offers [couponCode=" + couponCode + ", cusId=" + cusId + ", dateOfcoupon=" + dateOfcoupon
        + ", dateOfcouponend=" + dateOfcouponend + "]";
  }

}
