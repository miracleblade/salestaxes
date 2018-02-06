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

    private BigDecimal totalFreeTaxes = BigDecimal.ZERO;
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
            totalFreeTaxes = totalFreeTaxes.add(g.getFreeTaxPrice());
            System.out.printf("%s: %.2f   \n" , g.getDescription(),g.getPrice());
            
            });
        System.out.printf("\t Sales taxes: %.2f\n" ,total.subtract(totalFreeTaxes));
        System.out.printf("\t Total: %.2f\n" , total);
        
        
        
    }
    
    

    
}
