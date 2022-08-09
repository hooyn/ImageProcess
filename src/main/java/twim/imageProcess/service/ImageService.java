package twim.imageProcess.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import twim.imageProcess.entity.Image;
import twim.imageProcess.repository.ImageRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    @Transactional
    public Integer fileUpload(MultipartFile file) throws IOException {
        Image imageVO = new Image();
        imageVO.setMimetype(file.getContentType());
        imageVO.setOriginal_name(file.getOriginalFilename());
        imageVO.setData(file.getBytes());
        imageVO.setCreated(String.valueOf(LocalDateTime.now()));
        imageRepository.save(imageVO);

        return imageVO.getId();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<byte[]> findImage(Integer id){
        Optional<Image> imageVO = imageRepository.findById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", imageVO.get().getMimetype());
        headers.add("Content-Length", String.valueOf(imageVO.get().getData().length));

        return new ResponseEntity<byte[]>(imageVO.get().getData(), headers, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public Optional<Image> findImageEntity(Integer id){
        Optional<Image> image = imageRepository.findById(id);
        return image;
    }
}
