package school_web_app.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(EntityListeners.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
