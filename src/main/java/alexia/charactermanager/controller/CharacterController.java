package alexia.charactermanager.controller;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class CharacterController {

    @Autowired
    CharacterService serv;

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

}
