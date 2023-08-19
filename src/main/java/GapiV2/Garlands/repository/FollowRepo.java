package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepo extends JpaRepository<Follow,Integer> {
    List<Follow> findAllByUser_Id(int userId);
    Optional<Follow> findByUser_IdAndFollowing_id(int userId,int followingId);
}
