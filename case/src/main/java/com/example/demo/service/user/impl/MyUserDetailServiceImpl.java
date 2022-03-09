package com.example.demo.service.user.impl;

import com.example.demo.model.user.MyUserDetail;
import com.example.demo.model.user.User;
import com.example.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

/**lúc login vào, username sẽ được truyền vào phương thức loadUserByUsername().*/
@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

//         Nếu không tìm thấy user thì ném ra exception
        if(user == null) {
            throw  new UsernameNotFoundException("User name: " + username + " not found. ");
        }
//        Nếu tìm thấy thì gọi Tạo đối tượng MyUserDetail và truyền user vào
        return new MyUserDetail(user);
    }
}
