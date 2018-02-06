/*
 * 
 */
package com.mycompany.dto;

import com.mycompany.util.Constants;
import static com.mycompany.util.Util.createBigDecimal;
import java.math.BigDecimal;
import java.math.MathContext;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author cristian.giardina
 */
public class TaxedGoodTest extends TestCase {
    
    public TaxedGoodTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    //imported bottle of perfume: 47.50 -> 54.65
    @Test
    public void testDoubleTax(){
        
        Good good = new FreeTaxGood("imported bottle of perfume", createBigDecimal(47.50));
        
        //basic sales tax
        good = new TaxedGood(good, Constants.BASIC_SALES_TAX);
        
        assertEquals(createBigDecimal(4.75).setScale(2),good.getTax().setScale(2));
        assertEquals(createBigDecimal(52.25).setScale(2),good.getPrice().setScale(2));
        
        //import duty
        good = new TaxedGood(good, Constants.IMPORT_DUTY_TAX);
        assertEquals(createBigDecimal(2.40).setScale(2),good.getTax().setScale(2));
        assertEquals(createBigDecimal(54.65).setScale(2),good.getPrice().setScale(2));
        
        
        
        
    }
    
    
    //box of imported chocolates: 11.25 -> 11.85
    @Test
    @Ignore
    public void testImportedFood(){
        
        
        Good good = new FreeTaxGood("box of imported chocolates", createBigDecimal(11.25));
        
        //import duty
        good = new TaxedGood(good, Constants.IMPORT_DUTY_TAX);
        assertEquals(createBigDecimal(0.55).setScale(2),good.getTax().setScale(2));//this should be 0.55 ( 11.25 * 5% = 0,5625 -> 0.55 as nearest 0.05)
        assertEquals(createBigDecimal(11.85).setScale(2),good.getPrice().setScale(2));
        
    }
    
    
    
}
