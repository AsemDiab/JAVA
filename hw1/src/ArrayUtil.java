import java.util.Arrays;
public class ArrayUtil {
    public static Integer [] reverse(Integer [] arr){
        Integer [] copy=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
            copy[i]=arr[arr.length-i-1];
        return  copy;
    }
    public static Integer sum(Integer []arr){
        Integer sum=0;
        for(Integer i:arr)
            sum+=i;
        return  sum;
    }
    public static double average(Double [] arr){
        Double sum=0.0;
        Integer c=0;
        for(Double i:arr){
            c++;
            sum+=i;}
        if(c==0)
            return 0.0;
        return  sum/c;
    }

    public static Integer max(Integer []arr){
        Integer maxNum=-2147483648;
        for(Integer i:arr)
            if(maxNum<i)
                maxNum=i;
        return maxNum;
    }
    public static Integer [] copyArray(Integer [] arr){
        boolean emptyFlag=true;
        for(Integer i:arr){
            emptyFlag=false;
            break;
        }
        if(emptyFlag)
            return null;
        return Arrays.copyOf(arr,arr.length);
    }
    public static <T>void print(T [] arr){
        if(arr==null)
            return;
        for(T i:arr)
            System.out.print(i+" ");
        System.out.println();
    }
}
