package libiary;

import action.Action;

import java.util.List;
import java.util.Scanner;

/**
 * @author ZhaoMin
 * @date 2019/10/10 17:10
 */
public abstract class User {
    private String id ;//学号
    private String name;//姓名
    private String role;//身份
    public User(String id,String name){
        this.id=id;
        this.name=name;
    }
    //单例模式：将使用者信息保存起来,
    // 并通过public的getcurUSer()获取当前USer信息
      private static User curUser=null;
    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        String id=scanner.nextLine();
        System.out.println("请输入名字：");
        String name=scanner.nextLine();
        System.out.println("请输入身份：");
        String role=scanner.nextLine();
        if(role.equals("学生")){
            curUser=new Student(id,name);
        }else if(role.equals("老师")){
            curUser=new Teacher(id,name);
        }else{
            throw new Exception("错误的身份");
        }
        return curUser;
    }
    public static User getCurUser(){
        return curUser;
    }
    public abstract void menu();
    public abstract boolean input();
    //查书
    public void queryBooks(){//查书:查书库中所有书的信息
        List<Book> bookList = Action.queryBooks();
        for(Book book:bookList){
            System.out.printf("《%s》by %s 价格: %.2f 存量: %d 借阅次数: %d%n",
                    book.getTitle(),book.getAuthor(),book.getPrice(),
                    book.getCurCount(),book.getBorrowedCount());
        }
        System.out.println("共查询到"+bookList.size()+"本书");
    }

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
}
