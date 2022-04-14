package alexia.charactermanager.controller;

import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.entity.Character;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class SearchController {

    @Autowired
    CharacterDAO charDao;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView home() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("/search");

        List<Character> characters = charDao.findAll();

        //log.info(characters.get(0).toString());

        response.addObject("characters", characters);

        return response;
    }

}
