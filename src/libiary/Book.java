package libiary;

/**
 * @author ZhaoMin
 * @date 2019/10/10 17:10
 */
public class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    /**
     * 库存数量
     */
    private int curCount;
    /**
     * 总数量
     */
    private int totalCount;
    /**
     * 借阅次数
     */
    private int borrowedCount;
    public Book(String ISBN,String title,String author,double price,int count){
        this.ISBN=ISBN;
        this.title=title;
        this.author=author;
        this.price=price;
        this.curCount=count;
        this.totalCount=count;
        this.borrowedCount=0;
    }
    public boolean is(String ISBN){
        return this.equals(ISBN);
    }
    public void increaseCount(int count){
        curCount+=count;
        totalCount+=count;
    }
    public String getTitle(){
        return title;
    }
}
