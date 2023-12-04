package grupoB.erp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import grupoB.erp.domain.User;

public interface UserService extends UserDetailsService {

    public List<User> findAll();

    public User find(User user);

    public void add(String username, String email, String password);

    public void delete(User user);
}
