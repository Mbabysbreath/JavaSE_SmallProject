package action;

import database.BookShelf;
import exception.NoSuchBookException;
import libiary.Book;

/**
 * @author ZhaoMin
 * @date 2019/10/10 20:14
 */
public class Action {
    //单例模式，获取共有的书架对象

    public static Book putBook(String ISBN, String title, String author, double price, int count) {
        BookShelf bookShelf=BookShelf.getInstance();
       try{
           Book book=bookShelf.search(ISBN);
           book.increaseCount(count);
           return book;
       }catch(NoSuchBookException exc){
           Book book=new Book(ISBN,title,author,price,count);
           bookShelf.putBook(book);
           return book;
       }
    }
    public  static List<Book> queryBooks(){
        BookShelf bookShelf=BookShelf.getInstance();
        bookShelf.queryBooks();
    }
}
