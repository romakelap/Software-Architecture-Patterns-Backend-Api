package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.EmployeeBillHistory;
import GapiV2.Garlands.response.GetEmployeeBillHistoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeBillHistoryMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    GetEmployeeBillHistoryResponse employeeBillHistoryToResponse(EmployeeBillHistory employeeBillHistory);

    List<GetEmployeeBillHistoryResponse> employeeBillHistoriesToResponses(List<EmployeeBillHistory> employeeBillHistories);
}
