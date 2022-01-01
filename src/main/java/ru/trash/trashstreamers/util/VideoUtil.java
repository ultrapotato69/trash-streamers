package ru.trash.trashstreamers.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoUtil {

    public static String getYouTubeId(String youtubeLink){
        String vId = null;
        Pattern pattern = Pattern.compile(
                "(?:http|https|)(?::\\/\\/|)(?:www.|)(?:youtu\\.be\\/|youtube\\.com(?:\\/embed\\/|\\/v\\/|\\/watch\\?v=|\\/ytscreeningroom\\?v=|\\/feeds\\/api\\/videos\\/|\\/user\\\\S*[^\\w\\-\\s]|\\S*[^\\w\\-\\s]))([\\w\\-\\_]{11})[a-z0-9;:@#?&%=+\\/\\$_.-]*",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(youtubeLink);
        if (matcher.matches()){
            vId = matcher.group(1);
        }
        return vId;
    }
}
