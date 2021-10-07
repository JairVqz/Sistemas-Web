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

        post("/saludar", (req, res) -> {
            String l = req.queryParams("nombre");
            String p = req.queryParams("password");
            String respuesta;
            System.out.println(l + " " + p);

            if (l.equals("root") && p.equals("123456"))
            window.location.replace('http://127.0.0.1:5500/tabla_datos.html');    
            respuesta = "Bienvenido usuario ";
            else
                respuesta = "Usuario equivocado ";
                window.location.replace("/tabla_datos.html");
            return respuesta + l + " <a href='http://127.0.0.1:5500/envio_formulario.html'>volver</a>";
        });

    }
}