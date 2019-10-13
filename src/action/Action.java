package action;

import database.BookShelf;
import database.RecordShelf;
import exception.BorrowedOutException;
import exception.NoSuchBookException;
import exception.YetBorrowedException;
import libiary.Book;
import libiary.User;

import java.util.List;

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
        return   bookShelf.queryBooks();
    }

    public static Book borrowBook(User user, String ISBN)
            throws BorrowedOutException, YetBorrowedException, NoSuchBookException {
        BookShelf bookShelf=BookShelf.getInstance();
        RecordShelf recordShelf=RecordShelf.getInstance();
        Book book= bookShelf.search(ISBN);
        if(book.getCurCount()<=0) {
            throw new BorrowedOutException();
        }
        if(recordShelf.contains(user,ISBN)){
            //有过借书记录的不能再借
            throw new YetBorrowedException();
        }
        book.borrowBook();
        recordShelf.putRecord(user,ISBN);
        return book;
    }
}
