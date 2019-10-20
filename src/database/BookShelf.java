package database;

import exception.NoSuchBookException;
import libiary.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/10/10 20:17
 */
public class BookShelf {
    //书架上书的集合
    private List<Book> bookList=new ArrayList<>();
    //单例模式，饿汉模式
    private static BookShelf instance=new BookShelf();
    public static BookShelf getInstance(){
        return instance;
    }
    //在书架中找有无当前ISBN的书
    public Book search(String ISBN)throws NoSuchBookException{
        for(Book book:bookList){
            if(book.is(ISBN)) {
                return book;
            }
        }
        throw new NoSuchBookException(ISBN);
    }
    //给书架里放入新书
    public void putBook(Book book){

        bookList.add(book);
    }
    public List<Book> queryBooks(Where<Book> where,Comparator<Book> orderBy){//返回图书的集合bookList
      List<Book> ret=new ArrayList<>();
      for(Book book:bookList){
          if(where==null||where.test(book)){
              ret.add(book);
          }
      }
        return ret;
    }

}
