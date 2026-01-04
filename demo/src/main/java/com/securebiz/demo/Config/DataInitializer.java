package com.securebiz.demo.Config;


import com.securebiz.demo.Service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initRoles(RoleService roleService){
        return args -> {
            roleService.creatRoleIfNotExist("ROLE_ADMIN");
            roleService.creatRoleIfNotExist("ROLE_MANAGER");
            roleService.creatRoleIfNotExist("ROLE_USER");
        };
    }
}
