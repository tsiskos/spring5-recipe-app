package guru.springframework.dtos;

import guru.springframework.domain.Ingredient;

import java.util.HashSet;
import java.util.Set;

public class IngredientListWraperDTO {

    private Set<Ingredient> ingredients = new HashSet<>();

    public IngredientListWraperDTO(){

    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
