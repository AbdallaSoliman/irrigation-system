package com.banquemisr.irrigationsystem.repository;

import com.banquemisr.irrigationsystem.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface LandConfigurationRepository extends JpaRepository<LandConfiguration, UUID> {
    @Query("select lc from LandConfiguration lc join FETCH Land l on  l.id =lc.land join fetch Slot sss on sss.land =l.id where  CURRENT_TIMESTAMP between lc.startDate and lc.endDate " +
            "and (l.nextIrrigationTime is null or l.nextIrrigationTime < CURRENT_TIMESTAMP ) ")
    List<LandConfiguration> getAllLandNeedIrrigation();
}
