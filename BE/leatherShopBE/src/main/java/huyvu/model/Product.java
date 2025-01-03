package huyvu.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String shortDescription;
    private String description;
    private int initPrice;
    private String note;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
