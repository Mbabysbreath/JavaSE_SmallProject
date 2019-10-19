package addressBook;

/**
 * @author ZhaoMin
 * @date 2019/10/19 9:53
 */
public class TelMessage {
    private String telNum;
    private String note;
    public TelMessage(String telNum,String note){
        this.telNum=telNum;
        this.note=note;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getNote() {
        return note;
    }
}
