package com.mycompany.app;

import com.mycompany.dto.FreeTaxGood;
import com.mycompany.dto.Good;
import com.mycompany.dto.TaxedGood;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Good book = new FreeTaxGood("book", new BigDecimal(12.49));
        Good musicCd = new TaxedGood(new FreeTaxGood("music CD", new BigDecimal(14.99)), BigDecimal.TEN);
        Good chocolate = new FreeTaxGood("chocolate bar", new BigDecimal(0.85));
        Collection<Good> goods=new ArrayList<>();
        goods.add(book);
        goods.add(musicCd);
        goods.add(chocolate);
        
        new Bill(goods).print();
        
        
        
    }
}
