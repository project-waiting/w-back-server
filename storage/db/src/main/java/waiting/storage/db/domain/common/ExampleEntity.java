package waiting.storage.db.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import waiting.storage.db.BaseEntity;

@Getter
@Entity
@Table(name = "TBL_SAMPLE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExampleEntity extends BaseEntity {

    @Comment("예제 컬럼")
    @Column
    private String exampleColumn;

    @Builder
    public ExampleEntity(String exampleColumn) {
        this.exampleColumn = exampleColumn;
    }

    public void setExampleColumn(String exampleColumn) {
        this.exampleColumn = exampleColumn;
    }

    public static ExampleEntity of(String exampleColumn) {
        return ExampleEntity.builder()
                .exampleColumn(exampleColumn)
                .build();
    }
}
