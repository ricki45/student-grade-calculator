package com.vut.calculator;

public class GradeCalculator {
    
    /**
     * Calculates the final mark based on semester and exam marks.
     * Formula: (Semester Mark × 0.4) + (Exam Mark × 0.6)
     */
    public static double calculateFinalMark(double semesterMark, double examMark) {
        if (!isValidMark(semesterMark) || !isValidMark(examMark)) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        return (semesterMark * 0.4) + (examMark * 0.6);
    }
    
    /**
     * Checks if a student is admitted to write the exam.
     * Rule: Semester Mark must be ≥ 40
     */
    public static boolean isAdmittedToExam(double semesterMark) {
        if (!isValidMark(semesterMark)) {
            throw new IllegalArgumentException("Semester mark must be between 0 and 100");
        }
        return semesterMark >= 40;
    }
    
    /**
     * ALIAS METHOD for GradeServlet compatibility
     * Same as isAdmittedToExam
     */
    public static boolean hasExamAdmission(double semesterMark) {
        return isAdmittedToExam(semesterMark);
    }
    
    /**
     * Determines the grade based on final mark.
     */
    public static String getGrade(double finalMark) {
        if (!isValidMark(finalMark)) {
            throw new IllegalArgumentException("Final mark must be between 0 and 100");
        }
        
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
     * ALIAS METHOD for GradeServlet compatibility
     * Same as getGrade
     */
    public static String determineGrade(double finalMark) {
        return getGrade(finalMark);
    }
    
    /**
     * Checks if a student qualifies for supplementary exam
     * Rule: Final Mark between 45 and 49 inclusive
     */
    public static boolean qualifiesForSupplementary(double finalMark) {
        if (!isValidMark(finalMark)) {
            throw new IllegalArgumentException("Final mark must be between 0 and 100");
        }
        return finalMark >= 45 && finalMark <= 49;
    }
    
    /**
     * Validates that a mark is between 0 and 100 inclusive.
     */
    public static boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }
}
