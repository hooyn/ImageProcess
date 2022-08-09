package twim.imageProcess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import twim.imageProcess.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
