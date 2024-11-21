package Model.Tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface IdGenerator {
    public default Long generateID() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String newDate = date.format(formatter);
        return Long.valueOf(newDate);
    }
}
