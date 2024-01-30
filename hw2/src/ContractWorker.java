public class ContractWorker extends Employee {
    private double hourlyRate;
    private double hoursWorked;
    public ContractWorker(){
        super(" ",-1,0,0);
    }

    public ContractWorker(String name, int id, double salary, int performanceRating, double hourlyRate, double hoursWorked) {
        super(name, id, salary, performanceRating);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public ContractWorker(String name, int id, double salary, int performanceRating,  double hoursWorked) {
        super(name, id, salary, performanceRating);
        this.hourlyRate = 50;
        this.hoursWorked = hoursWorked;
        calculateSalary();
    }
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;

    }


}
