package huyvu.service.Imp;

import huyvu.exception.AppException;
import huyvu.exception.ResponseCode;
import huyvu.model.Category;
import huyvu.repository.CategoryRepository;
import huyvu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryImp implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        if(categoryRepository.existsByName(category.getName()))
            throw new AppException(ResponseCode.CATEGORY_IS_EXISTED);
        return categoryRepository.save( category );
    }
}
