package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.CharLink;
import alexia.charactermanager.database.entity.Character;
import alexia.charactermanager.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharLinkDAO extends JpaRepository<CharLink, Long> {
}
