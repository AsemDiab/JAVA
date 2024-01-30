import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.*;

class node{
    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    node(String [][]index2){
        for (String []w:index2)
        {
            map.put(w[0],w[0]);
            /*if(w[1].toLowerCase().equals("integer")||w[1].toLowerCase().equals("int")){
                System.out.println("Int");
                map.put(w[0],0);}
            if(w[1].toLowerCase().equals("string")){
                System.out.println("String");
                map.put(w[0],"new String()");}*/
        }
    }
    node(){}
    public node (String [][]index2,String[]arr){
        System.out.println("i'm in");
        for (int i=0;i<index2.length;i++)
        {
            if(index2[i][1].toLowerCase().equals("integer")||index2[i][1].toLowerCase().equals("int")){
                System.out.println("Int");
                map.put(index2[i][0],Integer.valueOf(arr[i]));}
            if(index2[i][1].toLowerCase().equals("string")){
                System.out.println("String");
                map.put(index2[i][0],String.valueOf(arr[i]));}
        }

    }

    @Override
    public java.lang.String toString() {
        String s=new String();
        for(String w: map.keySet()){
            s+=String.valueOf(map.get(w))+" ";
        }
        return s+ " ";
    }



}
public class Main {
    public static void main(String [] args){
        ArrayList<node>arr=new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Google Tceh\\IdeaProjects\\untitled\\src\\.idea\\addvance"));
            String[] index=reader.readLine().split(",");
            String[][]index2=new String[index.length][2];
            for(int i=0;i<index.length;i++){
                index2[i]=index[i].split(":");

            }

            node x=new node();

            arr.add(new node(index2));
            String str=reader.readLine();
            System.out.println(str);
            while(str!=null){
                x=new node (index2,str.split(","));
                arr.add(x);
                str= reader.readLine();

            }
        }
        catch (Exception e){
            System.out.println("error");
        }
        for (int i=0;i< arr.size();i++)
        System.out.println(arr.get(i).toString());
    }
}
