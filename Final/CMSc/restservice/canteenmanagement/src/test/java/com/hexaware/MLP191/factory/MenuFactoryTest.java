package com.hexaware.MLP191.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import com.hexaware.MLP191.model.Menu;
import com.hexaware.MLP191.persistence.MenuDAO;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

//This class test Factory class of Car

/** */
public class MenuFactoryTest {


    /**
  * default constructor testing.
 */
  @Test
  public final void testDefaultConstructor() {
    MenuFactory mf = new MenuFactory();
    MenuFactory mf1 = new MenuFactory();
    assertNotEquals(mf.hashCode(), mf1.hashCode());
  }
  /**
   * @param dao dao
   */
  @Test
  public final void testGetAllMenu(@Mocked final MenuDAO dao) {

    final ArrayList<Menu> menuList = new ArrayList<Menu>();
    final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    new Expectations() {
      {
        menuList.add(menu);
        dao.show();
        result = menuList;
      }
    };

    new MockUp<MenuFactory>() {

      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    Menu[] menuList1 = MenuFactory.showMenu();
    assertEquals(menu, menuList1[0]);
  }




/**
 * @param dao dao
 */
  @Test
  public final void testInsertMenu(@Mocked final MenuDAO dao) {
    //final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    final int i = 0;
    new Expectations() {
      {
        dao.insertMenu(2, "Masala Puri", 50, 100);
      }
    };

    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    int  menuList2 = MenuFactory.insertMenu(2, "Masala Puri", 50, 100);
    assertEquals(i, menuList2);
  }

  /**
 * @param dao dao
 */
  @Test
  public final void testUpdateMenu(@Mocked final MenuDAO dao) {
    //final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    final int i = 1;
    new Expectations() {
      {
        dao.updateMenu(50, 1);
      }
    };

    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    int  menuList2 = MenuFactory.updateMenu(50, 1);
    assertNotEquals(i, menuList2);
  }

/**
 * @param dao dao
 */
  @Test
  public final void testUpdateMenuQuan(@Mocked final MenuDAO dao) {
    //final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    final int i = 1;
    new Expectations() {
      {
        dao.updateQuantity(2, 50);
      }
    };

    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    int  menuList2 = MenuFactory.updateQuantity(2, 50);
    assertNotEquals(i, menuList2);
  }

/**
 * @param dao dao
 */
  @Test
  public final void testGetMenu(@Mocked final MenuDAO dao) {

    //final ArrayList<Menu> menuList = new ArrayList<Menu>();
    //final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    int i = 0;
    new Expectations() {
      {
        dao.selectMenu(1);
      }
    };

    new MockUp<MenuFactory>() {

      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    int menuList1 = MenuFactory.selectMenuprice(1);
    assertEquals(i, menuList1);
  }

  /**
 * @param dao dao
 */
  @Test
  public final void testGetAllMenuType(@Mocked final MenuDAO dao) {

    final ArrayList<Menu> menuList = new ArrayList<Menu>();
    final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    new Expectations() {
      {
        menuList.add(menu);
        dao.typeMenu("VEG");
        result = menuList;
      }
    };
    new MockUp<MenuFactory>() {

      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] menuList1 = MenuFactory.foodMenu("VEG");
    assertEquals(menu, menuList1[0]);
  }

  /**
 * @param dao dao
 */
  @Test
  public final void testGetMenuSelect(@Mocked final MenuDAO dao) {

    //final ArrayList<Menu> menuList = new ArrayList<Menu>();
    final Menu menu = new Menu(1, "Pani puri", 70, 100, "VEG ");
    //int i = 0;
    new Expectations() {
      {
        dao.selectMenu(1);
      }
    };

    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };

    Menu menuList1 = MenuFactory.selectMenu(1);
    assertNotEquals(menu, menuList1);
  }
}
