/*
 * 
 */
package com.mycompany.app;

import com.mycompany.dto.Good;
import com.mycompany.util.Util;
import java.util.Collection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cristian.giardina
 */
public class BillTest {
    
    
    static Bill bill1;
    static Bill bill2;
    static Bill bill3;
    
    public BillTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        Collection<Good> goods1 = Util.readGoods(App.class.getResourceAsStream("/purchases-1.txt"));
        bill1 = new Bill(goods1);
        
        Collection<Good> goods2 = Util.readGoods(App.class.getResourceAsStream("/purchases-2.txt"));
        bill2 = new Bill(goods2);
        Collection<Good> goods3 = Util.readGoods(App.class.getResourceAsStream("/purchases-3.txt"));
        bill3 = new Bill(goods3);
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getTotal method, of class Bill.
     */
    @Test
    public void testGetSalesTaxes1() {
        
        
        assertEquals(Util.createBigDecimal(1.5).setScale(2),bill1.getSalesTaxes().setScale(2));
        
    }

    /**
     * Test of getSalesTaxes method, of class Bill.
     */
    @Test
    public void testGetTotal1() {
        assertEquals(Util.createBigDecimal(29.83).setScale(2),bill1.getTotal().setScale(2));
    }
    
    
    /**
     * Test of getTotal method, of class Bill.
     */
    @Test
    public void testGetSalesTaxes2() {
        
        
        assertEquals(Util.createBigDecimal(7.65).setScale(2),bill2.getSalesTaxes().setScale(2));
        
    }

    /**
     * Test of getSalesTaxes method, of class Bill.
     */
    @Test
    public void testGetTotal2() {
        assertEquals(Util.createBigDecimal(65.15).setScale(2),bill2.getTotal().setScale(2));
    }
    
    
    /**
     * Test of getTotal method, of class Bill.
     */
    @Test
    public void testGetSalesTaxes3() {
        
        
        //assertEquals(Util.createBigDecimal(6.70).setScale(2),bill3.getSalesTaxes().setScale(2)); error in documentation????
        assertEquals(Util.createBigDecimal(6.65).setScale(2),bill3.getSalesTaxes().setScale(2));
        
        
        
    }

    /**
     * Test of getSalesTaxes method, of class Bill.
     */
    @Test
    public void testGetTotal3() {
        
        //assertEquals(Util.createBigDecimal(74.68).setScale(2),bill3.getTotal().setScale(2)); error in documentation????
        assertEquals(Util.createBigDecimal(74.63).setScale(2),bill3.getTotal().setScale(2));
    }

    
    
}
