class A{
    public static void sm(){
        System.out.println("A");
    }
    public void ms(){
        sm();
    }
}
class B extends A{
    public static void sm(){
        System.out.println("b");
    }
    public void ms(){
        sm();
    }
}
public class yyy {
    public static void main(String []args){
        String s1 = "Java How to program";
        String s2 = "Introduction to Java";
        //s2.replace;
        System.out.println(s2);
        if(s1.regionMatches(0,s2,16,4))
        System.out.println("patata");
       // if(s1.regionMatches(true, 0,S2,16,4)

    }
}
