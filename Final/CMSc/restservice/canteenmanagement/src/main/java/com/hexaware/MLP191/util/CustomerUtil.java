
package com.hexaware.MLP191.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
//import java.util.Random;
import java.util.Scanner;

import com.hexaware.MLP191.factory.CustomerFactory;
import com.hexaware.MLP191.factory.HistoryFactory;
import com.hexaware.MLP191.factory.MenuFactory;
import com.hexaware.MLP191.factory.OffersFactory;
import com.hexaware.MLP191.factory.OrdersFactory;
import com.hexaware.MLP191.factory.VendorFactory;
import com.hexaware.MLP191.model.Customer;
import com.hexaware.MLP191.model.Menu;
import com.hexaware.MLP191.model.Orders;
//import com.hexaware.MLP191.util.SendMail;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
public class CustomerUtil {

  //private long vid;
  private Date d1;
  private int amount;
  private int cid;
  private final Scanner option = new Scanner(System.in, "UTF-8");
  private LocalDate datetoday = LocalDate.now();
  private String lpagecusemail;
  /**
   */
  public final void enterPagecus() {
    String spagecusname;
    String spagedob;
    String spagepass;
    String spagepasscon;
    int spagecusamt;
    String spagecusemail;
    long spagecusphno;
    String sotp;
    String otp;
    System.out.println("       ======================");
    System.out.println("          Welcome to CMS");
    System.out.println("        \nCustomer Version");
    System.out.println("           1.Signup");
    System.out.println("           2.login");
    System.out.println(" \n(Please Signup if you are First time Customer)");
    System.out.println(" \n\nEnter the choice: ");
    int pageoption = option.nextInt();
    switch (pageoption) {
      case 1:
        System.out.println("\n\nEnter ur Sweet Name: ");
        spagecusname = option.next();
        System.out.println("\nEnter ur phone Number: ");
        spagecusphno = option.nextLong();
        int sphnomsg;
        sphnomsg = Mobilevalid.isMobileValid(spagecusphno);
        if (sphnomsg == 1) {
          System.out.println("Thanks 4 for entering correct number");
        }
        if (sphnomsg == 0) {
          System.out.println("Plz enter valid Phone Number");
          enterPagecus();
        }
        System.out.println("\nEnter ur Date Of Birth (yyyy-mm-dd): ");
        spagedob = option.next();
        Date date1 = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //String dateInString = "07/06/2013";
        try {
          date1 = formatter.parse(spagedob);
          System.out.println(date1);
          System.out.println(formatter.format(date1));
        } catch (ParseException e) {
          e.printStackTrace();
        }
        System.out.println("\nEnter ur Email: ");
        spagecusemail = option.next();
        boolean message = MailValid.isMailValid(spagecusemail);
        if (message) {
          System.out.println("ur Email is a valid ONE");
        } else {
          System.out.println("Plz enter a valid Email");
          enterPagecus();
        }
        System.out.println("\nEnter ur current amount: ");
        spagecusamt = option.nextInt();
        System.out.println("\nEnter ur NEW Password: ");
        spagepass = option.next();
        System.out.println("\nConfirm ur NEW Password: ");
        spagepasscon = option.next();
        if (spagepass.equals(spagepasscon)) {
          System.out.println("\n\nPlz be calm we are sending OTP to ur Email");
          otp = SendMail.otpgen(spagecusemail);
          System.out.println("\n\nEnter the OTP : ");
          sotp = option.next();
          if (otp.equals(sotp)) {
            CustomerFactory.addCustomer(spagecusname, spagecusphno, spagecusemail, spagecusamt, spagepasscon, date1);
            System.out.println("\nSignup is Successful");
            System.out.println("\nPlz login to Continue");
            enterPagecus();
          }
        } else {
          System.out.println("\nWe request u 2 Signup again---Sorry 4 the inconvenience");
        }
        break;
      case 2:
        System.out.println("\nEnter user email: ");
        lpagecusemail = option.next();
        System.out.println("\nEnter the Password: ");
        String lpagecuspass = option.next();
        Customer c = CustomerFactory.check(lpagecusemail, lpagecuspass);
        cid = c.getCusId();
        amount = c.getCurrAmt();
        if (c.getCusEmail().equals(lpagecusemail) && c.getpassword().equals(lpagecuspass)) {
          System.out.println("\n\nHello " + lpagecusemail);
          System.out.println("\nStart Ordering ur YUMMY YUMMY foods");
          cusSettings();
        }
      default:
        System.out.println("");
        break;
    }
  }
  private void cusSettings() {
    System.out.println("-----------------------");
    System.out.println("1. Peronel Details");
    System.out.println("2. Wallet Details");
    System.out.println("3. Menu");
    System.out.println("4. Order");
    System.out.println("5. Rating and Feedback");
    System.out.println("6. Exit");
    cusDetails();
  }
        /**
         *customerOptions method process the option selected from cusdetails.
         */
  private void cusDetails() {
    try {
      System.out.println("Enter your choice:");
      final int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullDetails();
          break;
        case 2:
          Customer wall = CustomerFactory.displayDetails(lpagecusemail);
          int walletamount = wall.getCurrAmt();
          System.out.println("Current Amount is: " + walletamount);
          System.out.println("Do u want to recharge : (y/n)");
          String opt = option.next();
          if (opt.equals("y") || opt.equals("Y")) {
            System.out.println("Enter the amount you want to add :");
            int answ = option.nextInt();
            CustomerFactory.addMoney(answ, cid);
          }
          break;
        case 3:
          choiceMenu();
          break;
        case 4:
          showFullPlaceorder();
          break;
        case 5:
          rating();
          break;
        case 6:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose any option");
          break;
      }
    } catch (final Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    cusSettings();
  }
  private void showFullPlaceorder() {
    int ofooId;
    int oqua;
    System.out.println("1.Place Order \n2.Cancel order \n3.Display order \nEnter the your choice: ");
    final int sfochoice = option.nextInt();
    int coupid = 0;
    switch (sfochoice) {
      case 1: //for placing order
        Menu[] menu = MenuFactory.showMenu();
        System.out.println("Food_Id" + "\t" + "food_name" + "\t" + "food_Cost");
        for (Menu m : menu) {
          System.out.println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getFoodCost());
        }
        System.out.println("\n\n ***____*** CHOOSE FROM THE ABOVE MENU ***____***");
        System.out.println("Enter FoodId: ");
        ofooId = option.nextInt();
        System.out.println("Enter Quantity: ");
        oqua = option.nextInt();
        d1 = new Date();
        try {
          coupid = OrdersFactory.checkcoup(cid);
        } catch (Exception e) {
          System.out.println("loading..");
        }
        if (coupid != cid) {
          LocalDate dateend = datetoday.plusDays(15);
          System.out.println("\nCongrats You have won a lucky coupon \nUse code: free10 \noffer valid till :" + dateend + "\n\n(Use within 15 days to redeem this offer)");
          String cod = "free10";
          OffersFactory.addoffers(cod, datetoday, dateend, cid);
        }
        System.out.println("Do u have any coupon??");
        String couchoi = option.next();
        if (couchoi.equals("y")) {
          System.out.println("Plz enter the code: ");
          String ipcode = option.next();
          if (ipcode.equals("free10")) {
            int cuscoupid = 0;
            try {
              cuscoupid = OffersFactory.checkcoupcus(cid);
            } catch (Exception e) {
              System.out.println("loading..");
            }
            if (cuscoupid == cid) {
              Date endcoupondate = OffersFactory.endcoupondate(cid);
              String sendcoupon = endcoupondate.toString();
              String sdatetoday = datetoday.toString();
              LocalDate locendcoupon = LocalDate.parse(sendcoupon);
              LocalDate locdatetoday = LocalDate.parse(sdatetoday);
              long validity = ChronoUnit.DAYS.between(locdatetoday, locendcoupon);
              if (validity <= 15) {
                int amoin = MenuFactory.selectMenuprice(ofooId);
                float amo  = amoin * oqua;
                System.out.println(amo);
                float discount = (amo * 10) / 100;
                float finalpricefloat = amo - discount;
                int finalprice = Math.round(finalpricefloat);
                System.out.println("\nOriginal Price: " + amo + "\nDiscounted amount: " + discount + "\nFinal Price: " + finalprice);
                OrdersFactory.addOrdersoff(cid, oqua, ofooId, d1, finalprice);
                OffersFactory.deleteoffers(cid);
                Orders order = OrdersFactory.gettOrdId(cid);
                Menu me = MenuFactory.selectMenu(ofooId);
                if (oqua <=  me.getAvailQuantity()) {
                  VendorFactory.updateVenStatus("\nPlaced");
                  System.out.println("\nYour Order is Placed... :-)");
                  Customer custom = CustomerFactory.displayDetails(lpagecusemail);
                  amount = custom.getCurrAmt();
                  System.out.println(amount);
                  if (amount > finalprice) {
                    int amountpass = amount - finalprice;
                    int i = CustomerFactory.deductAmountoff(cid, amountpass);
                    if (i > 0) {
                      System.out.println("Your order is placed.Deducted amount successfully......!");
/*                       int[] nums = new int[30];
                      Random randomGenerator = new Random();
                      for (int f = 0; f < nums.length; ++f) {
                        nums[f] = randomGenerator.nextInt(30);
                      }
                      int f = 0; */
                      OrdersFactory.updateOrdersToken(order.getOrdId());
                      //System.out.println("token is :" + nums[f++]);
                      VendorFactory.updateCustId(cid);
                      VendorFactory.updatingVenWallet(cid, order.getOrdId());
                      MenuFactory.updateQuantity(ofooId, oqua);
                    }
                  } else {
                    rechargeOrcancel();
                  }
                } else {
                  VendorFactory.updateVenStatus("Rejected");
                  System.out.println("Sorry! We can't place your Order. The quantity of food item is not available....");
                  OrdersFactory.updateStatus("cancel", order.getToken());
                }
              }
              if (validity > 16) {
                System.out.println("\nOffer Period is EXPIRED!!");
              }
            }
          }
        }
        if (couchoi.equals("n")) {
          OrdersFactory.addOrders(cid, oqua, ofooId, d1);
          Orders order = OrdersFactory.gettOrdId(cid);
          OrdersFactory.updateOrdersTotal(order.getOrdId());
          Menu me = MenuFactory.selectMenu(ofooId);
          if (oqua <= me.getAvailQuantity()) {
            int vendor = VendorFactory.updateVenStatus("Accepted");
            if (vendor > 0) {
              System.out.println("Your Order is accepted.. :-)");
            }
            Customer cus = CustomerFactory.displayDetails(lpagecusemail);
            Orders order4 = OrdersFactory.gettOrdId(cid);
            amount = cus.getCurrAmt();
            if (amount >= order4.getTotal()) {
              int i = CustomerFactory.deductAmount(cid, order4.getOrdId());
              if (i > 0) {
                System.out.println("Your order is placed.Deducted amount successfully......!");
                VendorFactory.updateCustId(cid);
                int j = VendorFactory.updatingVenWallet(cid, order4.getOrdId());
                if (j > 0) {
                  System.out.println("Updated vendor wallet");
                }
                int k = MenuFactory.updateQuantity(oqua, ofooId);
                if (k > 0) {
                  System.out.println("updated menu quantity");
                }
                OrdersFactory.updateOrdersToken(order4.getOrdId());
                //System.out.println("token is :" + nums[f++]);
                //Orders order5 = OrdersFactory.gettOrdId(cid);
                int order2 = OrdersFactory.updateStatus("Accepted", order4.getOrdId());
                if (order2 > 0) {
                  System.out.println("order status updated");
                }
              }
            } else {
              System.out.println("Insufficient Balance \n1. Add money \n2. Cancel Order \nEnter your choice: ");
              int choice = option.nextInt();
              switch (choice) {
                case 1 :
                  System.out.println("Enter the amount : ");
                  int amt = option.nextInt();
                  int i = CustomerFactory.addMoney(amt, cid);
                  if (i > 0) {
                    System.out.println("Successfully added money to your wallet");
                  }
                  break;
                case 2:
                  int ded = VendorFactory.deductVenWallet(cid, order4.getOrdId());
                  if (ded > 0) {
                    System.out.println("");
                  }
                  int deduce = CustomerFactory.returnMoney(cid, order4.getOrdId());
                  if (deduce > 0) {
                    System.out.println("");
                  }
                  String str = "cancelled";
                  OrdersFactory.updateStatus(str, order4.getOrdId());
                  break;
                default:
                  System.out.println("Enter a valid option");
                  break;
              }
            }
          } else {
            int vendor = VendorFactory.updateVenStatus("Rejected");
            if (vendor > 0) {
              System.out.println("");
            }
            Orders order3 = OrdersFactory.gettOrdId(cid);
            int order2 = OrdersFactory.updateStatus("Rejected", order3.getOrdId());
            if (order2 > 0) {
              System.out.println("");
            }
            System.out.println("Sorry! We can't place your Order. The quantity of food item is not available....");
            String str = "cancelled";
            OrdersFactory.updateStatus(str, order.getOrdId());
          }
        }
        break;
      case 2:
        Orders order1 = OrdersFactory.gettOrdId(cid);
        VendorFactory.deductVenWallet(cid, order1.getOrdId());
        CustomerFactory.returnMoney(cid, order1.getOrdId());
        OrdersFactory.updateStatus("CANCELLED", order1.getOrdId());
        System.out.println("Cancelled Successfully..");
        break;
      case 3:
        showOrdersTable();
        break;
      default:
        System.out.println("Enter a valid option");
        break;
    }
  }
       /**
   * for showing orders.
   */
  public final void showOrdersTable() {
    Orders[] orders = OrdersFactory.showOrders(cid);
    System.out.print("OrderId" + "\t");
    System.out.print("FoodId" + "\t");
    System.out.print("TOTAL" + "\t");
    System.out.print("quantity" + "\t");
    System.out.print("cusId" + "\t");
    System.out.print("DATE" + "\t");
    System.out.print("STATUS" + "\t");
    System.out.println("TOKEN");
  //System.out.println("grand total");
  //System.out.println("Cost");
    for (Orders m : orders) {
      System.out.print(m.getOrdId() + "\t");
      System.out.print(m.getFoodId() + "\t");
      System.out.print(m.getTotal() + "\t");
      System.out.print(m.getQuantity() + "\t" + "\t");
      System.out.print(m.getCusId() + "\t");
      System.out.print(m.getOrdDate() + "\t");
      System.out.print(m.getOrdStatus() + "\t");
      System.out.println(m.getToken() + "\t");
    //System.out.println(m.getGrandTotal());
    }
  }

  //recharge or cancel
  private void rechargeOrcancel() {
    Orders order = OrdersFactory.gettOrdId(cid);
    System.out.println("OOPS!! insufficent balance recharge now \n1. Add money \n2. Cancel Order \nEnter your choice: ");
    int choice = option.nextInt();
    switch (choice) {
      case 1 :
        System.out.println("Current Amount: " + amount);
        System.out.println("Enter the amount u want 2 recharge: ");
        int amtt = option.nextInt();
        int amt = 0;
        amt = amtt + amount;
        int i = CustomerFactory.addMoney(amt, cid);
        if (i > 0) {
          System.out.println("Successfully added money to your wallet");
          System.out.println("Current Balance: " + amt);
        }
        break;
      case 2 :
        Orders ord = OrdersFactory.gettOrdId(cid);
        VendorFactory.deductVenWallet(cid, ord.getOrdId());
        CustomerFactory.returnMoney(cid, ord.getOrdId());
        String str = "cancel";
        OrdersFactory.updateStatus(str, order.getToken());
        break;
      default:
        System.out.println("Enter a valid option");
        break;
    }
  }

  // shoFullDetails is to display details
  private void showFullDetails() {
    System.out.println("1. display Details");
    System.out.println("2.Update Details");
    System.out.print("Enter the your choice: ");
    final int sgochoice = option.nextInt();
    switch (sgochoice) {
      case 1:

        //final int lpagecusemail = option.nextInt();
        final Customer d = CustomerFactory.displayDetails(lpagecusemail);
        System.out.print("CustomerId" + "\t");
        System.out.print("CustomerName" + "\t");
        System.out.print("CustomerPhoneNumber" + "\t");
        System.out.print("CustomerDOB" + "\t");
        System.out.print("Customeremail" + "\t");
        System.out.println("Amount" + "\t");
        System.out.print(d.getCusId() + "\t");
        System.out.print(d.getCusName() + "\t");
        System.out.print(d.getcusPhone() + "\t");
        System.out.print(d.getCusDob() + "\t");
        System.out.print(d.getCusEmail() + "\t");
        System.out.println(d.getCurrAmt() + "\t");
        break;
      case 2:
        System.out.println("update your PassWord: ");
        String cusPass = option.next();
        CustomerFactory.updateCustomer(cusPass, cid);
        System.out.println("/nUr password has been updated/n");
        break;
      default:
        break;
    }
  }


  //choicemenu for displaying menu
  /** */
  public final void choiceMenu() {
    String ans;
    do {
      System.out.println("****CHOOSE THE MENU OF YOUR CHOICE ****");
      System.out.println("1.PRESS 1 FOR SPECIFIC MENU_TYPE");
      System.out.println("2.PRESS 2 FOR FULL MENU");
      final int choice = option.nextInt();
      switch (choice) {
        case 1:
          System.out.println("ENTER VEG for VEGETERIAN FOOD ");
          System.out.println("ENTER NON-VEG for NON-VEGETERIAN FOOD ");
          String ftype = option.next();
          Menu[] menu  = MenuFactory.foodMenu(ftype);
          System.out.print("Food_Id" + "\t");
          System.out.print("food_name" + "\t");
          System.out.print("food_Cost" + "\t");
          System.out.println("food_type");
          for (final Menu m : menu) {
            System.out.print(m.getFoodId() + "\t");
            System.out.print(m.getFoodName() + "\t");
            System.out.print(m.getFoodCost() + "\t" + "\t");
            System.out.println(m.getFoodType());
          }
          break;
        case 2:
          Menu[] me = MenuFactory.showMenu();
          System.out.print("Food_Id" + "\t");
          System.out.print("food_name" + "\t");
          System.out.print("food_Cost" + "\t");
          System.out.println("food_type");
          for (Menu m : me) {
            System.out.print(m.getFoodId() + "\t");
            System.out.print(m.getFoodName() + "\t");
            System.out.print(m.getFoodCost() + "\t" + "\t");
            System.out.println(m.getFoodType());
          }
          break;
        default:
          break;
      }
      System.out.println("NOT YET DECIDED..?\nWANT TO VIEW MENU AGAIN ? \n \nENTER Y FOR yes & N FOR no :");
      ans = option.next();
    } while (ans.equals("y") || ans.equals("Y"));
  }

  //rating for the orders
  private void rating() {
    System.out.println("\nPlz Enter the feedback:");
    String feed = option.next();
    System.out.println("\nRate overall Performance OUT OF 5 :");
    int rate = option.nextInt();
    if (rate <= 5) {
      HistoryFactory.addrating(rate, feed, cid);
    }
    if (rate > 5) {
      System.out.println("plz enter a valid rating ");
      rating();
    }
  }
}
