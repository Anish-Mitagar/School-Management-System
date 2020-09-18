package src;

public class Subject 
{

    private final String className;
    private final ClassType classType;
    private double finalGrade;
    private Catagory[] catagories;
    private int totalWeight;
    private LetterGrade letterGrade;
    

    public Subject(String name, ClassType classType, Catagory[] catagories) throws IllegalArgumentException{
        className = name;
        this.classType = classType;
        
        for (int i = 0; i < catagories.length; i++) {
            totalWeight += catagories[i].getWeight();
        }

        if (totalWeight != 1.0)
        {
            throw new IllegalArgumentException("Total weightage has to be 1.0");
        }
        else
        {
            this.catagories = catagories;
        }

    }

    public double getFinalGrade()
    {
        for (int i = 0; i < catagories.length; i++)
        {
            finalGrade += (catagories[i].getCategoryAverage()*catagories[i].getWeight());
        }

        return finalGrade;
    }

    public String getClassName()
    {
        return className;
    }

    public ClassType getClassType()
    {
        return classType;
    }

    private void setLetterGrade()
    {
        getFinalGrade();
        if (finalGrade > 93.0)
        {
            letterGrade = LetterGrade.A;
        }
        else if (finalGrade > 90.0)
        {
            letterGrade = LetterGrade.A_MINUS;
        }
        else if (finalGrade > 87.0)
        {
            letterGrade = LetterGrade.B_PLUS;
        }
        else if (finalGrade > 83.0)
        {
            letterGrade = LetterGrade.B;
        }
        else if (finalGrade > 80.0)
        {
            letterGrade = LetterGrade.B_MINUS;
        }
        else if (finalGrade > 77.0)
        {
            letterGrade = LetterGrade.C_PLUS;
        }
        else if (finalGrade > 73.0)
        {
            letterGrade = LetterGrade.C;
        }
        else if (finalGrade > 70.0)
        {
            letterGrade = LetterGrade.C_MINUS;
        }
        else if (finalGrade > 67.0)
        {
            letterGrade = LetterGrade.D_PLUS;
        }
        else if (finalGrade > 63.0)
        {
            letterGrade = LetterGrade.D;
        }
        else if (finalGrade > 60.0)
        {
            letterGrade = LetterGrade.D_MINUS;
        }
        else
        {
            letterGrade = LetterGrade.F;
        }
    }

    public LetterGrade getLetterGrade()
    {
        setLetterGrade();
        return letterGrade;
    }

    public int getNumOfIncompletedAssignments()
    {
        int numOfIncompletedAssignments = 0;
        for (int i = 0; i < catagories.length; i++)
        {
            numOfIncompletedAssignments += catagories[i].getNumOfIncompletedAssignments();
        }
        return numOfIncompletedAssignments;
    }
}