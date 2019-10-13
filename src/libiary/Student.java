package libiary;

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
        System.out.println("1.查阅图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int select=scanner.nextInt();
        switch(select){
            case 0:return true;
            case 1:
                System.out.println("查阅中");
                break;
            case 2:
                System.out.println("正在借阅");
                break;
            case 3:
                System.out.println("已归还");
                break;
        }
        return false;
    }
}
