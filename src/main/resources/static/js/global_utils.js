
$(document).ready(function(){

    console.log(units);
    var ingredient_count = 1;

    $('button[name="addIngredient"]').click(function (event) {

        event.preventDefault();
        ingredient_count++;
       $("#ingredients").append("<div class=\"form-row\">\n" +
           "                                            <div class=\"form-group col-md-4\">\n" +
           "                                                <label for=\"ingredient_"+ingredient_count+"\">Ingredient "+ingredient_count+" Name:</label>\n" +
           "                                                <input class=\"form-control\" name=\"ingredient_"+ingredient_count+"\" type=\"text\" id=\"ingredient_"+ingredient_count+"\"/>\n" +
           "                                            </div>\n" +
           "                                            <div class=\"form-group col-md-4\">\n" +
           "                                                <label for=\"amount_"+ingredient_count+"\">Amount:</label>\n" +
           "                                                <input class=\"form-control\" name=\"amount_"+ingredient_count+"\" type=\"text\" id=\"amount_"+ingredient_count+"\"/>\n" +
           "                                            </div>\n" +
           "                                            <div class=\"form-group col-md-4\">\n" +
           "                                                <label for=\"unit_"+ingredient_count+"\">Unit:</label>\n" +
           "                                                <select class=\"form-control\" id=\"unit_"+ingredient_count+"\" name=\"unit\" >\n" +
           "                                                </select>\n" +
           "                                            </div>\n" +
           "                                        </div>");

        $.each(units, function (index,value) {

            $("#unit_"+ingredient_count).append("<option value='"+value.id+"'>"+value.uom+"</option>")
        })

    });



    $("#submit").click(function(){
        var form = {};
        form.description = $("#recipe_description").val();
        form.prepTime = $("#recipe_prepTime").val();
        form.cookTime = $("#recipe_cookTime").val();
        form.servings = $("#recipe_servings").val();
        form.source = $("#recipe_source").val();
        form.directions = $("#recipe_instructions").val();
        form.difficulty = $("#recipe_difficulty").val();

        form.categories = [1];
        var category = {}
        category.id=$("#recipe_category").val();
        form.categories[0] = category;

        form.notes = {};
        form.notes.recipeNotes = $("#recipe_notes").val();


        form.ingredients = [ingredient_count];
        var i;
        for(i=1; i<= ingredient_count; i++){
            var ingredient = {}
            ingredient["description"] = $("#ingredient_"+i).val();
            ingredient["amount"] = $("#amount_"+i).val();
            ingredient["uom"] = {};
            ingredient["uom"].id = $("#unit_"+i).val();
            form.ingredients[i-1] = ingredient;
        }
        console.log(JSON.stringify(form));


        $.ajax({
            url:"add",
            type:"POST",
            data:JSON.stringify(form),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            statusCode:{
                200: function(data){
                    alert("OK");
                    window.location.href = "/recipe/"+data.id;
                }}
        });
    });
});