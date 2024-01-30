import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;

public class Company {
    ArrayList<Employee>employees;
    static LinkedHashMap<Integer ,Employee> momory;
    Company(){
        employees=new ArrayList<>();momory=new LinkedHashMap<>();
    }
    public void addEmployee(Employee employee){
        if(momory.get(employee.getId())==null){
            employees.add(employee);
            momory.put(employee.getId(),employee);
            System.out.println("Employee added successfully");
        }
        else
            System.out.println("there's an employee with same id so adding fail");
    }
    /*public void  removeEmployee(int id){
        for (Employee emp:employees)
            if(emp.getId()==id)
                employees.remove(emp);
    }*/
    public void  removeEmployee(int id){
            if(momory.get(id)==null) {
                employees.remove(momory.get(id));
                momory.remove(id);
            }
    }
   /* public Employee findEmployeeByID(int id){
        for (Employee emp:employees)
            if(emp.getId()==id)
                return emp;
        return null;
    }*/

    public Employee findEmployeeByID(int id){
            if(momory.get(id)!=null)
                return momory.get(id);
        System.out.println("Sorry ,no empolyee with this id  ");
            return null;
    }

    public ArrayList<Employee> getEmployeesSortedByName(){
        employees.sort(Comparator.comparing(Employee::getName));
        return employees;
    }
    public double calculateTotalSalary(){
        double total=0.0;
        for ( Employee i:employees)
            total+=i.calculateSalary();
        return total;
    }

    public double calculateTotalSalary(Employee type){
        double averageTotal=0.0;
        if(type.equals(null)){
            averageTotal=0;
            for ( Employee i:employees)
                averageTotal+=i.calculateSalary();
        }
        else{
            int c=0;
            averageTotal=0;
            for (Employee i:employees){
                if(i.getClass()==type.getClass()){
                    c++;
                    averageTotal+=i.calculateSalary();
                }

            }

        }
        return  averageTotal;
    }
    public double calculateTotalSalary(String type){
        double averageTotal=0.0;
        type=type.toLowerCase(Locale.ROOT);
        if(type.equals("Employee")){
            averageTotal=0;
            for ( Employee i:employees)
                averageTotal+=i.calculateSalary();
        }
        else{
            int c=0;
            Employee emp=new FullTimeEmployee();
            if(type.equals("fulltimeemployee"))
                emp=new FullTimeEmployee("",0,0,0);
            else if(type.equals("parttimeemployee"))
                emp=new PartTimeEmployee();
            else  if(type.equals("contractworker"))
                emp=new ContractWorker();
            averageTotal=0;
            for (Employee i:employees){
                if(i.getClass()==emp.getClass()){
                    c++;
                    averageTotal+=i.calculateSalary();
                }

            }


        }
        return  averageTotal;
    }
    public double calculateAverageSalary(Employee type){
        double averageTotal=0.0;
        if(type.equals(null)){
            averageTotal=0;
            for ( Employee i:employees)
                averageTotal+=i.calculateSalary();
            averageTotal=averageTotal/employees.size();
        }
        else{
            int c=0;
            averageTotal=0;
            for (Employee i:employees){
                if(i.getClass()==type.getClass()){
                    c++;
                    averageTotal+=i.calculateSalary();
                }

            }
            averageTotal=averageTotal/c;

        }
        return  averageTotal;
    }
    public double calculateAverageSalary(){
        double averageTotal=0.0;
            averageTotal=0;
            for ( Employee i:employees)
                averageTotal+=i.calculateSalary();
            averageTotal=averageTotal/employees.size();
            return averageTotal;
        }



    public double calculateAverageSalary(String type){
        double averageTotal=0.0;
        type=type.toLowerCase(Locale.ROOT);
        if(type.equals("Employee")){
            averageTotal=0;
            for ( Employee i:employees)
                averageTotal+=i.calculateSalary();
            averageTotal=averageTotal/employees.size();
        }
        else{
            int c=0;
            Employee emp=new FullTimeEmployee();
            if(type.equals("fulltimeemployee"))
                emp=new FullTimeEmployee("",0,0,0);
            else if(type.equals("parttimeemployee"))
                emp=new PartTimeEmployee();
            else  if(type.equals("contractworker"))
                emp=new ContractWorker();
            averageTotal=0;
            for (Employee i:employees){
                if(i.getClass()==emp.getClass()){
                    c++;
                    averageTotal+=i.calculateSalary();
                }

            }
            averageTotal=averageTotal/c;

        }
        return  averageTotal;
    }
}
