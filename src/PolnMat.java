/**
 * Created by Иван on 24.09.2016.
 */
import java.util.*;
import java.io.*;
public class PolnMat {
    PolnMat(String name1,String name2){
        String line;
        int n1=0,n2=0,i,j;
        ArrayList< ArrayList<Double> > text1 = new ArrayList<>();
        ArrayList<ArrayList<Double>> text2 = new ArrayList<>();
        BufferedReader bufferedReader1 = null,bufferedReader2 = null;

        try{

            FileReader fileReader1 = new FileReader(name1);
            bufferedReader1 = new BufferedReader(fileReader1);
            while((line=bufferedReader1.readLine())!=null) {
                String numbers[]=line.split(" ");;
                ArrayList<Double> temp1 = new ArrayList<>();
                for (i=0;i<numbers.length;i++)
                    temp1.add(Double.parseDouble(numbers[i]));
                text1.add(temp1);
                n1=temp1.size();
            }
            bufferedReader1.close();


            FileReader fileReader2 = new FileReader(name2);
            bufferedReader2 = new BufferedReader(fileReader2);
            while((line=bufferedReader2.readLine())!=null) {
                String numbers[] = line.split(" ");
                ArrayList<Double> temp2 = new ArrayList<>();
                for (i = 0; i < numbers.length; i++)
                    temp2.add(Double.parseDouble(numbers[i]));
                text2.add(temp2);
                n2=temp2.size();
            }
            bufferedReader2.close();
        }catch(Exception e){}


        double[][] text = new double[text1.size()][n2];
        if (n1==text2.size()) {

            for (i = 0; i < text1.size(); i++)
                for (j = 0; j < n2; j++)
                    text[i][j] = 0;

            for (i = 0; i < text1.size(); i++)
                for (j = 0; j < n2; j++)
                    for (int k = 0; k < n1; k++)
                        text[i][j] += text1.get(i).get(k) * text2.get(k).get(j);

            for (i = 0; i < text1.size(); i++) {
                for (j = 0; j < n2; j++)
                    System.out.print(text[i][j] + "  ");
                System.out.println();
            }
        }
        else
            System.out.println("Произведение невозможно");

    }
}
