package school_web_app.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Holiday extends BaseEntity{

    public  String day;
    public  String reason;
    public Type type;
    public enum Type{
        FESTIVAL, FEDERAL
    }
}
