package school_web_app.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Holiday {

    public final String day;
    public final String reason;
    public final Type type;
    public enum Type{
        FESTIVAL, FEDERAL
    }
}
