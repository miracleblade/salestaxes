/*
 * 
 */
package com.mycompany.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        
        assertTrue(Util.createBigDecimal(0.10).compareTo(Util.roundNearest05(new BigDecimal(0.08))) == 0);
        assertTrue(Util.createBigDecimal(0.05).compareTo(Util.roundNearest05(new BigDecimal(0.04))) == 0);
        assertTrue(Util.createBigDecimal(1).compareTo(Util.roundNearest05(new BigDecimal(1))) == 0);
        assertTrue(Util.createBigDecimal(1.1).compareTo(Util.roundNearest05(new BigDecimal(1.08))) == 0);
        
        
    }
    
}
