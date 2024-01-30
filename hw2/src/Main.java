import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
       Company company=new Company();
        String str=new String();
        int hours;
        int id;
        int rate;
        System.out.println("Welcome to the Employee Management System\n" );
        Scanner input=new Scanner(System.in);
        Employee emp;
        char choice;
        while (true){
        System.out.println(
                "1. Add an employee\n" +
                "2. Remove an employee\n" +
                "3. Find an employee by ID\n" +
                "4. Print a list of all employees sorted by name\n" +
                "5. Calculate the total salary of all employees in the company\n" +
                "6. Calculate the average salary of full-time employees\n" +
                "7. Calculate the average salary of part-time employees\n" +
                "8. Calculate the total cost of contract workers\n" +
                "9. Increase employee performance rating\n" +
                "0. Quit");
            System.out.println("Enter your choice:");
        choice=input.next().charAt(0);
        switch (choice){
            case '1':
                System.out.println("Select an employee type:\n" +
                        "1. Full-time\n" +
                        "2. Part-time\n" +
                        "3. Contract worker\n" +
                        "Enter your choice:");
                choice=input.next().charAt(0);
                System.out.println("Enter employee name:");
                str=input.next();
                System.out.println("Enter employee ID");
                id=input.nextInt();
                System.out.println("Enter employee performance rating:");
                rate=input.nextInt();
                emp=new FullTimeEmployee();
                switch (choice) {
                    case '1':
                        emp=new FullTimeEmployee(str,id,50000,rate);break;
                    case '2':
                        emp=new PartTimeEmployee(str,id,50000,rate);break;
                    case '3':
                        System.out.println("Enter employee hoursWorked:");
                        hours=input.nextInt();
                        emp=new ContractWorker(str,id,50000,rate, hours);break;

                }

                company.addEmployee(emp);

                break;
            case '2':
                id=input.nextInt();
                company.removeEmployee(id);
                break;
            case '3':

                id=input.nextInt();

                System.out.println(company.findEmployeeByID(id));
                break;
            case '4':
               for (Employee i: company.getEmployeesSortedByName())
                   System.out.println(i);
                break;
            case '5':
                System.out.println(company.calculateTotalSalary());
                break;
            case '6':
                System.out.println(company.calculateAverageSalary("fulltimeemployee"));break;
            case '7':
                System.out.println(company.calculateAverageSalary("parttimeemployee"));break;
            case '8':
                System.out.println(company.calculateTotalSalary(new ContractWorker()));break;
            case '9':
                System.out.print("enter id of employee");
                id=input.nextInt();
                emp=company.findEmployeeByID(id);
                emp.increasePerformanceRating();
                System.out.println("New employee information:\n"+emp);
                break;
            case '0':
                System.out.println("Goodbye!"); System.exit(0); break;
            default:

        }
            System.out.println("------------------------------------------");
        }

    }

}