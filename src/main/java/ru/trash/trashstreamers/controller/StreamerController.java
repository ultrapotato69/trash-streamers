package ru.trash.trashstreamers.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.trash.trashstreamers.converter.StreamerConverter;
import ru.trash.trashstreamers.dto.ListStreamerDto;
import ru.trash.trashstreamers.dto.NewStreamerDto;
import ru.trash.trashstreamers.entity.Streamer;
import ru.trash.trashstreamers.repo.StreamerRepository;
import ru.trash.trashstreamers.util.StreamerUtil;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("streamer")
public class StreamerController {

    @Value("${upload.path}")
    private String uploadPath;
    
    private final StreamerRepository streamerRepository;
    private final StreamerConverter streamerConverter;

    @Autowired
    public StreamerController(StreamerRepository streamerRepository, StreamerConverter streamerConverter) {
        this.streamerRepository = streamerRepository;
        this.streamerConverter = streamerConverter;
    }

    @GetMapping("{id}")
    Optional<Streamer> getStreamerById(@PathVariable Long id){
        Optional<Streamer> byId = streamerRepository.findById(id);
        return byId;
    }

    @GetMapping
    List<ListStreamerDto> getListDto(){
        return streamerRepository.findAllProjectedBy();
    }

    @PostMapping()
    public Streamer addStreamer(
            @RequestPart("new_streamer") NewStreamerDto newStreamer,
            @RequestPart(value = "picture", required = false) MultipartFile picture
    ){
        Streamer streamer = streamerConverter.convert(newStreamer);
        StreamerUtil.saveStreamerImage(picture, streamer, uploadPath);
        streamerRepository.save(streamer);
        return streamer;
    }
    
}
