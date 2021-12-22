/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duedatecalculator;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asefn
 */
public class DueDateCalculatorTest {

    public DueDateCalculatorTest() {
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
     * Test of calculateDueDate method, of class DueDateCalculator.
     */
    @Test
    public void testCalculateDueDate() {
        System.out.println("calculateDueDate");
        String submittedDate = "21-12-2021 13:45:57";
        int workingHours = 15;
        String expResult = "23-12-2021 12:45:57";
        String result = DueDateCalculator.calculateDueDate(submittedDate, workingHours);
        assertEquals(expResult, result);

    }

    /**
     * Test of parseStringToDate method, of class DueDateCalculator.
     */
    @Test
    public void testParseStringToDate() {
        System.out.println("parseStringToDate");
        String dateTimeString = "23-12-2021 12:45:57";
        Date expResult = new Date("December 23,2021,12:45:57");
        Date result = DueDateCalculator.parseStringToDate(dateTimeString);
        assertEquals(expResult, result);

    }

    /**
     * Test of addWorkingHours method, of class DueDateCalculator.
     */
    @Test
    public void testAddWorkingHours() {
        System.out.println("addWorkingHours");
        Date fromDate = new Date("December 21,2021,13:45:57");
        int workingHours = 15;
        Date expResult = new Date("December 23,2021,12:45:57");
        Date result = DueDateCalculator.addWorkingHours(fromDate, workingHours);
        assertEquals(expResult, result);

    }

    /**
     * Test of workingDate method, of class DueDateCalculator.
     */
    @Test
    public void testWorkingDate() {
        System.out.println("workingDate");
        Date date = new Date(2021, 12, 21, 13, 45, 57);
        boolean expResult = false;
        boolean result = DueDateCalculator.workingDate(date);
        assertEquals(expResult, result);

    }

    /**
     * Test of convertedDate method, of class DueDateCalculator.
     */
    @Test
    public void testConvertedDate() {
        System.out.println("convertedDate");
        Date date = new Date("December 23,2021,12:45:57");
        String format = "dd-MM-yyyy HH:mm:ss";
        String expResult = "23-12-2021 12:45:57";
        String result = DueDateCalculator.convertedDate(date, format);
        assertEquals(expResult, result);
        
    }

}
