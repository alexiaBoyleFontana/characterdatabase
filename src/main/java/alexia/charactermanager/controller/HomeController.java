package alexia.charactermanager.controller;

import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.entity.Character;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    CharacterDAO charDao;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("home");

        List<Character> characters = charDao.findAll();

        log.info(characters.get(0).toString());

        response.addObject("characters", characters);

        return response;
    }
}
