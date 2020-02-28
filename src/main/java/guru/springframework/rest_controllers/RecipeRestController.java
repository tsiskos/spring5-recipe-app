package guru.springframework.rest_controllers;

import guru.springframework.domain.Recipe;

import guru.springframework.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeRestController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(path = "recipe/add", method = RequestMethod.POST)
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe newRecipe){
        System.out.println("New Recipe: "+ newRecipe.getDescription());
        Recipe confirmedRecipe =  recipeService.addRecipe(newRecipe);

        return new ResponseEntity<Recipe>(confirmedRecipe, HttpStatus.OK);
    }
}
