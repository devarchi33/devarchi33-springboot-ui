package com.devarchi33.web.customer;

import com.devarchi33.domain.Customer;
import com.devarchi33.domain.dto.CustomerForm;
import com.devarchi33.service.CustomerService;
import com.devarchi33.service.LoginUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Controller
@RequestMapping("customers")
public class CustomerController {

    private Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final String LAYOUT = "layout";
    private final String REDIRECT = "redirect:/";

    @Autowired
    private CustomerService service;

    @ModelAttribute
    private CustomerForm setupForm() {
        return new CustomerForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        logger.info("customerList 화면..");

        List<Customer> customers = service.findAll();

        logger.info("size: {}", customers.size());

        model.addAttribute("page", "customerList");
        model.addAttribute("customers", customers);

        return LAYOUT;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Validated CustomerForm form, BindingResult result, Model model,
                         @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        logger.info("customer 생성..");

        if (result.hasErrors()) {
            return list(model);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        service.save(customer, loginUserDetails.getUser());

        return REDIRECT + "customers";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editForm(@RequestParam Integer id, CustomerForm customerForm, Model model) {
        logger.info("customer 수정 폼..");

        Customer customer = service.findOne(id);
        BeanUtils.copyProperties(customerForm, customer);

        model.addAttribute("page", "editForm");

        return LAYOUT;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String edit(@RequestParam Integer id, @Validated CustomerForm customerForm, BindingResult result, Model model,
                       @AuthenticationPrincipal LoginUserDetails loginUserDetails) {
        logger.info("customer 수정..");

        if (result.hasErrors()) {
            return editForm(id, customerForm, model);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerForm, customer);
        customer.setId(id);
        service.save(customer, loginUserDetails.getUser());

        return REDIRECT + "customers";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    public String goToTop() {
        return REDIRECT + "customers";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam Integer id) {
        logger.info("customer 삭제..");

        service.delete(id);
        return REDIRECT + "customers";
    }
}
