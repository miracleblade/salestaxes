/*
 * 
 */
package com.mycompany.dto;

import java.math.BigDecimal;

/**
 *
 * @author cristian.giardina
 */
public interface Good {

    /**
     * Return the price of the object, tax included
     * @return 
     */
    BigDecimal getPrice();
    /**
     * Return the description of the good
     * @return 
     */
    String getDescription();
    /**
     * Return the tax of the object
     * @return 
     */
    BigDecimal getTax();
    
    
}
