package libiary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhaoMin
 * @date 2019/10/10 21:10
 */
public class Record {
    private String userId;
    private String bookISBN;
    private Date borrowedAt;
    public Record(String id,String ISBN){
        this.userId=id;
        this.bookISBN=ISBN;
        this.borrowedAt=new Date();//当前时间
    }

    public boolean is(User user, String ISBN) {
        return userId.equals(user.getId())&&
                bookISBN.equals(ISBN);
    }

    public String getUserId() {
        return userId;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public String getBorrowedAt() {
        SimpleDateFormat date=new SimpleDateFormat("YYYY-MM--dd HH:mm:ss");
        Date time=new Date();
        String s=date.format(time);
        return s;
    }
}
