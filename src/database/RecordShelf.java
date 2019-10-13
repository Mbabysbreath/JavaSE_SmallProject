package database;

import com.sun.prism.impl.Disposer;
import libiary.Record;
import libiary.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhaoMin
 * @date 2019/10/10 21:07
 */
public class RecordShelf {
    private List<Record> recordList=new ArrayList<>();
    private static RecordShelf instance=new RecordShelf();
    public static RecordShelf getInstance(){
        return instance;
    }

    public boolean contains(User user, String ISBN) {
        for(Record record:recordList){
            if(record.is(user,ISBN)){
                return true;
            }
        }
        return false;
    }

    public void putRecord(User user, String ISBN) {
        Record record=new Record(user.getId(),ISBN);
        recordList.add(record);
    }

}
