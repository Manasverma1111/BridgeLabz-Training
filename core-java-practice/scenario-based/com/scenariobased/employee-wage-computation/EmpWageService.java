public class EmpWageService{

    private EmpWageDAO dao;

    public EmpWageService(EmpWageDAO dao){
        this.dao=dao;
    }

    public void computeEmpWage(){
        for(CompanyEmpWage company:dao.getCompanies()){
            int totalHours=0;
            int totalDays=0;

            while(totalHours<=company.maxHoursPerMonth&&totalDays<company.numOfWorkingDays){
                totalDays++;
                int empCheck=(int)Math.floor(Math.random()*3);
                int empHours=0;

                switch(empCheck){
                    case 1:
                        empHours=4;
                        break;
                    case 2:
                        empHours=8;
                        break;
                    default:
                        empHours=0;
                }

                totalHours+=empHours;
                int dailyWage=empHours*company.wagePerHour;
                company.dailyWages.add(dailyWage);
            }
            company.setTotalEmpWage(totalHours*company.wagePerHour);
        }
    }

    public int getTotalWage(String company){
        return dao.getCompany(company).totalEmpWage;
    }
}