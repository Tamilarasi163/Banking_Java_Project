package Banking_Project;

public interface Rate 
{
    default double getBaseRate()
    {
        return 2.5;
    }  
}
