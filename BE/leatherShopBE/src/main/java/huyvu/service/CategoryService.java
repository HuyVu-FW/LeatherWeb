package huyvu.service;

import huyvu.model.Category;

import java.util.List;


public interface CategoryService {
    List< Category > getAllCategory();
    Category createCategory( final Category category );
}
