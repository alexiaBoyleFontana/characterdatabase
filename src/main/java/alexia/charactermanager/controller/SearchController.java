package alexia.charactermanager.controller;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.WorldService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class SearchController {

    @Autowired
    CharacterService charServ;

    @Autowired
    WorldService worldServ;

    @RequestMapping(value = "/search/char", method = RequestMethod.GET)
    public ModelAndView characterSearch(@RequestParam(name = "search", required = false, defaultValue = "") String search) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("/search/charSearch");

        if (!search.isBlank()) {
            log.info("Search: " + search);
            List<Character> chars = charServ.containsName(search);
            response.addObject("characters", chars);
        } else {
            response.addObject("characters", charServ.allCharacters());
        }

        response.addObject("searchValue", search);

        return response;
    }

    @RequestMapping(value = "/search/world", method = RequestMethod.GET)
    public ModelAndView worldSearch(@RequestParam(name = "search", required = false, defaultValue = "") String search) throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("/search/worldSearch");

        if (!search.isBlank()) {
            log.info("Search: " + search);
            List<World> worlds = worldServ.containsName(search);
            response.addObject("worlds", worlds);
        } else {
            response.addObject("worlds", worldServ.allWorlds());
        }

        response.addObject("searchValue", search);

        return response;
    }

}
