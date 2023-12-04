package grupoB.erp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grupoB.erp.dao.UserDAO;
import grupoB.erp.domain.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User find(User user) {
        return userDAO.findById(user.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User login(String email, String hashedPassword) {
        return userDAO.find();
    }

    @Override
    @Transactional
    public void add(String username, String email, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        userDAO.save(new User(username, email, bcrypt.encode(password)));
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            new UsernameNotFoundException("User with username " + username + " does not exist");
        }
        GrantedAuthority authorities = new SimpleGrantedAuthority("USER");
        return new org.springframework.security.core.userdetails.User(username, user.getHashedPassword(), Arrays.asList(authorities));
    }
}
