package libiary;

/**
 * @author ZhaoMin
 * @date 2019/10/10 17:20
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //给用户输出提示
        //生成用户对象
        //id/name/身份
        while(true) {
            User curUser = User.login();
            boolean isQuit;//退出
            do {
                curUser.menu();//展示菜单
                isQuit = curUser.input();//做出选择
            } while (!isQuit);
           // System.out.println("欢迎下次光临！！");
        }

    }
}
