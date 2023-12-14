package grupoB.erp.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserContext userContext;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return (List<User>) userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User get(User user) {
        return userDAO.findById(user.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void add(String username, String email, String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        userDAO.save(new User(username, email, bcrypt.encode(password)));
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
        if (userContext.getCurrentUser().getId().equals(user.getId())) {
            userContext.setCurrentUser(user);
        }
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
            throw new UsernameNotFoundException("User with username " + username + " does not exist");
        }
        userContext.setCurrentUser(user);
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Collections.emptyList());
    }
}
