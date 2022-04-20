package alexia.charactermanager.service;

import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.dao.WorldDAO;
import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
@NoArgsConstructor
@Service
public class WorldService {

    @Autowired
    private WorldDAO worldDao;

    public World findByName(String world) {
        return worldDao.findByName(world);
    }

    public void save (World world) {
        worldDao.save(world);
    }
}