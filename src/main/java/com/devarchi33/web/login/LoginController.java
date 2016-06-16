package com.devarchi33.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by donghoon on 2016. 6. 16..
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * Login 화면.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String login(Model model) {
        logger.info("Login 화면..");

        return "login";
    }

}
