package com.securebiz.demo.Service;

import com.securebiz.demo.Entity.BusinessData;
import com.securebiz.demo.Repository.BusinessDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessDataService {
    private final BusinessDataRepository businessDataRepository;

    public BusinessDataService(BusinessDataRepository businessDataRepository){
        this.businessDataRepository = businessDataRepository;

    }
    public BusinessData save(BusinessData data){
        return businessDataRepository.save(data);
    }
    public List<BusinessData> findAll(){
        return businessDataRepository.findAll();
    }
}
