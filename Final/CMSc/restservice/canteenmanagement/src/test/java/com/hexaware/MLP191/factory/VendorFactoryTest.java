
package com.hexaware.MLP191.factory;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.hexaware.MLP191.model.Vendor;
import com.hexaware.MLP191.persistence.VendorDAO;

import org.junit.Assert;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class VendorFactoryTest {
  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showVendor(@Mocked final VendorDAO dao) {

    final Vendor vendor = new Vendor();
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        VendorFactory.showVendor();
        result = vendor;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor[] actualS = VendorFactory.showVendor();
    assertNotEquals(vendor, actualS);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void updateVendorr(@Mocked final VendorDAO dao) {
    final Vendor v5 = new Vendor();
    new Expectations() {
      {
        System.out.println("mocked get vendor");
        int v5 = VendorFactory.updateVendorr("mahima", 8109934355L);
        result = v5;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ve = VendorFactory.updateVendorr("mahima", 8109934355L);
    assertNotEquals(v5, ve);
  }

  /**
   * @param dao DAO FILE
   */
  @Test
  public final void check(@Mocked final VendorDAO dao) {

    final Vendor vendor = new Vendor();
    new Expectations() {
      {
        System.out.println("Mocked find a Vendor");
        VendorFactory.check(9479495799L, "Thanuja");
        result = vendor;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    Vendor ve = VendorFactory.check(8109934355L, "mahima");
    assertEquals(vendor, ve);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void updateVenStatus(@Mocked final VendorDAO dao) {
    final Vendor v = new Vendor();
    new Expectations() {
      {
        System.out.println("mocked get vendor");
        int v = VendorFactory.updateVenStatus("mahima");
        result = v;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ve = VendorFactory.updateVenStatus("mahima");
    Assert.assertNotEquals(v, ve);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void updatingVenWallet(@Mocked final VendorDAO dao) {
    final Vendor v = new Vendor();
    new Expectations() {
      {
        System.out.println("mocked get vendor");
        int v = VendorFactory.updatingVenWallet(500, 2);
        result = v;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ve = VendorFactory.updatingVenWallet(500, 2);
    assertNotEquals(v, ve);
  }

  /**
   * @param dao dao file
   */
  @Test
  public final void deductVenWallet(@Mocked final VendorDAO dao) {
    final Vendor v = new Vendor();
    new Expectations() {
      {
        System.out.println("mocked get vendor");
        int v = VendorFactory.deductVenWallet(500, 2);
        result = v;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ve = VendorFactory.deductVenWallet(500, 2);
    assertNotEquals(v, ve);
  }


  /**
   * @param dao dao file
   */
  @Test
  public final void testAddVendor(@Mocked final VendorDAO dao) {
    final int v = 0;
    new Expectations() {
      {
        System.out.println("mocked get vendor");
        int v = VendorFactory.addVendor("Carolin", 9345188912L, "carolin123");
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ve = VendorFactory.addVendor("Carolin", 2233114455L, "carolin123");
    assertEquals(v, ve);
  }
    /**
     * Testing default protected constructor.
     */
  @Test
  public final void testDefaultConstructor() {
    VendorFactory ov = new VendorFactory();
    VendorFactory ov1 = new VendorFactory();
    assertNotEquals(ov.hashCode(), ov1.hashCode());
  }
/**
  * @param dao dao file
  */
  @Test
  public final void updateCustId(@Mocked final VendorDAO dao) {
    final Vendor v = new Vendor();
    new Expectations() {
      {
        System.out.println("mocked get vendor");
        int v = VendorFactory.updateCustId(2);
        result = v;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("Mocked Vendor Dao");
        return dao;
      }
    };
    int ve = VendorFactory.updateCustId(2);
    Assert.assertNotEquals(v, ve);
  }


}

