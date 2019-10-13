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
    public static User login() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        String id=scanner.nextLine();
        System.out.println("请输入名字：");
        String name=scanner.nextLine();
        System.out.println("请输入身份：");
        String role=scanner.nextLine();
        if(role.equals("学生")){
            return new Student(id,name);
        }else if(role.equals("老师")){
            return new Teacher(id,name);
        }else{
            throw new Exception("错误的身份");
        }
    }
    public abstract void menu();
    public abstract boolean input();
    //查书
    public void queryBooks(){//查书
        List<Book> bookList = Action.queryBooks();
        for(Book book:bookList){
            //借阅
            System.out.printf("《%s》 ");
        }
        System.out.println("共查询到"+bookList.size());
    }
}
