package com.securebiz.demo.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard/data")
public class BusinessDataController {
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    @GetMapping
    public String dashboard(){
        return "dashboard Data";
    }

}
