package alexia.charactermanager.controller;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import alexia.charactermanager.service.CharacterService;
import alexia.charactermanager.service.WorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class WorldController {

    @Autowired
    CharacterService charServ;

    @Autowired
    WorldService serv;

    @GetMapping("/world/{worldId}")
    public ModelAndView viewWorld (@PathVariable("worldId") Integer worldId) throws Exception {
        ModelAndView response = new ModelAndView();

        World world = serv.findById(worldId);

        if (world == null) {
            //probably just a 404 tbh but for now
            response.setViewName("redirect:/home");
        } else {
            response.setViewName("/view/world");
            response.addObject(world);
        }

        return response;
    }
}
