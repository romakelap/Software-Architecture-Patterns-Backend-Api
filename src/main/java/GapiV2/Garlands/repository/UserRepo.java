package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
    void deleteById(int id);
    User findByEmail(String email);
}
