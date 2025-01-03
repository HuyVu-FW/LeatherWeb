package huyvu.controller;

import huyvu.dto.ApiResponse;
import huyvu.exception.ResponseCode;
import huyvu.model.Category;
import huyvu.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category/")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping
    public String getCategory() {
        categoryService.getAllCategory();

        return "Hello World";
    }
    @PostMapping
    public ApiResponse<Category> addCategory(@RequestBody final Category category) {
        return new ApiResponse<>(ResponseCode.CATEGORY_CREATE_SUCCESSFUL,categoryService.createCategory(category)) ;
    }
}
