package guru.springframework.springmvn.controllers;

import guru.springframework.springmvn.domain.Category;
import guru.springframework.springmvn.domain.UnitOfMeasure;
import guru.springframework.springmvn.repositories.CategoryRepository;
import guru.springframework.springmvn.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getIndexPage() {

        Optional<Category>  categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id is " + categoryOptional.get().getId());
        System.out.println("Unit of Measure Id is " + uomOptional.get().getId());

        System.out.println("HELLO!");
        return "index";
    }
}
