package com.banquemisr.irrigationsystem.repository;

import com.banquemisr.irrigationsystem.model.*;
import com.banquemisr.irrigationsystem.model.enumerate.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
public interface SlotRepository extends JpaRepository<Slot, UUID> {
    @Transactional
    @Modifying
    @Query("update Slot s set s.retryCount = ?1 where s.id = ?2")
    int updateRetryCountById(Integer retryCount, UUID id);
    @Transactional
    @Modifying
    @Query("update Slot s set s.state = ?1 ,s.lastOpenTime= CURRENT_TIMESTAMP where s.id = ?2")
    int updateStateById(SlotStatus state, UUID id);


}
