package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.CmsImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CmsImageRepo extends JpaRepository<CmsImage, Integer> {
    Optional<CmsImage> findCmsImgByCmsId(int cmsId);
}
