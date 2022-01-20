package codegym.validate_register_form.service;

import codegym.validate_register_form.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void Save(User user);
}
