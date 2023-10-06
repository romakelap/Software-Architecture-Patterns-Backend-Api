package GapiV2.Garlands.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleBillHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    Customer Side
    @Column(name = "username")
    private String username;
    @Column(name = "address")
    private String address;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "pay_method")
    private String payMethod;
//    Customer side end

    //RELATIONSHIP
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //RELATIONSHIP END

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "product_name")
    private List<String> productNames;

    @Column(name = "description_product_name")
    private List<String> descProduct;

    @Column(name = "prices_product")
    private List<Double> prices;

    @Column(name = "quantities")
    private List<Integer> quantities;


//    STATUS
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusSaleBillHistory statusSaleBillHistory;

}
