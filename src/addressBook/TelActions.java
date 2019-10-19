package addressBook;

import addressBook.exceptions.ImperfactException;
import addressBook.exceptions.NoMessageException;

import java.util.*;

/**
 * @author ZhaoMin
 * @date 2019/10/19 9:51
 */
public class TelActions {
    /**
     * 添加通讯信息
     * @param name
     * @param tel
     * @param note
     */
    public String put(String name,String tel,String note){
        AddressBook addressBook= AddressBook.getInstance();
        //Map<String ,List<TelMessage>> map=new TreeMap<>();
        TelMessage message=new TelMessage(tel,note);
       List<TelMessage> list=new ArrayList<>();
       list.add(message);
        addressBook.map.put(name,list);
        return name;
    }

    /**
     * 根据姓名查找
     * @param name
     * @return
     */
    public List<TelMessage> select(String name) throws NoMessageException, ImperfactException {
        AddressBook addressBook = AddressBook.getInstance();
        if(addressBook.map.containsKey(name)) {
            List<TelMessage> messages = addressBook.map.get(name);
            Iterator<TelMessage> it=messages.iterator();
            while(it.hasNext()){
                TelMessage obj=it.next();
                String telNum=obj.getTelNum();
                String note=obj.getNote();
                System.out.println("电话："+telNum+" "+"备注："+note);
            }
            if(messages==null){
                throw new ImperfactException();//信息不完善
            }
            return messages;
        }
            throw new NoMessageException();//没有这个人的名字
    }
    /**
     * 删除通讯信息
     */
    public String delete(String name) throws NoMessageException {
            AddressBook addressBook=AddressBook.getInstance();
            if(addressBook.map.containsKey(name)) {
                addressBook.map.remove(name);
            }else{
                throw new NoMessageException();
            }
            return name;
    }
    /**
     * 查询全部用户
     */
    public void selectAll() throws ImperfactException, NoMessageException {
        AddressBook addressBook= AddressBook.getInstance();
        Set entrySet=addressBook.map.entrySet();
        Iterator it=entrySet.iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)(it.next());
            String key=(String)entry.getKey();
            System.out.print("姓名："+key+" ");
            select(key);
        }
    }

    public void update(String name) throws NoMessageException, ImperfactException {
        AddressBook addressBook=AddressBook.getInstance();
        System.out.println("请选择修改信息：");
        System.out.println("1.修改姓名");
        System.out.println("2.修改电话/备注");
        List<TelMessage> messages=select(name);
        Scanner scanner=new Scanner(System.in);
        int select=scanner.nextInt();
        scanner.nextLine();
        switch (select){
            case 1:
                addressBook.map.remove(name);
                System.out.println("请输入姓名：");
                String reName=scanner.nextLine();
                addressBook.map.put(reName,messages);
                System.out.println("已成功将"+name+"修改为"+reName+"🍉");
                break;
            case 2:
                System.out.println("🎈请输入电话:");
                String telNum=scanner.nextLine();
                System.out.println("🎈请输入备注：");
                String note=scanner.nextLine();
                TelMessage telMessage=new TelMessage(telNum,note);
                List<TelMessage> newMessage=new ArrayList<>();
                newMessage.add(telMessage);
                addressBook.map.replace(name,messages,newMessage);
                System.out.println("👌电话和备注信息已经修改");
        }
    }
}
