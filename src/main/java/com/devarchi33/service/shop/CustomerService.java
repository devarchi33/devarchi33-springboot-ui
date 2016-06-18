package com.devarchi33.service.shop;

import com.devarchi33.domain.jpa.Customer;
import com.devarchi33.domain.jpa.User;
import com.devarchi33.persistance.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Transactional
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer save(Customer customer, User user) {
        customer.setUser(user);
        return repository.save(customer);
    }

    public List<Customer> findAll() {
        return repository.findAllOrderByName();
    }

    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Customer> findAllOrderByName(Pageable pageable) {
        return repository.findAllOrderByNamePageable(pageable);
    }

    public Customer findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
