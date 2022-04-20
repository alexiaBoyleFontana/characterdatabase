package alexia.charactermanager.controller;

import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.WorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class SearchController {

    @Autowired
    CharacterService charServ;

    @Autowired
    WorldService worldServ;

    @RequestMapping(value = "/search/char", method = RequestMethod.GET)
    public ModelAndView characterSearch() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("/search/charSearch");

        response.addObject("characters", charServ.allCharacters());

        return response;
    }

    @RequestMapping(value = "/search/world", method = RequestMethod.GET)
    public ModelAndView worldSearch() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("/search/worldSearch");

        response.addObject("worlds", worldServ.allWorlds());

        return response;
    }

}
