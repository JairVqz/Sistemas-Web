package mx.uv;

import static spark.Spark.*;
import com.google.gson.*;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Enables CORS on requests. This method is an initialization method and should
        // be called once.

        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        // before((request, response) -> {
        //     response.header("Access-Control-Allow-Origin", origin);
        //     response.header("Access-Control-Request-Method", methods);
        //     response.header("Access-Control-Allow-Headers", headers);
        //     // Note: this may or may not be necessary in your particular application
        //     response.type("application/json");
        // });

        System.out.println("Hello World!");
        get("/index.html", (a, b) -> {
            Object req = a.headers("BAR");
            System.out.println(req);
            String h = "<h1>hola</h1>";
            String f = "<form><input type='text'><input type='submit'></form>";
            return req + h + f;
        });
        get("/alma.html", (a, b) -> "alma");
        get("/juan.html", (a, b) -> "juan");
        get("/dan.html", (a, b) -> "dan");

        post("/hola.html", (a, b) -> "hola");
        get("/hola.html", (a, b) -> "no me llamo así");

        get("/saludar", (req, res) -> {
            String l = req.queryParams("nombre");
            String p = req.queryParams("password");
            String respuesta;
            System.out.println(l + " " + p);

            if (l.equals("root") && p.equals("123456"))
                respuesta = "Bienvenido usuario ";
            else
                respuesta = "Usuario equivocado ";
            return respuesta + l + " <a href='http://127.0.0.1:5500/envio_formulario.html'>volver</a>";
        });

        post("/saludar", (req, res) -> {
            String l = req.queryParams("nombre");
            String p = req.queryParams("password");
            String respuesta;
            System.out.println(l + " " + p);

            if (l.equals("root") && p.equals("123456"))
                respuesta = "Bienvenido usuario ";
            else
                respuesta = "Usuario equivocado ";
            return respuesta + l + " <a href='http://127.0.0.1:5500/envio_formulario.html'>volver</a>";
        });


        post("/saludarJson", (req, res) -> {
            // String l = req.queryParams("firstName");
            // String p = req.queryParams("lastName");
            // String respuesta;
            System.out.println( req.body() );

            // if (l.equals("root") && p.equals("123456"))
            //     respuesta = "Bienvenido usuario ";
            // else
            //     respuesta = "Usuario equivocado ";
            // return respuesta + l + " <a href='http://127.0.0.1:5500/envio_formulario.html'>volver</a>";
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(req.body());
            JsonObject peticion =  arbol.getAsJsonObject();
            Object usuario = peticion.get("firstName") ;
            System.out.println( usuario + " " + peticion.get("password"));

            JsonObject objetoJson = new JsonObject();
            objetoJson.addProperty("usuario", usuario.toString());
            objetoJson.addProperty("access",  "granted");
            objetoJson.addProperty("time",  11111);

            return objetoJson;
        });
    }
}
