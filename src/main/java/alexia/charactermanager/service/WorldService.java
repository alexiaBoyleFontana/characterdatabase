package alexia.charactermanager.service;

import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.dao.WorldDAO;
import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import alexia.charactermanager.formbean.CharacterFormBean;
import alexia.charactermanager.formbean.WorldFormBean;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Component
@NoArgsConstructor
@Service
public class WorldService {

    @Autowired
    private WorldDAO worldDao;

//    public void test() {
//        World world = new World();
//        world.setName("test");
//        world.setDesc("test");
//        world.setMedium("test");
//
//        save(world);
//    }

    public World submitWorld(CharacterFormBean form) {

        World world = findByName(form.getWorld());
        //log.info(world.toString());

        if (world == null) {
            //New character
            world = new World();
            world.setName(form.getWorld());
            save(world);
        }

        return world;
    }

    public World submitWorld(WorldFormBean form) {

        World world = findById(form.getId());

        if (world == null) {
            world = new World();
        }

        world.setName(form.getName());
        world.setDesc(form.getDescription());
        world.setMedium(form.getMedium());

        return world;
    }

    public World findByName(String world) {
        return worldDao.findByName(world);
    }

    public void save (World world) {
        worldDao.save(world);
    }

    public World findById(Integer worldId) {
        return worldDao.findById(worldId);
    }

    public List<World> allWorlds() {
        return worldDao.findAll();
    }
}