public class PartTimeEmployee extends Employee {
    private double baseSalary;

    public PartTimeEmployee(String name, int id, double baseSalary, int performanceRating) {
        super(name, id, baseSalary, performanceRating);
        this.baseSalary = 25000.0;
        calculateSalary();
    }

    public  double calculateSalary(){
        return  baseSalary+Math.min(Math.max(0.05*getPerformanceRating()*baseSalary,250),2500);
    }
    public PartTimeEmployee(){

    }
}
