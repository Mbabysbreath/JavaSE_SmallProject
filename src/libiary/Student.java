package libiary;

import action.Action;
import database.BookShelf;
import database.RecordShelf;
import exception.BorrowedOutException;
import exception.NoSuchBookException;
import exception.NotBorrowedException;
import exception.YetBorrowedException;

import java.util.Scanner;

/**
 * @author ZhaoMin
 * @date 2019/10/10 17:11
 */
public class Student extends User {
    public Student(String id,String name){
        super(id,name);
    }
    @Override
    public void menu() {
        System.out.println("***同学，请选择**");
        System.out.println("0.退出");
        System.out.println("1.查询图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int select=scanner.nextInt();
        scanner.nextLine();
        switch(select){
            case 0:return true;
            case 1:
                queryBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnbook();
                break;
        }
        return false;
    }
    //借书成功后返回书名
    //如果曾经借过这本书，不能再借
    //书库里没有，不能再借
    //书被全部借完，不能再借
    private static void borrowBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入借阅书籍的ISBN:");
        String ISBN=scanner.nextLine();
        User user=User.getCurUser();
        //借书时传入读者的信息和ISBN
        try {
            Book book = Action.borrowBook(user, ISBN);
            System.out.printf("《%s》借阅成功！%n",book.getTitle());
            System.out.println();
        }catch(NoSuchBookException e){
            System.out.println("抱歉！没有找到此书的相关信息");
        }catch (BorrowedOutException e){
            System.out.println("此书已被借空");
        }catch(YetBorrowedException e){
            System.out.println("这本书已经借过了，不能重复借书");
        }
    }
    //先输入书本的ISBN
    //判断有没有这本书
    //有没有借阅记录
    private static void returnbook(){
        User user=User.getCurUser();
        System.out.println("请输入书籍的ISBN:");
        Scanner scanner=new Scanner(System.in);
        String ISBN=scanner.nextLine();

        try {
            Book book=Action.returnbook(user,ISBN);
            System.out.printf("《%s》归还成功！",book.getTitle());
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书");
        }catch(NotBorrowedException e){
            System.out.println("错误！这本书没有被你借过！");
        }

    }

}
