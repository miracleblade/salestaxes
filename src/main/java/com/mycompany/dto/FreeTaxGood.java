/*
 * 
 */
package com.mycompany.dto;

import java.math.BigDecimal;

/**
 * Represent generic good
 * @author cristian.giardina
 */
public class FreeTaxGood implements Good{

    private String description;
    private BigDecimal price;

    public FreeTaxGood() {
    }

    public FreeTaxGood(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getTax() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getFreeTaxPrice() {
        return price;
    }
    
    
    
}
