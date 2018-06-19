/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import calibration.SetUp;
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
    
    /**
     * Тест на быстроту работы калибровочной части.
     */
    @Test
    public void timeTest() throws Exception {
        double begin = System.nanoTime(); //начало исполнения
        SetUp.calibrate();
        double end = System.nanoTime();
        assertTrue((end-begin)/1000000000.<15);
    }
    
}
