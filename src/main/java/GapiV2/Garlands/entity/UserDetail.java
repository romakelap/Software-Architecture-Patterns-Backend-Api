package GapiV2.Garlands.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String phoneNumber;
//    This for since when did you wake up the stand garden
    private String dateOfBirth;
    private String ownerName;

//    private String profileImageURL;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
