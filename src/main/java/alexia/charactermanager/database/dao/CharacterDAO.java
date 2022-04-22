package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterDAO extends JpaRepository<Character, Long> {

    Character findById(@Param("id") Integer id);

    Character findByName(@Param("name") String name);
}
