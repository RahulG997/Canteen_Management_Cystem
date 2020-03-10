
package com.hexaware.MLP191.factory;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;




import com.hexaware.MLP191.model.History;
import com.hexaware.MLP191.persistence.HistoryDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * initializing customer factory.
 */
public class HistoryFactoryTest {
  /**
   * tests that order is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void addrating(@Mocked final HistoryDAO dao) {

    final History c1 = new History();
    new Expectations() {
      {
        System.out.println("mocked get Orders");
        HistoryFactory.addrating(5, "good", 1);
        result = c1;
      }
    };
    new MockUp<HistoryFactory>() {
      @Mock
      HistoryDAO dao() {
        System.out.println("Mocked Orders Dao");
        return dao;
      }
    };
    int history = HistoryFactory.addrating(5, "good", 1);
    assertNotEquals(c1, history);
  }

  /**
   * tests that customer wallet is handled correctly.
   * @param dao mocking the dao class
   */
  @Test

  public final void showMenu(@Mocked final HistoryDAO dao) {

    final History history = new History();

    new Expectations() {
      {
        System.out.println("Mocked display history");
        HistoryFactory.showHistory();
        result = history;
      }
    };
    new MockUp<HistoryFactory>() {
      @Mock
      HistoryDAO dao() {
        System.out.println("Mocked history Dao");
        return dao;
      }
    };
    History[] actualS = HistoryFactory.showHistory();
    assertNotEquals(history, actualS);
  }
    /**
     * Testing default protected constructor.
     */
  @Test
  public final void testDefaultConstructor() {
    HistoryFactory hf = new HistoryFactory();
    HistoryFactory hf1 = new HistoryFactory();
    assertNotEquals(hf.hashCode(), hf1.hashCode());
  }

}
