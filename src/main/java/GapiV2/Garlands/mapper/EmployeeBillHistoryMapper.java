package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.EmployeeBillHistory;
import GapiV2.Garlands.request.EmployeeBillHistoryRequest;
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

    @Mapping(source = "userId",target = "user.id")
    EmployeeBillHistory employeeBillAddRequestToBill(EmployeeBillHistoryRequest employeeBillHistoryRequest);

    List<GetEmployeeBillHistoryResponse> employeeBillHistoriesToResponses(List<EmployeeBillHistory> employeeBillHistories);
}
