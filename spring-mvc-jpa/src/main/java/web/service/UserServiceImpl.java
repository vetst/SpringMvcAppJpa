package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean addUser(User user) {
        if (user.getName() != null && user.getSurName() != null) {
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(Long id, String name, String surName) {
        if (id != null && name != null && surName != null) {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSurName(surName);
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (id != null) {
            User user = new User();
            user.setId(id);
            userDao.deleteUser(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
}
