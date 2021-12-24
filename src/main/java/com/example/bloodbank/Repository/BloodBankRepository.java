package com.example.bloodbank.Repository;
import com.example.bloodbank.modal.*;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.Optional;

public interface BloodBankRepository extends JpaRepository<PatientInfo,Integer> {
    @Override
    List<PatientInfo> findAll();
}
