package guru.springframework.controllers;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.dtos.IngredientListWraperDTO;
import guru.springframework.services.CategoryService;
import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;

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
        Recipe recipe = new Recipe();
        recipe.getIngredients().add(new Ingredient());
        model.addAttribute("recipe",recipe);
        model.addAttribute("categories",categoryService.getCategories());
        return "recipe_form";
    }




}
