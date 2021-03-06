import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;
/**
 * Created by Guest on 1/8/18.
 */
public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            return new ModelAndView(new HashMap(), "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/changeMachine", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ChangeMachine changeMachine = new ChangeMachine();
            Float cashInput = Float.parseFloat(request.queryParams("cashInput"));
            String change = changeMachine.makeChange(cashInput);
            model.put("change", change);
            return new ModelAndView(model, "change.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
