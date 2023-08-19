package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findAllByUser_IdOrderByIdDesc(int userId);
    void deleteById(int id);
}
