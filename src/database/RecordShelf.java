package database;

import com.sun.prism.impl.Disposer;
import exception.NotBorrowedException;
import libiary.Record;
import libiary.User;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void remove(User user, String ISBN)throws NotBorrowedException {
    /*    RecordShelf recordShelf=RecordShelf.getInstance();
        if(!recordShelf.contains(user,ISBN)){
            throw new NotBorrowedException("借阅记录不存在");
        }*/
/*如果一个类实现了Iterable接口，那么就可以使用foreach()实现*/
        Iterator<Record> it=recordList.iterator();
        if(it.hasNext()){
            Record record= it.next();
            if(record.is(user,ISBN)){
                it.remove();
                return ;
            }
        }
        throw new NotBorrowedException();
    }

    public List<Record> queryRecords(Where<Record> where){
        List<Record> ret=new ArrayList<>();
        for(Record record:recordList){
            if(where.test(record)){
                ret.add(record);
            }
        }
        return ret;
    }
}
