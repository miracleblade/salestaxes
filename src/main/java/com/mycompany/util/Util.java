/*
 * 
 */
package com.mycompany.util;

import com.mycompany.dto.FreeTaxGood;
import com.mycompany.dto.Good;
import com.mycompany.dto.TaxedGood;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mycompany.util.Constants.*;
import java.io.InputStream;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author cristian.giardina
 */
public class Util {
    
    
    public static Collection<Good> readGoods(InputStream is ){
    
        Collection<Good> goods = new ArrayList<>();
        try(
            BufferedReader buff = new BufferedReader(new InputStreamReader(is));
            ){
            
            String line = null;
            while( (line = buff.readLine())!=null ){
                if(line.startsWith("#"))continue; //commented line
                String parts[] = line.split(",");
                
                RawGood rg = new RawGood();
                
                rg.setDescription(parts[0]);
                rg.setCategory(parts[2]);
                rg.setPrice(new BigDecimal(parts[1]));
                rg.setImported(Boolean.parseBoolean(parts[3]));
                
                goods.add(convertRawGood(rg));
                
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return goods;
    
    }
    
    
    public static BigDecimal createBigDecimal(double d){
        return new BigDecimal(d,MathContext.DECIMAL64).setScale(6, RoundingMode.HALF_UP);
    }
    
    
    
    public static Good convertRawGood(RawGood rg){
        
        Collection<String> freeTaxesCategories = Arrays.asList(FREE_TAXES_CATEGORIES);
        
        boolean freeTax = freeTaxesCategories.contains(rg.getCategory());
        boolean imported = rg.isImported();
        
        Good good = new FreeTaxGood(rg.getDescription(), rg.getPrice());
        
        if(!freeTax){
            good = new TaxedGood(good, BASIC_SALES_TAX);
        }
        
        if(imported){
            good = new TaxedGood(good, IMPORT_DUTY_TAX);
        }
        
        return good;
        
    }


    public static BigDecimal roundNearest05(BigDecimal tax) {
        tax = createBigDecimal(Math.round(tax.multiply(createBigDecimal(20)).doubleValue()))
            .divide(createBigDecimal(20));
        return tax;
    }    
}
