package com.hexaware.MLP191.model;


import java.util.Date;

/**
 * Menu class used to display menu information.
 * @author guru-hexware
 */
public class Customer {
/**
 * cusId to store cusId.
 */
  private int cusId;
  private String cusName;
  private long cusPhone;
  private Date cusDob;
  private String cusEmail;
  private int currAmt;
  private String password;
   /**
   * Default Constructor.
   */

  public Customer() {
  }
  /**
   * @param argcusId to initialise customer id
   * @param argcusName to initialise customer name
   * @param argcusPhone to initialise customer phone
   * @param argcusDob to initialise customer Dob
   * @param argcusEmail to initialise customer email
   * @param argcurrAmt to initialise customer Amt
   * @param argpassword to initialise customer password
   */
  public Customer(final int argcusId, final String argcusName,
      final long argcusPhone, final Date argcusDob, final String argcusEmail, final int argcurrAmt,
      final String argpassword) {
    this.cusId = argcusId;
    this.cusName = argcusName;
    this.cusPhone = argcusPhone;
    this.cusDob = new Date(argcusDob.getTime());
    this.cusEmail = argcusEmail;
    this.currAmt = argcurrAmt;
    this.password = argpassword;
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
    final Customer other = (Customer) obj;
    if (cusDob == null) {
      if (other.cusDob != null) {
        return false;
      }
    } else if (!cusDob.equals(other.cusDob)) {
      return false;
    }
    if (cusEmail == null) {
      if (other.cusEmail != null) {
        return false;
      }
    } else if (!cusEmail.equals(other.cusEmail)) {
      return false;
    }
    if (cusId == 0) {
      if (other.cusId != 0) {
        return false;
      }
    } else if (cusId != other.cusId) {
      return false;
    }
    if (cusName == null) {
      if (other.cusName != null) {
        return false;
      }
    } else if (!cusName.equals(other.cusName)) {
      return false;
    }
    if (password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!password.equals(other.password)) {
      return false;
    }
    if (currAmt == 0) {
      if (other.currAmt != 0) {
        return false;
      }
    } else if (currAmt != other.currAmt) {
      return false;
    }
    if (cusPhone != other.cusPhone) {
      return false;
    }
    return true;
  }
  @Override
    public final int hashCode() {
    final int prime = 31;
    long result = 1;
    //result = prime * result + ((cusAddr == null) ? 0 : cusAddr.hashCode());
    //result = prime * result + ((cusEmail == null) ? 0 : cusEmail.hashCode());
    //result = prime * result + ((cusId == null) ? 0 : cusId.hashCode());
    //result = prime * result + ((cusName == null) ? 0 : cusName.hashCode());
    result = prime * result + cusPhone;
    return (int) result;
  }
/**
 * @return cusId
 */
  public final int getCusId() {
    return cusId;
  }
/**
 *
 * @param argcusId settvalue
 */
  public final void setCusId(final int argcusId) {
    this.cusId = argcusId;
  }
/**
 *
 * @return cusName
 */
  public final String getCusName() {
    return cusName;
  }
/**
 *
 * @param argcusName settvalue
 */
  public final void setCusName(final String argcusName) {
    this.cusName = argcusName;
  }
/**
 * @return getcusPhone
 */
  public final long getcusPhone() {
    return cusPhone;
  }
  /**
  * @param argcusPhone settvalue
  */

  public final void setCusPhone(final Long argcusPhone) {
    this.cusPhone = argcusPhone;
  }
/**
 * @return getCusDob
 */
  public final Date getCusDob() {
    return new Date(cusDob.getTime());
  }
  /**
   * @param argcusDob settvalue
   */
  public final void setCusDob(final Date argcusDob) {
    this.cusDob = new Date(argcusDob.getTime());
  }
  /**
   * @return getcusEmail
   */
  public final String getCusEmail() {
    return cusEmail;
  }
/**
 * @param argcusEmail settvalue
 */
  public final void setCusEmail(final String argcusEmail) {
    this.cusEmail = argcusEmail;
  }
  /**
   * @return getcurrAmt
   */
  public final int getCurrAmt() {
    return currAmt;
  }
/**
 * @param argcurrAmt settvalue
 */
  public final void setCurrAmt(final int argcurrAmt) {
    this.currAmt = argcurrAmt;
  }
  /**
   * @return getpassword
   */
  public final String getpassword() {
    return password;
  }
/**
 * @param argpassword settvalue
 */
  public final void setpassword(final String argpassword) {
    this.password = argpassword;
  }
 /* public final Object spagecusemail() {
  return null;
}
public Object spagepasscon() {
return null;
}*/

}

