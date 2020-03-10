package com.hexaware.MLP191.model;

import com.hexaware.MLP191.persistence.OffersDAO;
import com.hexaware.MLP191.factory.OffersFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for offers.
 */
@RunWith(JMockit.class)
public class OffersTest {
  private Date d1;
  private Date d2;
  private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * setup method.
   * @throws ParseException exception
   */
  @Before
  public final void initInput() throws ParseException {
    String date1 = "2020-02-13";
    d1 = sdf.parse(date1);
    String date2 = "2020-02-28";
    d2 = sdf.parse(date2);

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testOffers() {
    Offers o1 = new Offers();
    Offers o2 = new Offers();
    assertNotEquals(o1, null);
    assertNotEquals(o2, null);
    assertEquals(o1.getCusId(), new Offers().getCusId());
    assertEquals(o1.getCouponCode(), new Offers().getCouponCode());
    //assertEquals(o1.getDateOfcoupon().getTime(), new Offers().getDateOfcoupon().getTime());
    //assertEquals(o1.getDateOfcouponend(), new Offers().getDateOfcouponend());
    o2.setCusId(5);
    assertEquals(5, o2.getCusId());
    o2.setCouponCode("free10");
    assertEquals("free10", o2.getCouponCode());
    o2.setDateOfcoupon(d1);
    assertEquals(d1, o2.getDateOfcoupon());
    o2.setDateOfcouponend(d2);
    assertEquals(d2, o2.getDateOfcouponend());
    assertNotEquals(o2, new Offers());
    assertEquals(o1.hashCode(),
        new Offers().hashCode());
    assertEquals(o1, new Offers());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final OffersDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Offers>();
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] me = OffersFactory.showOffers();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final OffersDAO dao) {
    final Offers o1 = new Offers();
    final Offers o2 = new Offers();
    final ArrayList<Offers> mn = new ArrayList<Offers>();
    new Expectations() {
      {
        mn.add(o1);
        mn.add(o2);
        dao.show(); result = mn;
      }
    };
    new MockUp<OffersFactory>() {
      @Mock
      OffersDAO dao() {
        return dao;
      }
    };
    Offers[] mn1 = OffersFactory.showOffers();
    assertEquals(2, mn1.length);
    assertEquals(new Offers().getCusId(),
        mn1[0].getCusId());
    assertEquals(new Offers().getCusId(),
        mn1[1].getCusId());
  }
/**
 * @throws ParseException exception
 *
 */
  @Test
  public final void testGettersOffers() throws ParseException {
    Offers offers = new Offers("free10", d1, 13, d2);
    assertEquals("free10", offers.getCouponCode());
    assertEquals(d1, offers.getDateOfcoupon());
    assertEquals(13, offers.getCusId());
    assertEquals(d2, offers.getDateOfcouponend());
  }

   /**
    * to test the setters for vendor.
    * @throws ParseException exception
    */
  @Test
   public final void testSettersOffers() throws ParseException {
    Offers offers = new Offers("free10", d1, 13, d2);
    offers.setCouponCode("free10");
    assertEquals("free10", offers.getCouponCode());
    offers.setDateOfcoupon(d1);
    assertEquals(d1, offers.getDateOfcoupon());
    offers.setCusId(13);
    assertEquals(13, offers.getCusId());
    offers.setDateOfcoupon(d2);
    assertEquals(d2, offers.getDateOfcouponend());
  }

   /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testDefaultConstructor() {
    Offers offers = new Offers();
    assertEquals(offers.hashCode(), new Offers().hashCode());
  }
     /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testParameterisedConstructor() {
    Offers offers = new Offers("free10", d1, 13, d2);
    Offers offers1 = new Offers("free10", d1, 13, d2);
    assertEquals(offers.getCouponCode(), offers1.getCouponCode());

  }

}
