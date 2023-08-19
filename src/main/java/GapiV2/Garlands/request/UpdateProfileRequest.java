package GapiV2.Garlands.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    //    This for since when did you wake up the stand garden
    private String dateOfBirth;
    private String ownerName;
}
