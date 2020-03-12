package com.dcomp.redsaju.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeResource {

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:home.xhtml";
    }
}
