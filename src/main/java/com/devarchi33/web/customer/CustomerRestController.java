package com.devarchi33.web.customer;

import com.devarchi33.domain.Customer;
import com.devarchi33.persistance.jpa.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@RestController
@RequestMapping("api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Customer> getCustomers(@PageableDefault(3) Pageable pageable) {
        Page<Customer> customers = service.findAllOrderByName(pageable);
        return customers;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable Integer id) {
        Customer customer = service.findOne(id);
        return customer;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer,
                                                   UriComponentsBuilder uriBuilder) {
        Customer created = service.save(customer);
        URI location = uriBuilder.path("api/customers/{id}")
                .buildAndExpand(created.getId()).toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        return service.save(customer);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Integer id) {
        service.delete(id);
    }
}