package twim.imageProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import twim.imageProcess.entity.ImageVO;

public interface ImageRepository extends JpaRepository<ImageVO, Integer> {
}
