package GapiV2.Garlands.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "email")
    @Email
    private String email;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "password")
    private String password;
    private String address;
    private String phoneNumber;
    //    This for since when did you wake up the stand garden
    private String dateOfBirth;
    private String ownerName;

    //RELATIONSHIP============================================
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Follow> following;

    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private Set<Follow> followers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Like> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserImage> images;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @Enumerated(EnumType.STRING) // Add this line to specify EnumType.STRING for the role field
    @Column(name = "role") // Add this column to represent the user's role
    private Role role; // Add Role field to represent the user's role

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SaleBillHistory>saleBillHistories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<EmployeeBillHistory>employeeBillHistories;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<CMS> cms;

//    @OneToMany(mappedBy = "user")
//    private List<Template> templates;

}
