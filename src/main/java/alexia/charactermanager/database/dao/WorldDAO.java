package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldDAO extends JpaRepository<World, Long> {
}
