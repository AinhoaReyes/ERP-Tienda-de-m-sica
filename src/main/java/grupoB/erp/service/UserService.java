package grupoB.erp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import grupoB.erp.domain.User;

public interface UserService extends UserDetailsService{

    public List<User> findAll();

    public User find(User user);

    public User login(String email, String hashedPassword);

    public void add(User user);

    public void delete(User user);
}
