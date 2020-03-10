
package com.hexaware.MLP191.util;

import java.util.Scanner;

/**
 * CliMain used as Client interface for java coding.
 * @Guru-hexware
 */
class CliMain {

  private static Scanner option = new Scanner(System.in, "UTF-8");
  private void mainMenu() {
    System.out.println("----------------------------");
    System.out.println("Canteen Management System");
    System.out.println("----------------------------");
    System.out.println("\n kindly Select ur RoLe");
    System.out.println();
    System.out.println("\n1.Customer");
    System.out.println("\n2.Vendor");
    System.out.println("\n3.Exit");
    System.out.println("----------------------------");
    mainMenuDetails();
  }
  private void mainMenuDetails() {
    /**
 * CliMain used as Client interface for java coding.
 * @guru-hexware
 */
    CustomerUtil cusUtil = new CustomerUtil();
      /**
 * CliMain used as Client interface for java coding.
 * @guru-hexware
 */
    VendorUtil venUtil = new VendorUtil();

    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          cusUtil.enterPagecus();
          break;
        case 2:
          venUtil.enterPageven();
          break;
        case 3:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2");
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }


  /**main method is the basic entry point for the application.
   * @param args use to get the user input.
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
