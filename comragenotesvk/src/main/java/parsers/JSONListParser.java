package parsers;

import java.util.List;

public interface JSONListParser<T> {
    List<T> parseList(String jsonString);
}
