package GapiV2.Garlands.request;

import GapiV2.Garlands.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBillHistoryRequest {
    private String username;
    private String contactNumber;
    private String workingMethod;
    private LocalDate createDate;
    private List<LocalDate> workDate;
    private List<String> descEmployee;
    private List<Double> salary;
    private User user;
}
