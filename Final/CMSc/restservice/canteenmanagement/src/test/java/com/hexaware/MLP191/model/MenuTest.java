package com.hexaware.MLP191.model;

import com.hexaware.MLP191.persistence.MenuDAO;
import com.hexaware.MLP191.factory.MenuFactory;

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
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the menu class.
   */
  @Test
  public final void testMenu() {
    //Menu m = new Menu();
    Menu m100 = new Menu();
    Menu m101 = new Menu();
    assertNotEquals(m100, null);
    assertNotEquals(m101, null);
    assertEquals(m100.getFoodId(), new Menu().getFoodId());
    assertEquals(m100.getFoodName(), new Menu().getFoodName());
    assertEquals(m100.getFoodCost(), new Menu().getFoodCost());
    assertEquals(m100.getFoodType(), new Menu().getFoodType());
    assertEquals(m100.getAvailQuantity(), new Menu().getAvailQuantity());
    m101.setFoodId(100);
    m101.setFoodName("Pani Puri");
    m101.setFoodCost(50);
    m101.setFoodType("VEG");
    m101.setAvailQuantity(50);
    assertNotEquals(m101, new Menu());
    assertEquals(m100.hashCode(),
        new Menu().hashCode());
    assertEquals(m100, new Menu());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();

      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = MenuFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu();
    final Menu m101 = new Menu();
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu().getFoodId(), mn1[0].getFoodId());
    assertEquals(new Menu().getFoodId(), mn1[1].getFoodId());
    assertEquals(new Menu().getFoodName(), mn1[0].getFoodName());
    assertEquals(new Menu().getFoodName(), mn1[1].getFoodName());
    assertEquals(new Menu().getFoodCost(), mn1[0].getFoodCost());
    assertEquals(new Menu().getFoodCost(), mn1[1].getFoodCost());
    assertEquals(new Menu().getFoodType(), mn1[0].getFoodType());
    assertEquals(new Menu().getFoodType(), mn1[1].getFoodType());
    assertEquals(new Menu().getAvailQuantity(), mn1[0].getAvailQuantity());
    assertEquals(new Menu().getAvailQuantity(), mn1[1].getAvailQuantity());
    mn1[0].setFoodId(2);
    mn1[0].setFoodCost(50);
    mn1[0].setFoodName("pav bhaji");
    mn1[0].setAvailQuantity(30);
    mn1[0].setFoodType("VEG");
    mn1[1].setFoodId(2);
    mn1[1].setFoodCost(50);
    mn1[1].setFoodName("pav bhaji");
    mn1[1].setAvailQuantity(30);
    mn1[1].setFoodType("VEG");
    assertNotEquals(new Menu().getFoodId(), mn1[0].getFoodId());
    assertNotEquals(new Menu().getFoodId(), mn1[1].getFoodId());
    assertNotEquals(new Menu().getFoodName(), mn1[0].getFoodName());
    assertNotEquals(new Menu().getFoodName(), mn1[1].getFoodName());
    assertNotEquals(new Menu().getFoodCost(), mn1[0].getFoodCost());
    assertNotEquals(new Menu().getFoodCost(), mn1[1].getFoodCost());
    assertNotEquals(new Menu().getFoodType(), mn1[0].getFoodType());
    assertNotEquals(new Menu().getFoodType(), mn1[1].getFoodType());
    assertNotEquals(new Menu().getAvailQuantity(), mn1[0].getAvailQuantity());
    assertNotEquals(new Menu().getAvailQuantity(), mn1[1].getAvailQuantity());
  }

    /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testDefaultConstructor() {
    Menu menu = new Menu();
    assertEquals(menu.hashCode(), new Menu().hashCode());
  }

  /**
   * to test the getters for vendor.
   */
  @Test
  public final void testGettersMenu() {
    Menu menu = new Menu(1, "Sandwich", 30, 50,  "VEG");
    assertEquals(1, menu.getFoodId());
    assertEquals("Sandwich", menu.getFoodName());
    assertEquals(30, menu.getFoodCost());
    assertEquals("VEG", menu.getFoodType());
    assertEquals(50, menu.getAvailQuantity());
  }

   /**
   * to test the setters for vendor.
   */
  @Test
  public final void testSettersMenu() {
    Menu menu = new Menu(1, "Sandwich", 30, 50,  "VEG");
    menu.setFoodId(1);
    assertEquals(1, menu.getFoodId());
    assertNotEquals(2, menu.getFoodId());
    menu.setFoodName("sandwich");
    assertEquals("sandwich", menu.getFoodName());
    assertNotEquals("maggie", menu.getFoodName());
    menu.setFoodCost(30);
    assertEquals(30, menu.getFoodCost());
    assertNotEquals(50, menu.getFoodCost());
    menu.setAvailQuantity(50);
    assertEquals(50, menu.getAvailQuantity());
    assertNotEquals(40, menu.getAvailQuantity());
    menu.setFoodType("VEG");
    assertEquals("VEG", menu.getFoodType());
    assertNotEquals("NON-VEG", menu.getFoodType());
  }
}
