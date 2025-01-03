package huyvu.service;

import huyvu.dto.request.Product.ProductCreateRequest;
import huyvu.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    ProductCreateRequest createProduct(ProductCreateRequest productCreateRequest);

    Product getProduct(String id);
}
