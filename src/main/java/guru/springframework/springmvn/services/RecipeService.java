package guru.springframework.springmvn.services;

import guru.springframework.springmvn.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
