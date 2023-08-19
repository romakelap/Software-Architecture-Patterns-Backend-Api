package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImageRepo extends JpaRepository<UserImage, Integer> {
    Optional<UserImage> findByUser_Id(int id);
}
