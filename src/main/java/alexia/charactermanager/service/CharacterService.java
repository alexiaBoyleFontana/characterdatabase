package alexia.charactermanager.service;

import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.dao.UserDAO;
import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.User;
import alexia.charactermanager.formbean.CharacterFormBean;
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

    public Character submitChar(CharacterFormBean form) {

        Character character = findById(form.getId());

        if (character == null) {
            //New character
            character = new Character();
        }

        character.setName(form.getName());
        character.setTitle(form.getTitle());
        character.setImageLink(form.getImg());
        character.setRace(form.getRace());

        save(character);

        return character;
    }

    public List<Character> allCharacters () {
        return charDao.findAll();
    }

    public Character findById(Integer charId) {
        return charDao.findById(charId);
    }

    public void save (Character character) {
        charDao.save(character);
    }
}
