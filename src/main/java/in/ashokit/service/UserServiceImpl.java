package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.User;
import in.ashokit.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public boolean register(User user) {

        User existingUser = repo.findByEmail(user.getEmail());

        if (existingUser != null) {
            return false;
        }

        repo.save(user);
        return true;
    }

    @Override
    public User login(String email, String password) {

        User user = repo.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}