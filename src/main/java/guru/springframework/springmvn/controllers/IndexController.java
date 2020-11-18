package guru.springframework.springmvn.controllers;

import guru.springframework.springmvn.domain.Category;
import guru.springframework.springmvn.domain.UnitOfMeasure;
import guru.springframework.springmvn.repositories.CategoryRepository;
import guru.springframework.springmvn.repositories.UnitOfMeasureRepository;
import guru.springframework.springmvn.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
