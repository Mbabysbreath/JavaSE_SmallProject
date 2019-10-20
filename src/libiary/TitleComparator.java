package libiary;

import java.util.Comparator;

/**
 * @author ZhaoMin
 * @date 2019/10/20 22:03
 */
public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
