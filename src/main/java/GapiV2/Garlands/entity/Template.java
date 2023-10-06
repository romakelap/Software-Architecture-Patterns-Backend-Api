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
@Table(name = "TemplateCms")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String htmlContent;
    private String cssContent;
    private String jsContent;

//    @ManyToOne
//    @JoinColumn(name = "cms_id")
//    private CMS cms;
}


