package twim.imageProcess.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import twim.imageProcess.entity.Image;
import twim.imageProcess.service.ImageService;

import java.io.*;
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
    public void imageFileDownload(@PathVariable int id) throws IOException {
        File file = new File("C:\\Users\\TWIM\\Pictures\\image\\download.jpeg");

        Optional<Image> image = imageService.findImageEntity(id);
        byte[] data = image.get().getData();

        FileOutputStream fop = new FileOutputStream(file);

        if(!file.exists()){
            file.createNewFile();
        }

        fop.write(data);
        fop.flush();
        fop.close();
    }
}
