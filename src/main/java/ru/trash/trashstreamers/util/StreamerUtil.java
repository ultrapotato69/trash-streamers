package ru.trash.trashstreamers.util;

import org.springframework.web.multipart.MultipartFile;
import ru.trash.trashstreamers.entity.Streamer;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class StreamerUtil {
    public static void saveStreamerImage(MultipartFile file, Streamer streamer, String uploadPath) {
        if (file != null && !file.isEmpty() && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            File origFile = new File(uploadPath + "/" + resultFilename);
            try {
                file.transferTo(origFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            streamer.setPictureName(resultFilename);
        }
    }
}
