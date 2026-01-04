package com.securebiz.demo.Repository;


import com.securebiz.demo.Entity.BusinessData;
import com.securebiz.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BusinessDataRepository extends JpaRepository<BusinessData, Long> {
    List<BusinessData> findByCreatedBy(User user);
}
