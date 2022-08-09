package twim.imageProcess.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import twim.imageProcess.entity.ImageVO;
import twim.imageProcess.service.ImageService;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/api/upload")
    public Integer imageFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        Integer imageId = imageService.fileUpload(file);

        return imageId;
    }

    @GetMapping("/api/view/{id}")
    public ResponseEntity<byte[]> findImage(@PathVariable int id){
        ResponseEntity<byte[]> image = imageService.findImage(id);
        return image;
    }

    @GetMapping(value = "/api/download/{id}")
    public void imageFileDownload(@PathVariable int id){
        Optional<ImageVO> image = imageService.findImageEntity(id);
        byte[] data = image.get().getData();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        //byte배열을 이미지로 저장
    }
}
