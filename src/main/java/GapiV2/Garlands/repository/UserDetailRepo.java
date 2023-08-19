package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserDetailRepo extends JpaRepository<UserDetail, Integer> {
}
