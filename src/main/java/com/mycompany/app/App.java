package com.mycompany.app;

import com.mycompany.dto.Good;
import com.mycompany.util.Util;
import java.util.Collection;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
//        Good book = new FreeTaxGood("book", new BigDecimal(12.49));
//        Good musicCd = new TaxedGood(new FreeTaxGood("music CD", new BigDecimal(14.99)), BigDecimal.TEN);
//        Good chocolate = new FreeTaxGood("chocolate bar", new BigDecimal(0.85));
//        Collection<Good> goods=new ArrayList<>();
//        goods.add(book);
//        goods.add(musicCd);
//        goods.add(chocolate);
//        
//        new Bill(goods).print();
        Collection<Good> goods1 = Util.readGoods(App.class.getResourceAsStream("/purchases-1.txt"));
        
        new Bill(goods1).print();
        System.out.println("***********************************");
        Collection<Good> goods2 = Util.readGoods(App.class.getResourceAsStream("/purchases-2.txt"));
        
        new Bill(goods2).print();
        System.out.println("***********************************");
        Collection<Good> goods3 = Util.readGoods(App.class.getResourceAsStream("/purchases-3.txt"));
        
        new Bill(goods3).print();
        
        
        
        
        
    }
}
