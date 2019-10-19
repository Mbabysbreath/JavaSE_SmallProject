package addressBook;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ZhaoMin
 * @date 2019/10/19 10:33
 */
public class AddressBook {
    public  Map<String,List<TelMessage>> map=new TreeMap<>();
    private static AddressBook instance=new AddressBook();
    public static AddressBook getInstance(){
        return instance;
    }
}
