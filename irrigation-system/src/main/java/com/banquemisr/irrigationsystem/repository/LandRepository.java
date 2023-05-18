package com.banquemisr.irrigationsystem.repository;

import com.banquemisr.irrigationsystem.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.time.*;
import java.util.*;

@Repository
public interface LandRepository extends JpaRepository<Land, UUID> {
    @Transactional
    @Modifying
    @Query("update Land l set l.nextIrrigationTime = ?1 where l.id = ?2")
    int updateNextIrrigationTimeById(LocalDateTime nextIrrigationTime, UUID id);



}
