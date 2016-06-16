package com.devarchi33.service;

import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;
import com.devarchi33.domain.User;

/**
 * Created by donghoon on 2016. 6. 16..
 */
@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {

    private final User user;

    public LoginUserDetails(User user) {
        super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }

}
