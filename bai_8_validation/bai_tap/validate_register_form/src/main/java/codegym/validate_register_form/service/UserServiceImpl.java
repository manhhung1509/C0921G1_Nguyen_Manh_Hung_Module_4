package codegym.validate_register_form.service;

import codegym.validate_register_form.model.User;
import codegym.validate_register_form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void Save(User user) {
        userRepository.save(user);
    }
}
