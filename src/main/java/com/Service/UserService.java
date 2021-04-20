package com.Service;

import com.Model.Patient;
import com.Model.Role;
import com.Model.User;
import com.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Optional<User> FindById(Long id) {
        return userRepository.findById(id);
    }
    public boolean FindUser(User user)
    {
        User user1 = userRepository.findByUsername(user.getUsername());
        if(user1!=null)
        {
            return true;
        }
        return false;
    }
    public boolean redactUser(String username, long id)
    {
        User user = userRepository.findById(id).orElseThrow();
        if (user!=null)
        {
            System.out.println(username);
            user.setUsername(username);
            userRepository.save(user);
            return true;
        }
        return false;
    }
    public List<User> allUsers()
    {
        return userRepository.findAllByRoles(Role.USER);
        //return userRepository.findAll();
    }

    public boolean ExistById(long id)
    {
        return userRepository.existsById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    public void DeleteUser(long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

    public boolean redactPatient(String name, String password, long id) {
        User user = userRepository.findById(id).orElseThrow();
        if (user!=null)
        {
            user.setUsername(name);
            user.setPassword(password);
            return true;
        }
        return false;
    }

    public boolean NewUser(User userForm) {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        userForm.setRoles(Collections.singleton(Role.USER));
        userForm.setActive(true);
        userRepository.save(userForm);
        return true;
    }
}
