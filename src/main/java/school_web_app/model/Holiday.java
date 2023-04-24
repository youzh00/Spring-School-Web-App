package school_web_app.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity{

    @Id
    public  String day;
    public  String reason;
    @Enumerated(EnumType.STRING)
    public Type type;
    public enum Type{
        FESTIVAL, FEDERAL
    }
}
