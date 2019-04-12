package selectors;

import java.util.Comparator;
import java.util.List;

public interface TopSelector <T> {
    List<T> selectTop(List<T> servers, Comparator<T> comparator, int count);
}
