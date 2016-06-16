package com.devarchi33.web.page;

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
public class PageController {
    private final Logger logger = LoggerFactory.getLogger(PageController.class);
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

}
