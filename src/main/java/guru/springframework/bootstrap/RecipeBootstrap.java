package guru.springframework.bootstrap;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeBootstrap {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>();

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findUnitOfMeasureByUom("Each");
        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excpected UOM not Found");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findUnitOfMeasureByUom("Tablespoon");
        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Excpected UOM not Found");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findUnitOfMeasureByUom("Teaspoon");
        if(!teaspoonUomOptional.isPresent()){
            throw new RuntimeException("Excpected UOM not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findUnitOfMeasureByUom("Dash");
        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Excpected UOM not Found");
        }

        return recipes;

    }

}
