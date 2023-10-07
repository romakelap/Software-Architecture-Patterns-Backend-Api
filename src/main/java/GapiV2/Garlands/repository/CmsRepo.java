package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.CMS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmsRepo extends JpaRepository<CMS, Integer> {

    List<CMS> findAllByUser_IdOrderById(int userId);
    void deleteById(int id);

}
