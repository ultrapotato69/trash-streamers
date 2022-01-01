package ru.trash.trashstreamers.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.trash.trashstreamers.dto.NewStreamerDto;
import ru.trash.trashstreamers.entity.Streamer;

@Component
public class StreamerConverter implements Converter<NewStreamerDto, Streamer> {
    @Override
    public Streamer convert(NewStreamerDto source) {
        return new Streamer(source.getPseudonym(), source.getFirstname(), source.getLastname());
    }
}
