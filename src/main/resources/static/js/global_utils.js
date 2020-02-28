
$(document).ready(function(){
    $('button[name="addIngredient"]').click(function (event) {

        event.preventDefault();
       $("#ingredients").append("<div class=\"form-row\">\n" +
           "                                            <div class=\"form-group col-md-4\">\n" +
           "                                                <label for=\"ingredient_1\">Ingredient 1 Name:</label>\n" +
           "                                                <input name=\"ingredient_1\" class=\"form-control\" type=\"text\" id=\"ingredient_1\"/>\n" +
           "                                            </div>\n" +
           "                                        </div>");

    });
});