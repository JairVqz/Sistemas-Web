package mx.uv;

import static spark.Spark.*;

import spark.ModelAndView;
import spark.template.handlebars.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ){

        System.out.println("Hello world");
        staticFiles.location("/");

        port(getHerokuAssignedPort());
        get("/hello", (req, res) -> "Hello Heroku World");


        get("/handleB",(req,res)->{
            Map<String,String> model = new HashMap<>();
            model.put("cartel","https://www.dodmagazine.es/wp-content/uploads/2018/01/la-forma-del-agua.jpg");
            model.put("titulo","LA FORMA DEL AGUA");
            model.put("anio","2017");
            model.put("duracion","123");   
            model.put("sinopsis","Durante la Guerra Fría Elisa, una joven muda, trabaja en un laboratorio gubernamental de alta seguridad. Pero su vida cambia cuando descubre un experimento secreto: un hombre anfibio que se encuentra recluido en un tanque.");           
            return new HandlebarsTemplateEngine().render(new ModelAndView(model, "/EjemploHandle.hbs"));
        });

    

    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
