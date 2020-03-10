
package com.hexaware.MLP191.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.time.LocalDate;
import java.util.List;
import com.hexaware.MLP191.model.Offers;
/**
 * HistoryDAO class used to obtain History from data base.
 * @author Santhosh-hexware
 */
public interface OffersDAO {
    /**
     * @return the all the offers record.
     */
  @SqlQuery("Select * from Offers")
    @Mapper(OffersMapper.class)
    List<Offers> show();

/**
 *
 * @param cod ff
 * @param dateend f
 * @param cusid ff
 * @param datetoday s
 * @return addingoffers
 */
  @SqlUpdate("INSERT INTO OFFERS(COUPON_CODE , DATE_OF_COUPON, DATE_OF_COUPON_END, CUS_ID) VALUES(:cod , :datetoday, :dateend, :cusid)")
    int addoffers(@Bind("cod") String cod, @Bind("datetoday") LocalDate datetoday, @Bind("dateend") LocalDate dateend, @Bind("cusid") int cusid);
/**
 *
 * @param cid ff
 * @return cc
 */
  @SqlUpdate("DELETE FROM OFFERS WHERE CUS_ID = (:cusId)")
 int deleteoffers(@Bind("cusId") int cusId);
/**
 *
 * @param cid vv
 * @return vv
 */
  @SqlQuery("select * from OFFERS where CUS_ID = :cid")
    @Mapper(OffersMapper.class)
     Offers checkcoupcus(@Bind("cusId") int cusId);
/**
 *
 * @param cid h
 * @return f
 */
  @SqlQuery("Select * from OFFERS where CUS_ID = :cusId")
    @Mapper(OffersMapper.class)
      Offers coupondate(@Bind("cusId") int cusId);

}
