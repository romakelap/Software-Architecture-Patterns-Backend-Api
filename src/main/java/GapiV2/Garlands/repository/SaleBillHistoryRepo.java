package GapiV2.Garlands.repository;

import GapiV2.Garlands.entity.SaleBillHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleBillHistoryRepo extends JpaRepository<SaleBillHistory, Integer>  {
    List<SaleBillHistory> findAllSaleBillByUser_Id(int userId);
}
