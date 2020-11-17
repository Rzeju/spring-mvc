package guru.springframework.springmvn.repositories;

import guru.springframework.springmvn.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
