/*
 * 
 */
package com.mycompany.app;

import com.mycompany.dto.Good;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.function.BinaryOperator;

/**
 *
 * @author cristian.giardina
 */
public class Bill {

    private Collection<Good> goods;

    private BigDecimal totalTaxes = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    
    
    public Bill(Collection<Good> goods) {
        this.goods = goods;
//        final BinaryOperator<BigDecimal> summer = (t, u) ->  t=t.add(u);
        
        
//        goods.stream().map(g -> g.getPrice()).reduce(total, summer);
//        goods.stream().map(g -> g.getTax()).reduce(totalTaxes, summer);
    }
    
    public void print(){
        
        goods.forEach(g ->{
            
            total = total.add(g.getPrice());
            totalTaxes = totalTaxes.add(g.getTax());
            System.out.printf("GOOD %s %f %f\n" , g.getDescription(),g.getPrice(),g.getTax());
            
            });
        System.out.printf("%f\n" , total);
        System.out.printf("%f\n" ,totalTaxes);
        
        
    }
    
    

    
}
