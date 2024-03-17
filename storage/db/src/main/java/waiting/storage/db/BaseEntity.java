package waiting.storage.db;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Getter
@MappedSuperclass
public abstract class BaseEntity extends BaseTimeEntity{

    @Id
    @Comment("ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreatedBy
    @Comment("생성자 USER ID")
    @Column(name = "created_id")
    private String createdId;

    @LastModifiedBy
    @Comment("수정자 USER ID")
    @Column(name = "updated_id")
    private String updatedId;
}
