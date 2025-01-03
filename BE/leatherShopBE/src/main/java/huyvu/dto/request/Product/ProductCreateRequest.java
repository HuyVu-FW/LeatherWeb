package huyvu.dto.request.Product;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductCreateRequest {
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
    private String categoryId;
}
