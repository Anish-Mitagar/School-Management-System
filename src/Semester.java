package src;

import java.util.ArrayList;

public class Semester {

    private ArrayList<Subject> subjects;
    private double gpa = 0.0;
    private Term term;
    private int year;

    public Semester (Term term, int year)
    {
        this.term = term;
        this.year = year;
    }

    public void addClass(Subject subject)
    {
        subjects.add(subject);
    }

    public double getSemesterGPA()
    {
        int numOfSubjects = subjects.size();
        for (int i = 0; i < numOfSubjects; i++)
        {
            gpa += getSubjectPoints(subjects.get(i));
        }
        gpa /= numOfSubjects;
        return gpa;
    }

    public double getSubjectPoints(Subject subject)
    {
        switch(subject.getLetterGrade()){
            case A:
                return 4.0;
            case A_MINUS:
                return 3.7;
            case B_PLUS:
                return 3.3;
            case B:
                return 3.0;
            case B_MINUS:
                return 2.7;
            case C_PLUS:
                return 2.3;
            case C:
                return 2.0;
            case C_MINUS:
                return 1.7;
            case D_PLUS:
                return 1.3;
            case D:
                return 1.0;
            case D_MINUS:
                return 0.7;
            default:
                return 0.0;
        }
    }

    public int getYear()
    {
        return year;
    }

    public Term getSemesterTerm()
    {
        return term;
    }

    public ArrayList<Subject> getSubjects()
    {
        return subjects;
    }

    public int getNumOfIncompletedAssignments()
    {
        int numOfIncompletedAssignments = 0;
        int size = subjects.size();
        for(int i = 0; i < size; i++)
        {
            numOfIncompletedAssignments += subjects.get(i).getNumOfIncompletedAssignments();
        }
        return numOfIncompletedAssignments;
    }
    
}
