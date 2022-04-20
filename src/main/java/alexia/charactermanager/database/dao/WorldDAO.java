package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldDAO extends JpaRepository<World, Long> {

    World findById(@Param("id") Integer id);

    World findByName(@Param("name") String name);
}
