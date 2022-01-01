package ru.trash.trashstreamers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trash.trashstreamers.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}