package src;

import java.util.ArrayList;

public class Transcript {

    private ArrayList<Semester> semesters;
    private double gpa = 0.0;

    public void addSemester(Semester semester)
    {
        semesters.add(semester);
    } 

    public Semester getSemester(Term term, int year) throws Exception
    {
        int size = semesters.size();
        for(int i = 0; i < size; i++)
        {
            if(semesters.get(i).getSemesterTerm() == term && semesters.get(i).getYear() == year)
            {
                return semesters.get(i);
            }
        }
        throw new Exception("Semester not found");
    }

    public double getTotalGPA()
    {
        int numOfSemesters = semesters.size();
        for (int i = 0; i < numOfSemesters; i++)
        {
            gpa += semesters.get(i).getSemesterGPA();
        }
        gpa /= numOfSemesters;
        return gpa;
    }

    
    
}
