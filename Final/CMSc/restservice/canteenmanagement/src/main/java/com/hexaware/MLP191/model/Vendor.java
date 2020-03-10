package com.hexaware.MLP191.model;


/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Vendor {
  /**
 * venId to store vendor's Id.
 * venName to store vendor's Name.
 * venPassword to store vendor's Password.
 * venWallet to store vendors wallet amount
 */
  public Vendor() {
  }
  private long venId;
  private String venName;
  private String venPassword;
  private float venWallet;
  private int cusId;
  private String venStatus;

  /**
 * @param argvenId gets the vendor id.
 * @param argvenName gets the vendor Name.
 * @param argvenPassword gets the vendor Password.
 * @param argvenWallet gets the vendor wallet amount.
 * @param argcusId gets the customer id
 * @param argvenStatus status
 */
  public Vendor(final long argvenId, final String argvenName, final String argvenPassword, final float argvenWallet,
      final int argcusId, final String argvenStatus) {
    this.venId = argvenId;
    this.venName = argvenName;
    this.venPassword = argvenPassword;
    this.venWallet = argvenWallet;
    this.cusId = argcusId;
    this.venStatus = argvenStatus;
  }

 /**
 * @return this Vendor ID.
 */
  public final long getVenId() {
    return venId;
  }

 /**
 * @param argvenId gets the vendor id.
 */
  public final void setVenId(final Long argvenId) {
    this.venId = argvenId;
  }

 /**
 * @return this Vendor Name.
 */
  public final String getVenName() {
    return venName;
  }

 /**
 * @param argvenName gets the vendor name.
 */
  public final void setVenName(final String argvenName) {
    this.venName = argvenName;
  }

 /**
 * @return this Vendor Password.
 */
  public final String getvenPassword() {
    return venPassword;
  }

 /**
 * @param argvenPassword gets the customer Id.
 */
  public final void setVenPassword(final String argvenPassword) {
    this.venPassword = argvenPassword;
  }

  /**
 * @return this Vendor Wallet.
 */
  public final float getVenWallet() {
    return venWallet;
  }

 /**
* @param argvenWallet gets the vendor Wallet amount.
*/
  public final void setVenWallet(final float argvenWallet) {
    this.venWallet = argvenWallet;
  }
  /**
 * @return this Vendor Status.
 */
  public final String getVenStatus() {
    return venStatus;
  }

/**
* @param argvenStatus status
*/
  public final void setVenStatus(final String argvenStatus) {
    this.venStatus = argvenStatus;
  }
 /**
 * @return this Vendor Password.
 */
  public final int getCusId() {
    return cusId;
  }
/**
* @param argcusId gets the vendor Wallet amount.
*/
  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }


  /*
   * (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + cusId;
    result = prime * result + (int) (venId ^ (venId >>> 32));
   // result = prime * result + ((venName == null) ? 0 : venName.hashCode());
    //result = prime * result + ((venPassword == null) ? 0 : venPassword.hashCode());
    //result = prime * result + ((venStatus == null) ? 0 : venStatus.hashCode());
    result = prime * result + Float.floatToIntBits(venWallet);
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
    if (!(obj instanceof Vendor)) {
      return false;
    }
    Vendor other = (Vendor) obj;
    if (cusId != other.cusId) {
      return false;
    }
    if (venId != other.venId) {
      return false;
    }
    if (venName == null) {
      if (other.venName != null) {
        return false;
      }
    } else if (!venName.equals(other.venName)) {
      return false;
    }
    if (venPassword == null) {
      if (other.venPassword != null) {
        return false;
      }
    } else if (!venPassword.equals(other.venPassword)) {
      return false;
    }
    if (venStatus == null) {
      if (other.venStatus != null) {
        return false;
      }
    } else if (!venStatus.equals(other.venStatus)) {
      return false;
    }
    if (Float.floatToIntBits(venWallet) != Float.floatToIntBits(other.venWallet)) {
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
    return "Vendor [cusId=" + cusId + ", venId=" + venId + ", venName=" + venName + ", venPassword=" + venPassword
        + ", venStatus=" + venStatus + ", venWallet=" + venWallet + "]";
  }

}
