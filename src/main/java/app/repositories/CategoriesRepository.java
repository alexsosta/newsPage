package app.repositories;

import app.enitites.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepository extends CrudRepository<Category, Long> {

    Category findById(int category_id);

    List<Category> findByCategoryContaining(String category);
}