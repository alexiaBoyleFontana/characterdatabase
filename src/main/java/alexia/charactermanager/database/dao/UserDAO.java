package alexia.charactermanager.database.dao;

import alexia.charactermanager.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username);

    User findById (@Param("id") Integer id);

}
