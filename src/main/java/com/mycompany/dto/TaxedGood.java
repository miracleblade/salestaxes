/*
 * 
 */
package com.mycompany.dto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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

    
    
    public BigDecimal getTax() {
        
        BigDecimal tax = applyTax();
        tax = roundNearest05(tax);
        return tax;
    }

    private BigDecimal applyTax() {
        BigDecimal tax = good.getPrice().multiply(taxRate).divide(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        return tax;
    }

    private BigDecimal roundNearest05(BigDecimal tax) {
        tax = tax.multiply(BigDecimal.valueOf(20)).divide(BigDecimal.valueOf(20)).setScale(2,RoundingMode.HALF_UP);
        return tax;
    }

    public BigDecimal getPrice() {
        return good.getPrice().add(getTax());
    }

    public String getDescription() {
        return good.getDescription();
    }
    
}
