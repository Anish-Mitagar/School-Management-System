package src;

public class Assignment {

    private double percentGrade;
    private final String assignmentName;
    private boolean zeroCredit = false;

    public Assignment(String name)
    {
        assignmentName = name;
    }

    public Assignment(String name, double percentGrade)
    {
        assignmentName = name;
        this.percentGrade = percentGrade;
    }

    public Assignment(String name, boolean zeroCredit)
    {
        assignmentName = name;
        this.zeroCredit = zeroCredit;
    }

    public void setGrade(double percentGrade)
    {
        this.percentGrade = percentGrade;
    }

    public void changeGrade(double percentGrade)
    {
        setGrade(percentGrade);
    }

    public double getPercentGrade()
    {
        return percentGrade;
    }

    public String getAssignmentName()
    {
        return assignmentName;
    }

    public boolean noCredit()
    {
        return zeroCredit;
    }
}
