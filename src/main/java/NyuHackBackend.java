import record.RecordGetter;
import spark.Spark;

import static spark.Spark.*;
import static spark.SparkBase.port;

public class NyuHackBackend {
    public static void main(String[] args) {
        Spark.port(4567);

        get("/userModels/", (req, res) -> {
            //authentication to get id String userId = req.header("user_id");
            String userId = "123";

            String json = RecordGetter.getUserModels(userId);

            if(json == null){
                res.status(404);
                res.type("application/json");
                return "{\"msg\":\"failed\"}";
            }

            res.status(200);
            res.type("application/json");
            return json;
        });

        post("/users/", (req, res) -> {
            return null;
        });
    }
}
