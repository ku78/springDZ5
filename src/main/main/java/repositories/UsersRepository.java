package repositories;

import com.geekbrains.july.market.julymarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByPhone(String phone);
    boolean existsByPhone(String phone);

}
