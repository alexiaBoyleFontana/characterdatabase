package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDAO extends JpaRepository<Character, Long> {

}
