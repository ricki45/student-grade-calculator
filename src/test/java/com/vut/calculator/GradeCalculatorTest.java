package com.vut.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class GradeCalculatorTest {
    
    // ========== calculateFinalMark Tests ==========
    
    @Test
    public void shouldCalculateFinalMark() {
        double result = GradeCalculator.calculateFinalMark(90, 85);
        assertEquals(87.0, result, 0.01);
    }
    
    @Test
    public void shouldCalculateFinalMarkWithZero() {
        double result = GradeCalculator.calculateFinalMark(0, 0);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    public void shouldCalculateFinalMarkWithFullMarks() {
        double result = GradeCalculator.calculateFinalMark(100, 100);
        assertEquals(100.0, result, 0.01);
    }
    
    @Test
    public void shouldCalculateFinalMarkWithMixedValues() {
        double result = GradeCalculator.calculateFinalMark(50, 50);
        assertEquals(50.0, result, 0.01);
    }
    
    // ========== isAdmittedToExam Tests ==========
    
    @Test
    public void shouldAdmitStudentWithSemesterMark40() {
        assertTrue(GradeCalculator.isAdmittedToExam(40));
    }
    
    @Test
    public void shouldAdmitStudentWithHighSemesterMark() {
        assertTrue(GradeCalculator.isAdmittedToExam(85));
    }
    
    @Test
    public void shouldNotAdmitStudentWithSemesterMark39() {
        assertFalse(GradeCalculator.isAdmittedToExam(39));
    }
    
    @Test
    public void shouldNotAdmitStudentWithLowSemesterMark() {
        assertFalse(GradeCalculator.isAdmittedToExam(20));
    }
    
    // ========== getGrade Tests ==========
    
    @Test
    public void shouldReturnDistinction() {
        assertEquals("Distinction", GradeCalculator.getGrade(95));
        assertEquals("Distinction", GradeCalculator.getGrade(80));
    }
    
    @Test
    public void shouldReturnMerit() {
        assertEquals("Merit", GradeCalculator.getGrade(75));
        assertEquals("Merit", GradeCalculator.getGrade(70));
    }
    
    @Test
    public void shouldReturnCredit() {
        assertEquals("Credit", GradeCalculator.getGrade(65));
        assertEquals("Credit", GradeCalculator.getGrade(60));
    }
    
    @Test
    public void shouldReturnPass() {
        assertEquals("Pass", GradeCalculator.getGrade(55));
        assertEquals("Pass", GradeCalculator.getGrade(50));
    }
    
    @Test
    public void shouldReturnSupplementary() {
        assertEquals("Supplementary", GradeCalculator.getGrade(47));
        assertEquals("Supplementary", GradeCalculator.getGrade(45));
        assertEquals("Supplementary", GradeCalculator.getGrade(49));
    }
    
    @Test
    public void shouldReturnFail() {
        assertEquals("Fail", GradeCalculator.getGrade(30));
        assertEquals("Fail", GradeCalculator.getGrade(44));
        assertEquals("Fail", GradeCalculator.getGrade(0));
    }
    
    @Test
    public void shouldReturnFailForMarkBelow45() {
        assertEquals("Fail", GradeCalculator.getGrade(44));
        assertEquals("Fail", GradeCalculator.getGrade(40));
    }
    
    // ========== isValidMark Tests ==========
    
    @Test
    public void shouldValidateCorrectMarks() {
        assertTrue(GradeCalculator.isValidMark(50));
        assertTrue(GradeCalculator.isValidMark(0));
        assertTrue(GradeCalculator.isValidMark(100));
    }
    
    @Test
    public void shouldInvalidateIncorrectMarks() {
        assertFalse(GradeCalculator.isValidMark(-1));
        assertFalse(GradeCalculator.isValidMark(101));
    }
    
    // ========== Edge Cases ==========
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidSemesterMark() {
        GradeCalculator.calculateFinalMark(-10, 50);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidExamMark() {
        GradeCalculator.calculateFinalMark(50, 150);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForInvalidFinalMarkInGetGrade() {
        GradeCalculator.getGrade(200);
    }
}
