package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostImageRepo extends JpaRepository<PostImage, Integer> {
    Optional<PostImage> findPostImageByPost_Id(int postId);
}
