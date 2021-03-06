package net.seb.spring.recipe.services;

import net.seb.spring.recipe.commands.IngredientCommand;
import org.springframework.stereotype.Service;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(Long recipeId, Long id);
}
