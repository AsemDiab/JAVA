import java.util.LinkedHashMap;
 public abstract class Employee implements PerformanceManipulator {
//    A private field named name (String)
//• A private field named id (int)
//• A private field named salary (double)
//• A private field named performanceRating (int)
     private String name;
     private int id;
     private double salary;
     private int performanceRating;

     public Employee(String name, int id, double salary, int performanceRating) {
         this.name = name;
         this.id = id;
         this.salary = salary;
         this.performanceRating = Math.max(0,Math.min(performanceRating,10));

     }
     public abstract double calculateSalary();

     public String getName() {
         return name;
     }

     public int getId() {
         return id;
     }

     public Employee() {
         name=new String();
     }

     public int getPerformanceRating() {
         return performanceRating;
     }

     public void setPerformanceRating(int rating) {
         this.performanceRating = rating;
     }
     @Override
     public void increasePerformanceRating() {
         performanceRating=Math.max(0,Math.min(10,performanceRating+1));
         salary=calculateSalary();
     }
     @Override
     public String toString(){
         return "(Employee's Name:" +this.getName()+", Employee's ID"+this.getId()+", Employee's Rating:"+this.getPerformanceRating()+", Employee's Salary:"+this.calculateSalary()+")";
     }
 }
