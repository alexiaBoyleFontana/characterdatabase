package alexia.charactermanager.controller;

import alexia.charactermanager.formbean.RegisterFormBean;
import alexia.charactermanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView("/login/register");

        return response;
    }

    //Add validation
    @RequestMapping(value="/registerSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmit(RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        response.addObject("form", form);

        log.info(form.toString());

        if (service.createUser(form)) {
            log.info("User (" + form.getUsername() + ") created successfully");
        }

        response.setViewName("redirect:/home");

        return response;
    }

}
