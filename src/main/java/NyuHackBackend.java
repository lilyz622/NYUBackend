import static spark.Spark.*;
import static spark.SparkBase.port;

public class NyuHackBackend {
    public static void main(String[] args) {
        get("/users/", (req, res) -> {
            return "users";
        });
    }
}
