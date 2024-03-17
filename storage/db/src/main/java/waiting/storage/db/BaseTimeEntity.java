package waiting.storage.db;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.sql.Timestamp;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @CreationTimestamp
    @Comment("최초 등록 일시")
    @Column(name ="created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Comment("최종 수정 일시")
    @Column(name ="updated_at")
    private Timestamp updatedAt;
}
