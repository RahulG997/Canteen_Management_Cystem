
package com.hexaware.MLP191.model;

import com.hexaware.MLP191.persistence.HistoryDAO;
import com.hexaware.MLP191.factory.HistoryFactory;

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
public class HistoryTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testHistory() {
    History h1 = new History();
    History h2 = new History();
    assertNotEquals(h1, null);
    assertNotEquals(h2, null);
    assertEquals(h1.getCusId(), new History().getCusId());
    assertEquals(h1.getRating(), new History().getRating());
    assertEquals(h1.getFeedback(), new History().getFeedback());
    assertEquals(h1.getOrdId(), new History().getOrdId());
    h2.setCusId(5);
    assertEquals(5, h2.getCusId());
    h2.setOrdId(3);
    assertEquals(3, h2.getOrdId());
    h2.setFeedback("good");
    assertEquals("good", h2.getFeedback());
    h2.setRating(5);
    assertEquals(5, h2.getRating());
    assertNotEquals(h2, new History());
    assertEquals(h1.hashCode(),
        new History().hashCode());
    assertEquals(h1, new History());
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final HistoryDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<History>();
      }
    };
    new MockUp<HistoryFactory>() {
      @Mock
      HistoryDAO dao() {
        return dao;
      }
    };
    History[] me = HistoryFactory.showHistory();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final HistoryDAO dao) {
    final History h1 = new History();
    final History h2 = new History();
    final ArrayList<History> mn = new ArrayList<History>();
    new Expectations() {
      {
        mn.add(h1);
        mn.add(h2);
        dao.show(); result = mn;
      }
    };
    new MockUp<HistoryFactory>() {
      @Mock
      HistoryDAO dao() {
        return dao;
      }
    };
    History[] mn1 = HistoryFactory.showHistory();
    assertEquals(2, mn1.length);
    assertEquals(new History().getCusId(),
        mn1[0].getCusId());
    assertEquals(new History().getCusId(),
        mn1[1].getCusId());
  }

    /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testDefaultConstructor() {
    History history = new History();
    assertEquals(history.hashCode(), new History().hashCode());
  }

  /**
   * to test the getters for history.
   *
   *
   */
  @Test
  public final void testGettersHistory() {
    History history = new History(5, "super", 2, 6);
    assertEquals(5, history.getRating());
    assertEquals("super", history.getFeedback());
    assertEquals(2, history.getCusId());
    assertEquals(6, history.getOrdId());
  }

   /**
    * to test the setters for history.
    *
    *
    */
  @Test
  public final void testSettersHistory() {
    History history = new History(5, "super", 2, 6);
    history.setRating(5);
    assertEquals(5, history.getRating());
    history.setFeedback("super");
    assertEquals("super", history.getFeedback());
    history.setCusId(2);
    assertEquals(2, history.getCusId());
    history.setOrdId(6);
    assertEquals(6, history.getOrdId());
  }

    /**
   * Test case for testing default constructor.
   */
  @Test
  public final void testParameterizedConstructor() {
    History history = new History(5, "good", 1, 2);
    assertNotEquals(history.hashCode(), new History().hashCode());
  }
/**
 *
 */
 /*  @Test
  public final void testEquals() {
    History h1 = new History();
    History h2 = new History();
    final boolean equal = false;
    assertNotEquals(equal, h1.equals(h2));
  } */

}
