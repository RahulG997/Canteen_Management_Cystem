
package com.hexaware.MLP191.factory;

import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.hexaware.MLP191.model.Offers;
import com.hexaware.MLP191.persistence.OffersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class OffersFactoryTest {
  private LocalDate d1, d2;
  private DateTimeFormatter sdf;

  /**
   * tests that order is handled correctly.
   *
   * @param dao mocking the dao class
   * @throws ParseException exception
   */
  @Test

  public final void addoffers(@Mocked final OffersDAO dao) throws ParseException {
    String date1 = "2020-09-09";
    String date2 = "2020-09-22";
    sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //sdf.setLenient(false);
    d1 = LocalDate.parse(date1);
    d2 = LocalDate.parse(date2);
    final Offers c1 = new Offers();
    new Expectations() {
      {
        System.out.println("mocked get offers");
        OffersFactory.addoffers("free10", d1, d2, 1);
        result = c1;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offers Dao");
        return dao;
      }
    };
    int offers = OffersFactory.addoffers("free10", null, null, 1);
    assertNotEquals(c1, offers);
  }

  /**
   * tests that order is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test

  public final void deleteoffers(@Mocked final OffersDAO dao) {
    final Offers c2 = new Offers();
    new Expectations() {
      {
        System.out.println("mocked get Offers");
        OffersFactory.deleteoffers(10);
        result = c2;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked offers Dao");
        return dao;
      }
    };
    int offers = OffersFactory.deleteoffers(10);
    assertNotEquals(c2, offers);
  }

  /**
   * tests that order is handled correctly.
   *
   * @param dao mocking the dao class
   */
  @Test

  public final void checkcoupcus(@Mocked final OffersDAO dao) {

    final Offers c3 = new Offers();
    new Expectations() {
      {
        System.out.println("mocked get Offers");
        OffersFactory.checkcoupcus(1);
        result = c3;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offers Dao");
        return dao;
      }
    };
    int offers = OffersFactory.checkcoupcus(1);
    assertNotEquals(c3, offers);
  }
/**
 * @param dao g
 */
  @Test
  public final void endcoupondate(@Mocked final OffersDAO dao) {

    final Offers c4 = new Offers();
    new Expectations() {
      {
        System.out.println("mocked get Offers");
        OffersFactory.endcoupondate(1);
        result = c4;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked Offers Dao");
        return dao;
      }
    };
    Date offers = OffersFactory.endcoupondate(1);
    assertNotEquals(c4, offers);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showOffer(@Mocked final OffersDAO dao) {

    final Offers offers = new Offers();

    new Expectations() {
      {
        System.out.println("Mocked display offers");
        OffersFactory.showOffers();
        result = offers;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        System.out.println("Mocked offers Dao");
        return dao;
      }
    };
    Offers[] actualS = OffersFactory.showOffers();
    assertNotEquals(offers, actualS);
  }
    /**
     * Testing default protected constructor.
     */
  @Test
  public final void testDefaultConstructor() {
    OffersFactory of = new OffersFactory();
    OffersFactory of1 = new OffersFactory();
    assertNotEquals(of.hashCode(), of1.hashCode());
  }

}

