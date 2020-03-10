
package com.hexaware.MLP191.util;

/** */
public class Mobilevalid {

/** */
  protected Mobilevalid() { }

/**
* @param phoneNo phone number
* @return phone number
*/
  public static int isMobileValid(final long phoneNo) {
    int j = 0;
    int i = (int) (phoneNo / 1000000000);
//System.out.println(i);
    if (i >= 1 && i < 10) {
      j = 1;
      return j;
    }
    return j;
  }

}
