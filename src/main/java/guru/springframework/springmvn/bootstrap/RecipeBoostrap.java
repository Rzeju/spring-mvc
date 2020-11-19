package guru.springframework.springmvn.bootstrap;

import guru.springframework.springmvn.domain.*;
import guru.springframework.springmvn.repositories.CategoryRepository;
import guru.springframework.springmvn.repositories.RecipeRepository;
import guru.springframework.springmvn.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBoostrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBoostrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }


        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not Found");
        }

        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirection("1. Directions for Guacamole Recipe wwwwwwwwwwwwwwwwwwwwww.\n" +
                "\n" +
                "2. HIhihihhihihihhi hphphpkjhkjhkjhkjhkjhkjhkjhkjhkjhkjhkjhkjhkjhkjhkjgkjhgjkhgjghjgkgjkhgjkgjhgkgkjhgjkhg.\n" +
                "\n" +
                "3. kjhsfkjashfjskfhaskjfhkjsahfksjahfkasjhkjsfgdghfdgfdgfhdhgfdgfhdghfdghfdhgdhgfdghfdhgdfghfdghdhg.\n" +
                "4. kjhsajkdhskdjhdkasjdhaskjdhsadkjadhsakjdhskjdhaksjhdksajhdkjashdkjsahskjhdkaskjhjkhkjhkjh." +
                "kjhghjkgkjhgjkgkjhgkjhgjkhgjuyrtyskdxgupu[hijuhkghjfjfghkfkhfkhgfkfkfkghjfkfkhgfkhfhfkhgfhkgfhkgfkhf\n" +
                "5. lkjjlkjlkjlkhhlkjhlkhlkhkiughikugkfgffdhdrdthsshsjgfdgfdhjfjhfhfkhfhjfhgfhgfkgfhkfhgfhjfhjgfhgf" +
                "jhkjhkjhkjhlgkhgjhkgjhkgkjhgjggkj;vhdajkhddhdsjkh;djshsdjhjkvbsvkjsdabvksdbvdkhvbsvk;hsbakhvbsk;vsgvkgsdv" +
                "kjshkasjhhaskhkjsahcaldkjhasdklhkjclhcklsdjhckdsjhckjshckljchskjlhcskjhcksljdhcaklchksdjchsdklhskjchsdklchsdkclh" +
                "\n" +
                "\n" +
                "Read more http://www.simplerecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Notes for Guacamole Recipe");

        guacRecipe.setNotes(guacNotes);

        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaSpoonUom));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("serrano chilies, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashUom));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(2), dashUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setCookTime(9);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirection("2. Directions for Tacos Recipe wwwwwwwwwwwwwwwwwwwwww.\n" +
                "\n" +
                "2. fasdfhjlfhfflhfflfdhewfpoewefppdvjvcpbvbapfbufdbapfdbfdubfdibafdbufdudbfdbdfbdfbfdabfddfbdf.\n" +
                "\n" +
                "3. kjhsfkjashfjskfhaskjfhkjsahfksjahfkasjhkjsfgdghfdgfdgfhdhgfdgfhdghfdghfdhgdhgfdghfdhgdfghfdghdhg.\n" +
                "4. kjhsajkdhskdjhdkasjdhaskjdhsadkjadhsakjdhskjdhaksjhdksajhdkjashdkjsahskjhdkaskjhjkhkjhkjh." +
                "kjhghjkgkjhgjkgkjhgkjhgjkhgjuyrtyskdxgupu[hijuhkghjfjfghkfkhfkhgfkfkfkghjfkfkhgfkhfhfkhgfhkgfhkgfkhf\n" +
                "5. lkjjlkgeryyrttyekukhgnvcbipbbizbpdthsshsjgfdgfdhjfjhfhfkhfhjfhgfhgfkgfhkfhgfhjfhjgfhgf" +
                "jhkjhkjhkjhlgkhgjhkgjhkgkjhgjggkj;vhdajkhddhdsjkh;djshsdjhjkvbsvkjsdabvksdbvdkhvbsvk;hsbakhvbsk;vsgvkgsdv" +
                "kjshkasjhhaskhkjsahcaldkjhasdklhkjclhcklsdjhckdsjhckjshckljchskjlhcskjhcksljdhcaklchksdjchsdklhskjchsdklchsdkclh" +
                "\n" +
                "\n" +
                "Read more http://www.simplerecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("Some notes for tacos recipe");

        tacosRecipe.setNotes(tacosNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(".5"), teaSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Clove of Garlic, chopped", new BigDecimal(1), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoonUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("small corn tortillas", new BigDecimal(8), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), cupUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("medium riped avocados, sliced", new BigDecimal(4), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("radished, thinly sliced", new BigDecimal(4), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupUom, tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom, tacosRecipe));

        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);

        return recipes;
    }

}
