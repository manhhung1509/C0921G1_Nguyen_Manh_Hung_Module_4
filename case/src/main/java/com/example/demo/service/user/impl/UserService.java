package com.example.demo.service.user.impl;

import com.example.demo.model.user.Role;
import com.example.demo.model.user.User;
import com.example.demo.repository.user.IRoleRepository;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Set<Role> roleList = new HashSet<>();
        if (("giám đốc").equals(user.getEmployee().getPosition().getPositionName()) || ("'quản lý'").equals(user.getEmployee().getPosition().getPositionName())){
            Role role = iRoleRepository.findById(1L).orElse(null);
            Role role2 = iRoleRepository.findById(2L).orElse(null);
            roleList.add(role);
            roleList.add(role2);
            user.setRoles(roleList);
        }else {
            Role role2 = iRoleRepository.findById(2L).orElse(null);
            roleList.add(role2);
            user.setRoles(roleList);
        }
        userRepository.save(user);

    }
}
