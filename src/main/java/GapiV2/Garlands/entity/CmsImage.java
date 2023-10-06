package GapiV2.Garlands.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CmsImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "data", length = 2000)
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "cms_id")
    private CMS cms;
//    @OneToOne
//    @JoinColumn(name = "template_id")
//    private Template template;
}
