package net.seb.spring.recipe.converters;

import net.seb.spring.recipe.commands.CategoryCommand;
import net.seb.spring.recipe.commands.IngredientCommand;
import net.seb.spring.recipe.commands.NotesCommand;
import net.seb.spring.recipe.commands.RecipeCommand;
import net.seb.spring.recipe.domain.Difficulty;
import net.seb.spring.recipe.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    public static final Long RECIPE_ID = 1L;
    public static final Integer COOK_TIME = Integer.valueOf("5");
    public static final Integer PREP_TIME = Integer.valueOf("7");
    public static final String DESCRIPTION = "My Recipe";
    public static final String DIRECTIONS = "Directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final Integer SERVINGS = Integer.valueOf("3");;
    public static final String SOURCE = "Source";
    public static final String URL = "Some URL";
    public static final Long CAT_ID_1 = 1L;
    public static final Long CAT_ID_2 = 2L;
    public static final Long INGREDIENT_ID_1 = 3L;
    public static final Long INGREDIENT_ID_2 = 4L;
    public static final Long NOTES_ID = 9L;

    RecipeCommandToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() throws Exception {
        // given
        RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(RECIPE_ID);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDirections(DIRECTIONS);
        recipeCommand.setDifficulty(DIFFICULTY);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        NotesCommand notes = new NotesCommand();
        notes.setId(NOTES_ID);

        recipeCommand.setNotes(notes);

        CategoryCommand category1 = new CategoryCommand();
        category1.setId(CAT_ID_1);

        CategoryCommand category2 = new CategoryCommand();
        category2.setId(CAT_ID_2);

        recipeCommand.getCategories().add(category1);
        recipeCommand.getCategories().add(category2);

        IngredientCommand ingredient1 = new IngredientCommand();
        ingredient1.setId(INGREDIENT_ID_1);

        IngredientCommand ingredient2 = new IngredientCommand();
        ingredient2.setId(INGREDIENT_ID_2);

        recipeCommand.getIngredients().add(ingredient1);
        recipeCommand.getIngredients().add(ingredient2);

        // when
        Recipe recipe = converter.convert(recipeCommand);

        // then
        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());

    }
}