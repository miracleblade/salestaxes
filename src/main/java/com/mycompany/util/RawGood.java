/*
 * 
 */
package com.mycompany.util;

import java.math.BigDecimal;

/**
 *
 * @author cristian.giardina
 */
public class RawGood {
    
    
    private String description;
    private BigDecimal price;
    private String category;
    private boolean imported;

    public RawGood() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }
    
    
    
}
