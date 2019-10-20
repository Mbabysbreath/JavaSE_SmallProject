package libiary;

import java.util.Comparator;

/**
 * @author ZhaoMin
 * @date 2019/10/20 21:53
 */
public class AuthorComparator implements Comparator<Book>{
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
