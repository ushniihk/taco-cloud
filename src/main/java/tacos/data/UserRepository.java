package tacos.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tacos.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
