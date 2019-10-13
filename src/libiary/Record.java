package libiary;

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
}
