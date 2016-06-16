package com.devarchi33.persistance.jpa.repository;

import com.devarchi33.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by donghoon on 2016. 6. 16..
 */
public interface UserRepository extends JpaRepository<User, String> {
}
