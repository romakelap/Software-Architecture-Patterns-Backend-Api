package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    void deleteById(int id);
    List<Comment> findAllByUser_Id(int userId);
    List<Comment> findAllByPost_Id(int postId);
}
