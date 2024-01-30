public class FullTimeEmployee extends Employee  {
    private double baseSalary;

    public FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, int id, double baseSalary, int performanceRating) {
        super(name, id, baseSalary, performanceRating);
        this.baseSalary = 50000.0;
        calculateSalary();
    }
    public  double calculateSalary(){
        return  baseSalary+Math.min(Math.max(0.05*getPerformanceRating()*baseSalary,500),10000);
    }
}
