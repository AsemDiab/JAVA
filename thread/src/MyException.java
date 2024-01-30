import java.util.InputMismatchException;

public class MyException {
    static void dividebyzero(){
        double x=0;
        double y=0;
        System.out.println(y/x);
        System.out.println(1/x);
        System.out.println(1.0f/(int)y);

    }
    static void Throwdividebyzero()throws Exception{
        double x=0;
        double y=0;
        try {


            System.out.println(y / x);
            System.out.println(1 / x);
            System.out.println((int) x / (int) y);
        }
        catch (Exception arc){
            throw new Exception("my nath exception",arc);
        }
    }


    public static void main(String []args){
//    int x=0;
//    assert (x==0):"bad number";
//        System.out.println("pizza");

//        try {

            dividebyzero();
//        }
//
//        catch (Exception arc){
//            arc.printStackTrace();
//            for (StackTraceElement f:arc.getStackTrace())
//                System.out.println(f.getLineNumber()+" "+f.getClassName()+" "+f.getMethodName()+" "+f.getFileName());
//            System.out.println(arc.getMessage());
//           }
////        catch (InputMismatchException  e){}
//        finally{
//            System.out.println("finallly");
//        }
//        assert (false):"code luck";
       // System.out.println(args[3]);
    }

}
class a{}
class b extends a{}
class c extends a{}