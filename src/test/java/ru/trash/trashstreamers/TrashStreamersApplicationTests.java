package ru.trash.trashstreamers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ru.trash.trashstreamers.entity.Streamer;
import ru.trash.trashstreamers.entity.Video;
import ru.trash.trashstreamers.repo.StreamerRepository;
import ru.trash.trashstreamers.repo.VideoRepository;
import ru.trash.trashstreamers.util.VideoUtil;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class TrashStreamersApplicationTests {

    @Autowired
    StreamerRepository streamerRepository;
    @Autowired
    VideoRepository videoRepository;
    @Value("${upload.path}")
    private String uploadPath;

    @Test
    void firstInit() {

        Video video = new Video();
        video.setName("СЕРГЕЙ СИМОНОВ — ВЖЛИНК НАШЕЛ НОВОГО КОРОЛЯ ЕБАТОРИИ");
        String pathVideo1 = "https://www.youtube.com/watch?v=6F6JrYs3lxM";
        video.setYoutubeId(VideoUtil.getYouTubeId(pathVideo1));
        video.setDescription("Симонов и линк");
        video = videoRepository.save(video);

        Streamer vjLink = new Streamer();
        vjLink.setPseudonym("VjLink");
        vjLink.setFirstname("Кирилл");
        vjLink.setLastname("Зырянов");
        vjLink.setDescription("Ему зубы выбил его кореш.");
        Set<String> otherNames = new LinkedHashSet<>();
        otherNames.add("Top gamer in the World!");
        otherNames.add("Ludojop");
        vjLink.setOtherPseudonyms(otherNames);
        vjLink.setPictureName("maxresdefault.jpg");
        vjLink.addVideo(video);
        streamerRepository.save(vjLink);
        printStreamer(1L);

        Streamer simonov = new Streamer();
        simonov.setPseudonym("Симонов");
        simonov.setDescription("Симонов сдал в аренду свой канал мошенникам.");
        simonov.setPictureName("artworks.jpg");
        simonov.addVideo(video);
        simonov = streamerRepository.save(simonov);

        printStreamer(simonov.getId());

    }

    @Test
    public void addSecondVideo(){
        Video video = new Video();
        video.setName("ДДОСЕРАМ ОТВЕТ");
        String pathVideo1 = "https://www.youtube.com/watch?v=mjuS_vZ2Gp4";
        video.setYoutubeId(VideoUtil.getYouTubeId(pathVideo1));
        video.setDescription("vjlink hero");
        Streamer vjlink = streamerRepository.findFirstByPseudonym("VjLink").get();
        video.setStreamers(List.of(vjlink));
        videoRepository.save(video);
    }




    public void printStreamer(Long id){
        Streamer streamer = streamerRepository.findById(id).get();
        System.out.println(streamer);

        /*List<Video> streamerVideos = streamer.getVideos();
        streamer.setVideos(streamerVideos);
        streamer.getVideos().forEach(video -> System.out.print(video.getName() + " "));*/

        File streamerPicture = new File(uploadPath + "/" + streamer.getPictureName());
        System.out.println(streamerPicture.length() + "\n");
    }




}
