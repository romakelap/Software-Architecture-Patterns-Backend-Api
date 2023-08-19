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
public class EmployeeBillHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    Employee Side
    @Column(name = "username")
    private String username;
    @Column(name = "contact_number")
    private String contactNumber;
    //Value : Harian / Bulanan
    @Column(name = "working_method")
    private String workingMethod;
//    Employee side end



    // Date bill created
    @Column(name = "create_date")
    private LocalDate createDate;

    // Date for start the work
    @Column(name = "work_date")
    private List<LocalDate> workDate;

    @Column(name = "description_employee")
    private List<String> descEmployee;

    @Column(name = "salary")
    private List<Double> salary;

    //RELATIONSHIP
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //RELATIONSHIP END
}
