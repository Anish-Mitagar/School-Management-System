package src;

import java.util.ArrayList;

public class Catagory {

    private final int weight;
    private double rawPoints;
    private int numOfAssignments = 0;
    private int numOfCompletedAssignments = 0;
    private ArrayList<Assignment> assignments;

    public Catagory(final int weight) throws IllegalArgumentException
    {
        this.weight = weight;
        if (weight > 1.0)
        {
            throw new IllegalArgumentException("Weight cannot be greater than 1");
        }
    }

    public Catagory(final int weight, final ArrayList<Assignment> assignments)
    {
        this.weight = weight;
        this.assignments = assignments;
    }

    public void addAssignment(Assignment assignment)
    {
        assignments.add(assignment);
        
        if (assignment.getPercentGrade() == 0.0 && assignment.noCredit() == false)
        {
            numOfAssignments++;
        }
        else
        {
            numOfAssignments++;
            numOfCompletedAssignments++;
            rawPoints += assignment.getPercentGrade();
        }
    }

    public double getCategoryAverage()
    {
        return rawPoints/(double)numOfCompletedAssignments;
    }

    public int getNumOfIncompletedAssignments()
    {
        return numOfAssignments - numOfCompletedAssignments;
    }

    public int getWeight()
    {
        return weight;
    }
}
