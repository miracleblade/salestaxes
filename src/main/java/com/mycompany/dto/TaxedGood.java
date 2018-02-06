/*
 * 
 */
package com.mycompany.dto;

import com.mycompany.util.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.mycompany.util.Util.roundNearest05;

/**
 *
 * @author cristian.giardina
 */
public class TaxedGood implements Good{

    private Good good;
    private BigDecimal taxRate;
    
    public TaxedGood(Good good,BigDecimal taxRate) {
        this.good = good;
        this.taxRate = taxRate;
    }

    
    
    @Override
    public BigDecimal getTax() {
        
        BigDecimal tax = applyTax();
        tax = roundNearest05(tax);
        return tax;
    }

    private BigDecimal applyTax() {
        BigDecimal tax = good.getFreeTaxPrice().multiply(taxRate).divide(Util.createBigDecimal(100));
        return tax;
    }

    @Override
    public BigDecimal getPrice() {
        return good.getPrice().add(getTax());
    }

    @Override
    public String getDescription() {
        return good.getDescription();
    }

    @Override
    public BigDecimal getFreeTaxPrice() {
        return good.getFreeTaxPrice();
    }
    
}
