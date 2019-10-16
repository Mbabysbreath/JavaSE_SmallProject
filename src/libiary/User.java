package libiary;

import action.Action;
import database.Where;

import java.util.ArrayList;
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

    private static class Current implements Where<Book>{
        @Override
        public boolean test(Book book) {
            //查询存量大于0的书
            return book.getCurCount()>0;
        }
    }

    private static class BookTitle implements Where<Book>{
        private  String title;;
        BookTitle(String title){
            this.title=title;
        }
        @Override
        public boolean test(Book book) {
            return book.getTitle().equals(title);
        }
    }
    //查书
    protected void queryBooks(){//查书:查书库中所有书的信息
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择全查询还是条件查询：");
        System.out.println("1.全查询");
        System.out.println("2.查询存量大于0的");
        System.out.println("其他：根据书名查询");
        int selected=scanner.nextInt();
        scanner.nextLine();
        List<Book> bookList;
        switch (selected) {
            case 1:
                bookList = Action.queryBooks();
                break;
            case 2:
                bookList = Action.queryBooksByWhere(new Current());
                break;
            default:
                System.out.println("请输入书名：");
                String title = scanner.nextLine();
                bookList = Action.queryBooksByWhere(new BookTitle(title));
                break;
        }
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
    protected void queryRecords(){
        List<Record> recordList=Action.queryRecords();
        for(Record record:recordList){
            System.out.printf("%s,%s,%s",
                    record.getUserId(),
                    record.getBookISBN(),
                    record.getBorrowedAt());
        }
        System.out.println("共查询到"+recordList.size()+"条借阅记录");
    }
}
