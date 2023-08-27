package GapiV2.Garlands.mapper;

import GapiV2.Garlands.entity.SaleBillHistory;
import GapiV2.Garlands.response.GetSaleBillHistoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleBillHistoryMapper {
    @Mapping(source = "user.id", target = "userId")
//    @Mapping(source = "user.firstName", target = "userFirstName")
//    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "SaleBillHistory.id", target = "id")
    @Mapping(source = "SaleBillHistory.username", target = "username")
    @Mapping(source = "SaleBillHistory.address", target = "address")
    @Mapping(source = "SaleBillHistory.contactNumber", target = "contactNumber")
    @Mapping(source = "SaleBillHistory.payMethod", target = "payMethod")
    @Mapping(source = "SaleBillHistory.user.id", target = "userId")
    @Mapping(source = "SaleBillHistory.createDate", target = "createDate")
    @Mapping(source = "SaleBillHistory.productNames", target = "productNames")
    @Mapping(source = "SaleBillHistory.descProduct", target = "descProduct")
    @Mapping(source = "SaleBillHistory.prices", target = "prices")
    @Mapping(source = "SaleBillHistory.quantities", target = "quantities")
    GetSaleBillHistoryResponse saleBillHistoryToResponse(SaleBillHistory saleBillHistory);

    List<GetSaleBillHistoryResponse> saleBillHistoriesToResponses(List<SaleBillHistory> saleBillHistories);
}
