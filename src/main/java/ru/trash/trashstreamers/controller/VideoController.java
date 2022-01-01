package ru.trash.trashstreamers.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.trash.trashstreamers.dto.VideoDto;
import ru.trash.trashstreamers.entity.Streamer;
import ru.trash.trashstreamers.entity.Video;
import ru.trash.trashstreamers.repo.StreamerRepository;
import ru.trash.trashstreamers.repo.VideoRepository;
import ru.trash.trashstreamers.util.VideoUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("video")
public class VideoController {

    private final VideoRepository videoRepository;
    private final StreamerRepository streamerRepository;

    public VideoController(VideoRepository videoRepository, StreamerRepository streamerRepository) {
        this.videoRepository = videoRepository;
        this.streamerRepository = streamerRepository;
    }

    @PostMapping
    public Video addNewVideo(@RequestBody VideoDto videoDto){
        Video video = new Video();
        video.setYoutubeId(VideoUtil.getYouTubeId(videoDto.getYoutube_url()));
        List<Streamer> streamers = streamerRepository.findByIdIn(List.of(videoDto.getIds()));
        video.setStreamers(streamers);
        videoRepository.save(video);
        return video;
    }
}
