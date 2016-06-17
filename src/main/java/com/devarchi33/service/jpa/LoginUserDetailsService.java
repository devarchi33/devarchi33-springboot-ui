package com.devarchi33.service.jpa;

import com.devarchi33.domain.jpa.User;
import com.devarchi33.persistance.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by donghoon on 2016. 6. 16..
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findOne(username);

        if (user == null)
            throw new UsernameNotFoundException("hte requested user is not found.");


        return new LoginUserDetails(user);
    }
}
