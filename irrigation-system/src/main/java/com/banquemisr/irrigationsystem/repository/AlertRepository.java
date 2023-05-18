package com.banquemisr.irrigationsystem.repository;

import com.banquemisr.irrigationsystem.model.*;
import com.banquemisr.irrigationsystem.model.enumerate.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Repository
public interface AlertRepository extends JpaRepository<Alert, UUID> {


}
