package alexia.charactermanager.service;

import alexia.charactermanager.database.dao.CharLinkDAO;
import alexia.charactermanager.database.dao.CharacterDAO;
import alexia.charactermanager.database.dao.UserDAO;
import alexia.charactermanager.database.entity.CharLink;
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

    @Autowired
    private WorldService worldServ;

    @Autowired
    private CharLinkDAO charLinkDao;

    public Character submitChar(CharacterFormBean form) {

        Character character = findById(form.getId());

        if (character == null) {
            //New character
            character = new Character();
            character.setWorld(worldServ.findByName(form.getWorld()));
        }

        if (form.getName().isBlank()) {
            character.setName("Unnamed");
        } else {
            character.setName(form.getName());
        }
        character.setTitle(form.getTitle());
        character.setImageLink(form.getImg());
        character.setRace(form.getRace());

        //Add Affiliations
        List<String> names = form.getLinks();
        List<String> relations = form.getRelationships();

        Integer currentNum = character.getLinks().size();

        for (int i = 0; i < names.size(); i++) {
            //If not blank - create link


                Character toAdd = charDao.findByName(names.get(i));

                if (toAdd != null) {

                    CharLink link;

                    // If currently in bounds - edit existing
                    if (i < currentNum) {
                        link = character.getLinks().get(i);
                    }
                    else {
                        //If not - create new link
                        link = new CharLink();
                    }

                    link.setFrom(character);
                    link.setTo(charDao.findByName(names.get(i)));

                    //If a relation name was input, add it
                    if (!(relations.get(i).isBlank())) {
                        link.setRelation(relations.get(i));
                    }

                    charLinkDao.save(link);

                    character.getLinks().add(link);

                } else if (i < currentNum) {
                    CharLink link = character.getLinks().get(i);

                    charLinkDao.delete(link);
                    character.getLinks().remove(link);
                }
            }


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

    public void clearWorld(Character character) {
        character.setWorld(null);
    }
}
