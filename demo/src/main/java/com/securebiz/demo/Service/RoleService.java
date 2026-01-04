package com.securebiz.demo.Service;

import com.securebiz.demo.Entity.Role;
import com.securebiz.demo.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role creatRoleIfNotExist(String roleName){
        Optional<Role> exitingRole = roleRepository.findByName(roleName);

        if(exitingRole.isPresent()){
            return exitingRole.get();
        }

        Role role = new Role();
        role.setName(roleName);
        return roleRepository.save(role);
    }
}
