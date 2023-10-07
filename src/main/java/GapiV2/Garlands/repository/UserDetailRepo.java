package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDetailRepo extends JpaRepository<UserDetail, Integer> {
    Optional<UserDetail> findByUser_Id(int id);
    List<UserDetail> findAllByUser_IdOrderByIdDesc(int userId);
    void deleteById(int id);
}
