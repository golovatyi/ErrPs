/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calibration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author babazoya
 */
public class SetUpTest {
    
    public SetUpTest() {
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
     * Test of calibrate method, of class SetUp.
     */
    @Test
    public void testIfProgramsSpeedIsAppropriate() throws Exception {
        System.out.println("TimeTest");
        long a = System.nanoTime();
        SetUp.calibrate();
        long b = System.nanoTime();
        assertTrue((b-a)<15000000000L);
    }
    
}