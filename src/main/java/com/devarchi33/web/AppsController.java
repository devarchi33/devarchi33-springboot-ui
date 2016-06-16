package com.devarchi33.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by donghoon on 2016. 6. 9..
 */
@Controller
public class AppsController {
    private final Logger logger = LoggerFactory.getLogger(AppsController.class);
    private final String LAYOUT = "layout";

    /**
     * main 화면.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        logger.info("main 화면..");

        model.addAttribute("page", "main");

        return LAYOUT;
    }

    /**
     * bookmark
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/bookmark", method = RequestMethod.GET)
    public String bookmark(Model model) {
        logger.info("bookmark main 화면..");

        return "angular-architecture-origin/index";
    }

    /**
     * material
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public String material(Model model) {
        logger.info("material main 화면..");

        return "angular-material-origin/index";
    }

}
