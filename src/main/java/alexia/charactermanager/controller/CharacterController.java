package alexia.charactermanager.controller;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import alexia.charactermanager.formbean.CharacterFormBean;
import alexia.charactermanager.formbean.RegisterFormBean;
import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.WorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Slf4j
@Controller
public class CharacterController {

    @Autowired
    CharacterService serv;

    @Autowired
    WorldService worldServ;

    @GetMapping("/char/{characterId}")
    public ModelAndView viewChar (@PathVariable("characterId") Integer charId) throws Exception {
        ModelAndView response = new ModelAndView();

        Character character = serv.findById(charId);

        if (character == null) {
            //probably just a 404 tbh but for now
            response.setViewName("redirect:/home");
        } else {
            response.setViewName("/view/char");
            response.addObject(character);
        }

        return response;
    }

    @RequestMapping(value="/char/submit", method = RequestMethod.POST)
    public ModelAndView submit (CharacterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();


            //Serv can do the create or edit check
        Character character = serv.submitChar(form);

        //World world = worldServ.submitWorld(form));

        //character.setWorld(world);

        serv.save(character);

        log.info(form.toString());

        response.setViewName("redirect:/char/" + character.getId());

        return response;

    }

}
