package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.CategoryService;
import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("recipe/{id}")
    public String getRecipeById(@PathVariable(name="id") Long id, Model model){

        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe",recipe);

        return "recipe";
    }

    @RequestMapping("recipe/form")
    public String getRecipeForm(Model model){

        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories",categoryService.getCategories());
        return "recipe_form";
    }

    @RequestMapping(path = "recipe/add", method= RequestMethod.POST)
    public String addRecipe(@ModelAttribute("recipe") Recipe newRecipe, Model model){
        System.out.println("New Recipe: "+ newRecipe.getDescription());
        Recipe confirmedRecipe =  recipeService.addRecipe(newRecipe);
        model.addAttribute("recipe", confirmedRecipe);
        return "success_add_recipe";
    }
}
