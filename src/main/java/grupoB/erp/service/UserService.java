package grupoB.erp.service;

import java.util.List;

import grupoB.erp.domain.User;

public interface UserService {

    public List<User> findAll();

    public User find(User user);

    public void add(User user);

    public void delete(User user);
}
