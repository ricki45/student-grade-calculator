package com.vut.calculator;

public class GradeCalculator {
    
    /**
     * Calculates the final mark based on semester and exam marks.
     * Formula: (Semester Mark × 0.4) + (Exam Mark × 0.6)
     * 
     * @param semesterMark The semester mark (0-100)
     * @param examMark The exam mark (0-100)
     * @return The calculated final mark
     */
    public static double calculateFinalMark(double semesterMark, double examMark) {
        // Validate input ranges
        if (!isValidMark(semesterMark) || !isValidMark(examMark)) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        
        // CORRECTED: 40% semester, 60% exam (not swapped)
        return (semesterMark * 0.4) + (examMark * 0.6);
    }
    
    /**
     * Checks if a student is admitted to write the exam.
     * Rule: Semester Mark must be ≥ 40
     * 
     * @param semesterMark The semester mark (0-100)
     * @return true if admitted, false otherwise
     */
    public static boolean isAdmittedToExam(double semesterMark) {
        if (!isValidMark(semesterMark)) {
            throw new IllegalArgumentException("Semester mark must be between 0 and 100");
        }
        
        // CORRECTED: Changed from 30 to 40
        return semesterMark >= 40;
    }
    
    /**
     * Determines the grade based on final mark.
     * Rules:
     * - Distinction: 80-100
     * - Merit: 70-79
     * - Credit: 60-69
     * - Pass: 50-59
     * - Supplementary: 45-49
     * - Fail: 0-44
     * 
     * @param finalMark The final mark (0-100)
     * @return The grade as a String
     */
    public static String getGrade(double finalMark) {
        if (!isValidMark(finalMark)) {
            throw new IllegalArgumentException("Final mark must be between 0 and 100");
        }
        
        // CORRECTED: Distinction starts at 80 (not 75)
        if (finalMark >= 80 && finalMark <= 100) {
            return "Distinction";
        } else if (finalMark >= 70 && finalMark <= 79) {
            return "Merit";
        } else if (finalMark >= 60 && finalMark <= 69) {
            return "Credit";
        } else if (finalMark >= 50 && finalMark <= 59) {
            return "Pass";
        } else if (finalMark >= 45 && finalMark <= 49) {
            return "Supplementary";
        } else {
            return "Fail";
        }
    }
    
    /**
     * Validates that a mark is between 0 and 100 inclusive.
     * 
     * @param mark The mark to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }
}
