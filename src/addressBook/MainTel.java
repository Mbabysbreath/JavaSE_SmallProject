package addressBook;

import addressBook.exceptions.ImperfactException;
import addressBook.exceptions.NoMessageException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**通讯录小项目：实现增/删/查/改
 * @author ZhaoMin
 * @date 2019/10/19 9:56
 */
public class MainTel {
    public static void main(String[] args) {
        TelActions ob=new TelActions();
        Scanner scanner=new Scanner(System.in);

        while(true) {
            System.out.println("🥨🥨🥨🥨欢迎使用通讯录🥨🥨🥨🥨：");
            System.out.println("0.退出");
            System.out.println("1.添加通讯信息：");
            System.out.println("2.通过姓名查询电话/备注：");
            System.out.println("3.查询通讯录全部人员信息：");
            System.out.println("4.删除通讯录信息：");
            System.out.println("5.更新通讯录信息：");
            int selected=scanner.nextInt();
            scanner.nextLine();
            switch (selected) {
                case 0:break;
                case 1:
                    System.out.println("请添加通讯信息：");
                    System.out.println("👨‍👧请输入姓名👨‍👧：");
                    String name = scanner.nextLine();
                    System.out.println("👀请输入电话号码（选填）：");
                   String telNum = scanner.nextLine();
                    System.out.println("👁请添加备注（选填）");
                    String note = scanner.nextLine();
                    ob.put(name, telNum, note);
                    System.out.printf("%s添加成功🥗%n",name);
                    break;
                case 2:
                    System.out.println("🌜请输入要查询的姓名🌶：");
                    String name1 = scanner.nextLine();
                    try {
                       ob.select(name1);
                    } catch (NoMessageException e) {
                        System.out.println("☠查无此人！");
                    } catch (ImperfactException e) {
                        System.out.println("☠信息不完善！");
                    }
                    break;
                case 3:
                    try {
                        ob.selectAll();
                    }catch (ImperfactException e) {
                        System.out.println("☠信息不完善");
                    } catch (NoMessageException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("🌜请输入要删除的名字：🌜");
                    String name2=scanner.nextLine();
                    try {
                        System.out.println(ob.delete(name2)+"成功删除");
                    } catch (NoMessageException e) {
                        System.out.println("😱没有找到要删除的人员");
                    }
                    break;
                case 5:
                    System.out.println("🌜请输入要更改的姓名信息：");
                    String name3=scanner.nextLine();
                    try {
                        ob.update(name3);
                    } catch (NoMessageException e) {
                        System.out.println("☠查无此人");
                    } catch (ImperfactException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
