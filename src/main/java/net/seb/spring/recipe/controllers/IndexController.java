package net.seb.spring.recipe.controllers;

import net.seb.spring.recipe.domain.Category;
import net.seb.spring.recipe.domain.UnitOfMeasure;
import net.seb.spring.recipe.repositories.CategoryRepository;
import net.seb.spring.recipe.repositories.RecipeRepository;
import net.seb.spring.recipe.repositories.UnitOfMeasureRepository;
import net.seb.spring.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

//    private final CategoryRepository categoryRepository;
//    private final UnitOfMeasureRepository unitOfMeasureRepository;
//    private final RecipeRepository recipeRepository;
//
//    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//        this.recipeRepository = recipeRepository;
//    }

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
//
//        System.out.println("Category Id is: " + categoryOptional.get().getId());
//        System.out.println("Unit of Measure is: " + unitOfMeasureOptional.get().getId());

        model.addAttribute("recipes", recipeService.getRecipes());


        return "index";
    }
}
