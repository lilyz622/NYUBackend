package json;

import com.google.gson.Gson;

import java.io.Serializable;

public class BaseJson implements Serializable {
    public String toJson() {
        return new Gson().toJson(this);
    }
}
