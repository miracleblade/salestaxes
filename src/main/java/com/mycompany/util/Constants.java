/*
 * 
 */
package com.mycompany.util;

import java.math.BigDecimal;

/**
 *
 * @author cristian.giardina
 */
public interface Constants {
    
    public static String [] FREE_TAXES_CATEGORIES = {"food","medicine","book"};
    public static BigDecimal BASIC_SALES_TAX = BigDecimal.TEN;
    public static BigDecimal IMPORT_DUTY_TAX = Util.createBigDecimal(5);
    
}
