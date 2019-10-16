package database;

/**
 * @author ZhaoMin
 * @ate 2019/10/16 23:12
 */
public interface Where<E> {
    boolean test(E e);
}
