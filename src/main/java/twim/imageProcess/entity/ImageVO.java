package twim.imageProcess.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ImageVO {
    @Id @GeneratedValue
    private Integer id;
    private String mimetype;
    private String original_name;
    private byte[] data;
    private String created;
}
