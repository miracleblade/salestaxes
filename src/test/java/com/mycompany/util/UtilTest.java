/*
 * 
 */
package com.mycompany.util;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cristian.giardina
 */
public class UtilTest {
    
    public UtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    
    /**
     * Test of roundNearest05 method, of class Util.
     */
    @Test
    public void testRoundNearest05() {
        
        assertEquals(Util.createBigDecimal(0.1),Util.roundNearest05(new BigDecimal(0.08)));
        
        assertEquals(Util.createBigDecimal(0.05),Util.roundNearest05(new BigDecimal(0.04)));
        
        assertEquals(Util.createBigDecimal(1),Util.roundNearest05(new BigDecimal(1)));
        
        assertEquals(Util.createBigDecimal(1.1),Util.roundNearest05(new BigDecimal(1.08)));
        
        
    }
    
}
