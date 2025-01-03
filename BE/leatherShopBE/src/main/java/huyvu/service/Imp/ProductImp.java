package huyvu.service.Imp;


import huyvu.dto.request.Product.ProductCreateRequest;
import huyvu.exception.AppException;
import huyvu.exception.ResponseCode;
import huyvu.model.Product;
import huyvu.repository.CategoryRepository;
import huyvu.repository.ProductRepository;
import huyvu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImp implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public ProductCreateRequest createProduct(ProductCreateRequest productCreateRequest) {
        var category = categoryRepository.findById(productCreateRequest.getCategoryId()).orElseThrow(
                () -> new AppException(ResponseCode.CATEGORY_NOT_EXISTED)
        );
        Product product = Product.builder()
                .name(productCreateRequest.getName())
                .shortDescription(productCreateRequest.getShortDescription())
                .description(productCreateRequest.getDescription())
                .initPrice(productCreateRequest.getInitPrice())
                .note(productCreateRequest.getNote())
                .img1(productCreateRequest.getImg1())
                .img2(productCreateRequest.getImg2())
                .img3(productCreateRequest.getImg3())
                .img4(productCreateRequest.getImg4())
                .img5(productCreateRequest.getImg5())
                .category(category)
                .build();
        productRepository.save(product);
        return productCreateRequest;
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElseThrow(
                () -> new AppException(ResponseCode.PRODUCT_NOT_EXISTED));
    }
}
