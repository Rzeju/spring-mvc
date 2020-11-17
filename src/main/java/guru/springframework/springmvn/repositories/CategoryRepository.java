package guru.springframework.springmvn.repositories;

import guru.springframework.springmvn.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
