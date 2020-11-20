package guru.springframework.springmvn.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
    }


    @Test
    void getId() {
        Long idValue = 4L;

        category.setId(4L);

        assertEquals(4L, category.getId());
    }

    @Test
    void getDescription() {
        String someDescription = "Some description!";

        category.setDescription(someDescription);

        assertEquals("Some description!", category.getDescription());
    }

    @Test
    void getRecipes() {
    }
}