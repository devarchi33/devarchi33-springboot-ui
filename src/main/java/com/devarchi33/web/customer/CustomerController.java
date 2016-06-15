package com.devarchi33.web.customer;

import com.devarchi33.domain.Customer;
import com.devarchi33.persistance.jpa.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Controller
@RequestMapping("customers")
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final String LAYOUT = "layout";

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(@PageableDefault Pageable pageable, Model model) {
        logger.info("customerList 화면..");

        Page<Customer> customers = service.findAll(pageable);

        model.addAttribute("page", "customerList");
        model.addAttribute("customers", customers);

        return LAYOUT;
    }
}
