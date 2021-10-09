package net.seb.spring.recipe.repositories;

import net.seb.spring.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
