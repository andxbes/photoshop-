/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.andxbes.filters;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Andr
 */
public class OilEffectIT {
    
    public OilEffectIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getModifiedImage method, of class OilEffect.
     */
    @Test
    public void testMidleElement() {
	OilEffect of= new OilEffect();
	int[] array = new int[]{1,5,3,8,3,6};
	
	//5|3
	
	int a = of.getMidleValue(array);

	System.out.println(a);
            Assert.assertTrue((a == 5 || a == 3 ));
	
	
    }
    
}
