package com.tanya.militarybase.service;

import com.tanya.militarybase.dao.persons.OficerRepository;
import com.tanya.militarybase.dao.persons.RyadovoyRoleRepository;
import com.tanya.militarybase.model.User;
import com.tanya.militarybase.model.persons.Oficer;
import com.tanya.militarybase.model.persons.RyadovoyRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tanya.militarybase.dao.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final OficerRepository oficerRepository;
    private final RyadovoyRoleRepository ryadovoyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (null != userFromDb) {
            return false;
        }

        saveUser(user);
        return true;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    private void saveUser(User user) {
        userRepository.save(user);

        switch(user.getRole()) {
            case USER:
                break;
            case OFICER:
                Oficer oficer = new Oficer();
                oficer.setUser(user);
                oficerRepository.save(oficer);
                break;
            case RYADOVOY:
                RyadovoyRole ryadovoy = new RyadovoyRole();
                ryadovoy.setUser(user);
                ryadovoyRepository.save(ryadovoy);
                break;
        }
    }
}
