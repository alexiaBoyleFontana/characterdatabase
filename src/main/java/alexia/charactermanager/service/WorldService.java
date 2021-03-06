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

    public World submitWorld(CharacterFormBean form) {

        World world = findByName(form.getWorld());

        if (world == null) {
            world = new World();
            if (form.getName().isBlank()) {
                world.setName("Unnamed");
            } else {
                world.setName(form.getName());
            }
            save(world);
        }

        return world;
    }

    public World submitWorld(WorldFormBean form) {

        World world = findById(form.getId());

        if (world == null) {
            world = new World();
        }

        if (form.getName().isBlank()) {
            world.setName("Unnamed");
        } else {
            world.setName(form.getName());
        }
        world.setDesc(form.getDescription());
        world.setMedium(form.getMedium());

        return world;
    }

    public void delete (Integer worldId) {
        World world = worldDao.findById(worldId);

        if (world != null) {
            worldDao.delete(world);
        }
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

    public List<World> containsName(String name) {
        return worldDao.findByNameIgnoreCaseContaining(name);
    }
}