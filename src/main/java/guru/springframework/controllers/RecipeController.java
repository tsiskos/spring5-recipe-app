package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("recipe/{id}")
    public String getRecipeById(@PathVariable(name="id") Long id, Model model){

        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("recipe",recipe);

        return "recipe";
    }
}
