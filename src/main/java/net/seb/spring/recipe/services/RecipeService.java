package net.seb.spring.recipe.services;

import net.seb.spring.recipe.commands.RecipeCommand;
import net.seb.spring.recipe.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long l);
    void deleteById(Long idToDelete);
}
