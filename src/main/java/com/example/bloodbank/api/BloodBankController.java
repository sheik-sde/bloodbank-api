package com.example.bloodbank.api;

import com.example.bloodbank.Repository.BloodBankRepository;
import com.example.bloodbank.ServletInitializer;
import com.example.bloodbank.modal.PatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class BloodBankController extends ServletInitializer {
    @Autowired
    BloodBankRepository bloodBankRepository;
    @GetMapping("/start")
    String Start(){
        return "started";
    }

    @PostMapping("/adduser")
    boolean addUser(@RequestBody PatientInfo patient){
        bloodBankRepository.save(patient);
        return true;
    }
    @GetMapping("/findall")
    public List<PatientInfo> findAll(){
//        long count = bloodBankRepository.count();
//        List<PatientInfo> users = bloodBankRepository.findAll(new PageRequest(0, count));


        return bloodBankRepository.findAll();
    }

    @PostMapping("/deleteuser")
    public boolean deleteUser(@RequestBody Map<String,Integer> mapid){

        try {
            System.out.println("mapid"+mapid);
            bloodBankRepository.deleteById(mapid.get("id"));
            return true;
        }
        catch(Exception exp){
            return false;
        }
    }

    @PostMapping("/updateuser")
    public boolean updateUser(@RequestBody PatientInfo patient)
    {
        try{
        System.out.println("mapid "+patient.getAge()+patient.getPid());
        PatientInfo updatepatient=bloodBankRepository.getById(patient.getPid());
        updatepatient.setAge(patient.getAge());
        updatepatient.setB_grp(patient.getB_grp());
        updatepatient.setLoc(patient.getLoc());
        updatepatient.setPname(patient.getPname());
        updatepatient.setPhealth_his(patient.getPhealth_his());
        updatepatient.setQty(patient.getQty());


bloodBankRepository.save(updatepatient);
        return true;}
        catch(EntityNotFoundException exp){
            return  false;
        }
    }

}
