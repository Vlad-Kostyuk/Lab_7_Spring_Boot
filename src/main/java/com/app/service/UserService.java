
package com.app.service;

import com.app.entity.User;
import com.app.exceptions.ExistBlockedUserException;
import com.app.exceptions.ExistsPostUserExsception;
import com.app.exceptions.NoSuchUserException;
import com.app.repos.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    @Transactional
    public User createUser(User user) {
        if (user.getLastActivity()==null) {user.setLastActivity(new Date());};
        user = userRepository.save(user);
        return user;
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }


    public User getUserById(int id) throws NoSuchUserException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())throw new NoSuchUserException("Користувача не знайдено");
        return  user.get();
    }


    @Transactional
    public void deleteUser(int id) throws NoSuchUserException, ExistsPostUserExsception,ExistBlockedUserException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) throw new NoSuchUserException();
        //if (user.get().getPosts().size()>0) throw new ExistsPostUserExsception("У користувача є пости!");
        userRepository.delete(user.get());
    }


    @Transactional
    public void deleteUserAll() {
        userRepository.deleteAll();
    }


    @Transactional
    public User update(User user, int id) throws NoSuchUserException {
        Optional<User> u = userRepository.findById(id);
        if (!u.isPresent()) {
            throw new NoSuchUserException("Користувача не знайдено");
        }
        if (user.getLastActivity()==null) {user.setLastActivity(new Date());};
        User user_ = u.get();
        user_.setNickName(user.getNickName());
        user_.setFoto(user.getFoto());
        user_.setLastActivity(user.getLastActivity());
        return userRepository.save(user_);
    }


   

}
