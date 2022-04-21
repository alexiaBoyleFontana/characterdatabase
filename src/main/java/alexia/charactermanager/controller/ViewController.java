package alexia.charactermanager.controller;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import alexia.charactermanager.formbean.CharacterFormBean;
import alexia.charactermanager.formbean.WorldFormBean;
import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.WorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ViewController {

    @Autowired
    CharacterService charServ;

    @Autowired
    WorldService worldServ;

    @GetMapping("/char/{characterId}")
    public ModelAndView viewChar (@PathVariable("characterId") Integer charId) throws Exception {
        ModelAndView response = new ModelAndView();

        Character character = charServ.findById(charId);

        if (character == null) {
            response.setViewName("redirect:/home");
        } else {
            response.setViewName("/view/char");
            response.addObject(character);
        }

        return response;
    }

    @RequestMapping(value="/char/submit", method = RequestMethod.POST)
    public ModelAndView characterSubmit (CharacterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

            //Serv can do the create or edit check
        Character character = charServ.submitChar(form);

        if (!form.getWorld().isBlank()) {
            World world = worldServ.submitWorld(form);
            character.setWorld(world);
        } else {
            charServ.clearWorld(character);
        }


        charServ.save(character);

        log.info(form.toString());

        response.setViewName("redirect:/char/" + character.getId());

        return response;

    }

    @GetMapping("/world/{worldId}")
    public ModelAndView viewWorld (@PathVariable("worldId") Integer worldId) throws Exception {
        ModelAndView response = new ModelAndView();

        World world = worldServ.findById(worldId);

        if (world == null) {
            response.setViewName("redirect:/home");
        } else {
            response.setViewName("/view/world");
            response.addObject(world);
        }

        return response;
    }

    @RequestMapping(value="/world/submit", method = RequestMethod.POST)
    public ModelAndView worldSubmit (WorldFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        //Serv can do the create or edit check
        World world = worldServ.submitWorld(form);

        worldServ.save(world);

        log.info(form.toString());

        response.setViewName("redirect:/world/" + world.getId());

        return response;

    }

    @RequestMapping(value="/create", method = RequestMethod.GET)
    public ModelAndView createNew () throws Exception {
        ModelAndView response = new ModelAndView("/view/create");

        return response;
    }


}
