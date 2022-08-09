package twim.imageProcess.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id @GeneratedValue
    private Integer id;
    private String mimetype;
    private String original_name;

    @Lob
    private byte[] data;
    private String created;
}
