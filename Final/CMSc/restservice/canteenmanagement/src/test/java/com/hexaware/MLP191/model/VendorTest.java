package com.hexaware.MLP191.model;

import com.hexaware.MLP191.factory.VendorFactory;

import com.hexaware.MLP191.persistence.VendorDAO;

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
import java.util.ArrayList;

/**
 * Test class for Vendor.
 */
@RunWith(JMockit.class)
public class VendorTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the Vendor class.
   */
  @Test
  public final void testVendor() {
    //Vendor v = new Vendor();
    Vendor v100 = new Vendor();
    Vendor v101 = new Vendor();
    assertNotEquals(v100, null);
    assertNotEquals(v101, null);
    assertEquals(v100.getVenId(), new Vendor().getVenId());
    assertEquals(v100.getVenName(), new Vendor().getVenName());
    assertEquals(v100.getvenPassword(), new Vendor().getvenPassword());
    assertEquals(v100.getVenWallet(), new Vendor().getVenWallet(), 0);
    assertEquals(v100.getCusId(), new Vendor().getCusId());
    assertEquals(v100.getVenId(), new Vendor().getVenId());
    v101.setVenId(8109934355L);
    assertNotEquals(v101, new Vendor());
    assertEquals(v100.hashCode(), new Vendor().hashCode());
    assertEquals(v100, new Vendor());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final VendorDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Vendor>();

      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] ve = VendorFactory.showVendor();
    assertEquals(0, ve.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final VendorDAO dao) {
    final Vendor v100 = new Vendor();
    final Vendor v101 = new Vendor();
    final ArrayList<Vendor> vn = new ArrayList<Vendor>();
    new Expectations() {
      {
        vn.add(v100);
        vn.add(v101);
        dao.show();
        result = vn;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] vn1 = VendorFactory.showVendor();
    assertEquals(2, vn1.length);
    assertEquals(new Vendor().getVenId(), vn1[0].getVenId());
    assertEquals(new Vendor().getVenId(), vn1[1].getVenId());
  }

  /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testDefaultConstructor() {
    Vendor vendor = new Vendor();
    assertEquals(vendor.hashCode(), new Vendor().hashCode());
  }

  /**
   * to test the getters for vendor.
   */
  @Test
  public final void testGettersVendors() {
    Vendor vendor = new Vendor(8109934355L, "Mahima", "password", 1000, 2, "accepted");
    assertEquals(8109934355L, vendor.getVenId());
    assertEquals("Mahima", vendor.getVenName());
    assertEquals("password", vendor.getvenPassword());
    assertEquals(1000, vendor.getVenWallet(), 0);
    assertEquals(2, vendor.getCusId());
    assertEquals("accepted", vendor.getVenStatus());
  }

   /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersVendors() {
    Vendor vendor = new Vendor(8109934355L, "Mahima", "password", 1000, 2, "accepted");
    vendor.setVenId(9479495798L);
    assertEquals(9479495798L, vendor.getVenId());
    vendor.setVenName("Thanuja");
    assertEquals("Thanuja", vendor.getVenName());
    vendor.setVenPassword("password");
    assertEquals("password", vendor.getvenPassword());
    vendor.setVenWallet(1000);
    assertEquals(1000, vendor.getVenWallet(), 0);
    vendor.setCusId(2);
    assertEquals(2, vendor.getCusId());
    vendor.setVenStatus("accepted");
    assertEquals("accepted", vendor.getVenStatus());
  }
}
