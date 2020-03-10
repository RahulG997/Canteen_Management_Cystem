
package com.hexaware.MLP191.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP191.model.History;
/**
 * HistoryDAO class used to obtain History from data base.
 * @author Santhosh-hexware
 */
public interface HistoryDAO {
    /**
     * @return the all the History record.
     */
  @SqlQuery("Select * from History")
    @Mapper(HistoryMapper.class)
    List<History> show();
/**
 * @param rate rating
 * @param feedback feedback
 * @param cusid id
 * @return added
 */
  @SqlUpdate("INSERT INTO HISTORY(RATING , FEEDBACK, CUS_ID) VALUES(:rate , :feedback, :cusid)")
    int addrating(@Bind("rate") int rate, @Bind("feedback") String feedback, @Bind("cusid") int cusid);

}
