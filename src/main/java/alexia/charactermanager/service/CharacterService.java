package alexia.charactermanager.service;

import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.dao.UserDAO;
import alexia.charactermanager.database.entity.Character;
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
public class CharacterService {

    @Autowired
    private CharacterDAO charDao;

    public List<Character> allCharacters () {

        return charDao.findAll();
    }
}
