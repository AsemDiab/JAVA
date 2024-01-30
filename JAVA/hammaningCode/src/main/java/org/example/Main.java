package org.example;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Main {

    static int errors=0;
    static  int correctingErrors=0;
    static int [] build_hamm(int []data){
        int [] massge=new int[12];
        int j=2;
        for (int i=0;i<8;i++){
            if(j==3||j==7)j++;
            massge[j]=data[i];
            j++;

        }
        for(int i=0;i<8;i++)
            System.out.print(data[7-i]);
        System.out.println();
        for (int i=0;i<12;i++)
            System.out.print(massge[11-i]);
        System.out.println();
        massge[0]=massge[2]^massge[4]^massge[6]^massge[8]^massge[10];
        massge[1]=massge[2]^massge[5]^massge[6]^massge[9]^massge[10];
        massge[3]=massge[4]^massge[5]^massge[6]^massge[11];
        massge[7]=massge[8]^massge[9]^massge[10]^massge[11];
        for (int i=0;i<12;i++)
            System.out.print(massge[11-i]);

        System.out.println();
        System.out.println();
        return massge;


    }
    public static int [][] readData(String path) throws IOException{
        FileInputStream fileInputStream=new FileInputStream(path);

        int x;
        ArrayList<Integer>arr=new ArrayList<Integer>();
        while (true){
            x=fileInputStream.read();
            if(x==-1)break;
            arr.add(x);
//            System.out.print(((char)x ));
        }
        int [][]Bytes=new int[arr.size()][];
        for (int i=0;i<arr.size();i++){
            Bytes[i]=new int[8];
            ToByte(arr.get(i),Bytes[i]);
        }

        fileInputStream.close();

        return Bytes;
    }
    public static void ToByte(int number,int []arr){
        for(int i=0;i<8;i++){
            arr[i]=0;
        }
        int i=0;
        while(number!=0){
            arr[i]=number%2;
            number/=2;
            i++;
        }


    }
    public static int  ToNumber(int []arr){
        int x=0;
        for(int i=0;i<8;i++){
            x+=arr[i]*Math.pow(2,i);
        }
        return x;
    }

    public static int [][] produceMassage(int [][]arr){
        int [][]Massage=new int [arr.length][];
        for (int i=0;i< arr.length;i++){
            Massage[i]=build_hamm(arr[i]);
        }
        return Massage;
    }

    public static int correctMassage(int [][]massge){
        int x=0;
        int []errorPostion=new int[8];
        for (int i=0;i<massge.length;i++){
            errorPostion[0]=massge[i][0]^massge[i][2]^massge[i][4]^massge[i][6]^massge[i][8]^massge[i][10];
            errorPostion[1]=massge[i][1]^massge[i][2]^massge[i][5]^massge[i][6]^massge[i][9]^massge[i][10];
            errorPostion[2]=massge[i][3]^massge[i][4]^massge[i][5]^massge[i][6]^massge[i][11];
            errorPostion[3]=massge[i][7]^massge[i][8]^massge[i][9]^massge[i][10]^massge[i][11];

            int ErrorIndex=ToNumber(errorPostion);
            if(ErrorIndex>0){
                x++;
                try {


                System.out.println(ErrorIndex);
                massge[i][ErrorIndex-1]^=1;
                correctingErrors++;
                System.out.println("coooe");}
                catch (Exception exception){
                    System.out.println("exception this error can't be soved ");
                }
            }
        }
        correctingErrors=x;
        System.out.println("total errors that hammming correct : "+ x);
        System.out.println("Ratio of correction to errors count"+(double)x/errors);
        return x;

    }

    public static int [][] extractData(int [][]massage){
        int [][]data=new int[massage.length][];
        correctingErrors=correctMassage(massage);
        for(int i=0;i<data.length;i++){

            data[i]=new int [8];

            int k=0;
            for(int j=2;j<12;j++){
                if(j==7||j==3){
                  continue;
                }
                data[i][k]=massage[i][j];
                k++;
            }
        }
        return data;
    }

    public static void addNoise(int [][]massage){
        int total_errors=0;
        for(int j=0;j<massage.length;j++){

        int countOfErrors=(int)Math.floor(4*Math.random()+1);
        countOfErrors*=(int)Math.floor(100000*Math.random()+1);
        int [] noise=new int[8];
        int paratial_errors=0;
        System.out.println(countOfErrors);

            int noiseIndex=(int)Math.floor(8 * Math.random());

            if(countOfErrors==10000){

            massage[j][noiseIndex]^=1;
            massage[j][(noiseIndex+1)%8]^=1;
            total_errors+=2;

        }
        else if(countOfErrors>0){
                massage[j][noiseIndex]^=1;
                total_errors++;
        }
        }

        System.out.println("total errors : "+total_errors);
        errors=total_errors;

    }


    public static void main(String[] args) throws IOException {

        JFileChooser fileChooser = new JFileChooser();

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // User selected a file
            System.out.println("Selected file: " + fileChooser.getSelectedFile());
            int [][] msaa=readData(fileChooser.getSelectedFile().getPath());
                    int data[][]=produceMassage(msaa);
                    int copy[][]=produceMassage(msaa);
            addNoise(data);
            System.out.println();
            String extansion=fileChooser.getSelectedFile().getName();
            build_file(data,extansion.substring(extansion.lastIndexOf('.')+1));
            String str="";
            int [][] recivedDtata=extractData(data);
            str+=("coroection count: "+correctingErrors);
            str+=("\nerrors count:"+errors);
            str+=("\nration of correction to errors:"+ 100*correctingErrors/(double)errors +" % ");
            str+=("\nbit-errors :" + (data.length*12)/(double)(errors-correctingErrors) +" \n ");
            str+=("bit error by comparing : "+8.0*data.length/compare(msaa,recivedDtata));
            JOptionPane.showMessageDialog(null,str,"informational message",JOptionPane.INFORMATION_MESSAGE);
        } else {
            // User canceled the file selection
            System.out.println("File selection canceled.");
        }
    }

   static int compare( int n1[][],int [][]n2){
        int x=0;
        double percent=0;

       System.out.println("n1 ["+n1.length+" * "+n1[0].length+"\n n2 ["+n2.length+" * "+n2[0].length);

        for(int i=0;i<n1.length;i++){
            for(int j=0;j< n2[0].length;j++){
                if(n1[i][j]!=n2[i][j])
                {  x++;
                }}}
       return x;}
    private static void build_file(int[][] ints,String path) throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("output1."+path);
        for(int i=0;i< ints.length;i++)
        fileOutputStream.write(ToNumber(ints[i]));

        fileOutputStream.flush();
        fileOutputStream.close();
    }

}