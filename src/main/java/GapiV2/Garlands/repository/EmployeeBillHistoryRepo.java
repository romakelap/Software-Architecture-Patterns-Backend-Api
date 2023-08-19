package GapiV2.Garlands.repository;
import GapiV2.Garlands.entity.EmployeeBillHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeBillHistoryRepo extends JpaRepository<EmployeeBillHistory, Integer> {
    List<EmployeeBillHistory> findAllEmployeeBillByUser_Id(int userId);
}
