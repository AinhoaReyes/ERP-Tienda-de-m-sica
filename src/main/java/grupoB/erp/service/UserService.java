package grupoB.erp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import grupoB.erp.domain.User;

public interface UserService extends UserDetailsService {

    public List<User> getAll();

    public User get(User user);
    
    public User getById(Long id);

    public void add(String username, String email, String password);

    public void save(User user);

    public void delete(User user);
}
