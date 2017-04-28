package com.acme.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.config.ApplicationConfig;
import com.acme.persistent.UserRepository;
import com.acme.persistent.model.User;

@Controller
public class HomeController {

    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String index() {
        return "Hello World!!";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello() {
        String firstServer = applicationConfig.getServers().get(0);
        return firstServer;
    }

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public String greeting(ModelMap model, @PathVariable("name") String name) {
        model.addAttribute("name", name);

        return "hello";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
