import javax.swing.*;
import java.util.ArrayList;
import java.lang.Math;
public class ArrayProcessor {
    private ArrayList<Integer>intArray=new ArrayList<>();

    private boolean isDigits(String str){

        for(int i=0;i<str.length();i++)
            if('0'>str.charAt(i)||str.charAt(i)>'9')
                return  false;
        return (str.length()>0)&&true;
    }
    public void readArray(){
        Boolean digit=true;
        String str;
        while (digit){
            str= JOptionPane.showInputDialog("enter num to add or null to stop");
            if(str.equals(""))
                break;
            if(isDigits(str))
                intArray.add(Integer.valueOf(str));
            else
                System.out.println("you make some wrong plese enter anthor num");;
        }

    }



    private Double[] toDoubleArray(Integer[] arr){
        Integer c=0;
        for(Integer i:arr)
            c+=1;
        Double[]doubleArray=new Double[c];
        for (int i=0;i<c;i++)
            doubleArray[i]=Double.valueOf(arr[i]);
    return doubleArray;
    }
    public void processArray(){
        Integer[]arr=intArray.toArray(new Integer[0]);
        Integer[]arr1=ArrayUtil.reverse(arr);
        System.out.println(ArrayUtil.sum(arr));
        System.out.println(ArrayUtil.average(toDoubleArray(arr)));
        System.out.println(ArrayUtil.max(arr));
        System.out.println((int)(100*Math.random())+1);
        Integer[]arr2=ArrayUtil.copyArray(arr);
        ArrayUtil.print(arr);
        ArrayUtil.print(arr2);
        ArrayUtil.print(arr1);


    }
}
