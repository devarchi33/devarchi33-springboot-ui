package com.devarchi33.persistance.jpa.repository;

import com.devarchi33.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}