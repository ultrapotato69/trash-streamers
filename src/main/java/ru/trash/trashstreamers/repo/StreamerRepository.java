package ru.trash.trashstreamers.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.trash.trashstreamers.dto.ListStreamerDto;
import ru.trash.trashstreamers.entity.Streamer;

import java.util.List;
import java.util.Optional;

@Repository
public interface StreamerRepository extends JpaRepository<Streamer, Long> {
    List<ListStreamerDto> findAllProjectedBy();
    Optional<Streamer> findFirstByPseudonym(String pseudonym);
    List<Streamer> findByIdIn(List<Long> ids);
}