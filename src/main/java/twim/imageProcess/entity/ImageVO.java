package twim.imageProcess.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
public class ImageVO {
    @Id @GeneratedValue
    private Integer id;
    private String mimetype;
    private String original_name;

    @Lob
    private byte[] data;
    private String created;
}
