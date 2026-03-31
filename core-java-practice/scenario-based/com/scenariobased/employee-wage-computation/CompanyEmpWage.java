import java.util.ArrayList;
import java.util.List;

public class CompanyEmpWage{
    public String company;
    public int wagePerHour;
    public int numOfWorkingDays;
    public int maxHoursPerMonth;
    public int totalEmpWage;
    public List<Integer> dailyWages;

    public CompanyEmpWage(String company,int wagePerHour,int numOfWorkingDays,int maxHoursPerMonth){
        this.company=company;
        this.wagePerHour=wagePerHour;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHoursPerMonth=maxHoursPerMonth;
        this.dailyWages=new ArrayList<>();
    }

    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage=totalEmpWage;
    }
}