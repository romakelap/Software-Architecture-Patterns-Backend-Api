package GapiV2.Garlands.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSaleBillHistoryResponse {
    private  int userId;
    private int id;
    //CUSTOMER SIDE
    private String username;
    private String address;
    private String contactNumber;
    private String payMethod;
    // CUSTOMER SIDE END


    // Product Side
    private LocalDate createDate;
    private List<String> productNames;
    private List<String> descProduct;
    private List<Double> prices;
    private List<Integer> quantities;

}
