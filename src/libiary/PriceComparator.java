package libiary;

import java.util.Comparator;

/**
 * @author ZhaoMin
 * @date 2019/10/20 21:56
 */
public class PriceComparator implements Comparator<Book> {
    private boolean asc;//从小到大
    public PriceComparator(boolean asc){
        this.asc=asc;
    }
    @Override
    public int compare(Book o1, Book o2) {
        if(asc){
            return (int)((o1.getPrice()-o2.getPrice())*100);
        }else{
            return (int)((o2.getPrice()-o1.getPrice())*100);
        }
    }
}
