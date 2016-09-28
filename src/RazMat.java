/**
 * Created by Иван on 24.09.2016.
 */
import javafx.util.Pair;
import java.io.*;
import java.util.*;
public class RazMat {
    RazMat(String name1,String name2) {
        int i = 0;
        int j = 0;
        int sto = 0;
        int str = 0;
        int tst1 = 0,str2 = 0;
        String line;
        double temp=0;
        String numbers[];
        BufferedReader bufferedReader1 = null, bufferedReader2 = null;
        Map<Pair<Integer, Integer>, Double> text1;
        text1 = new HashMap<Pair<Integer, Integer>, Double>();
        Map<Pair<Integer, Integer>, Double> text2;
        text2 = new HashMap<Pair<Integer, Integer>, Double>();
        Map<Pair<Integer, Integer>, Double> text;
        text = new HashMap<Pair<Integer, Integer>, Double>();

        try {

            FileReader fileReader1 = new FileReader(name1);
            bufferedReader1 = new BufferedReader(fileReader1);
            while ((line = bufferedReader1.readLine()) != null) {
                numbers = line.split(" ");
                tst1 = numbers.length;
                for (j = 0; j < numbers.length; j++) {
                    temp = Double.parseDouble(numbers[j]);
                    if (temp != 0) {
                        Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);
                        text1.put(key, temp);
                    }
                }
                i++;
            }
            str = i;
            bufferedReader1.close();


            FileReader fileReader2 = new FileReader(name2);
            bufferedReader2 = new BufferedReader(fileReader2);
            i = 0;
            while ((line = bufferedReader2.readLine()) != null) {
                numbers = line.split(" ");
                sto = numbers.length;//кол-во столбцов
                for (j = 0; j < numbers.length; j++) {
                    temp = Double.parseDouble(numbers[j]);
                    if (temp != 0) {
                        Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);
                        text2.put(key, temp);
                    }
                }
                i++;
                str2=i;
            }
            bufferedReader1.close();
        } catch (Exception e) {
        }

        if (tst1==str2) {
            temp = 0;
            for (i = 0; i < str; i++)
                for (j = 0; j < sto; j++) {
                    for (int k = 0; k < tst1; k++) {
                        Pair<Integer, Integer> key1 = new Pair<Integer, Integer>(i, k);
                        Pair<Integer, Integer> key2 = new Pair<Integer, Integer>(k, j);
                        if ((text1.get(key1) != null) && (text2.get(key2) != null))
                            temp += text1.get(key1) * text2.get(key2);
                    }
                    Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);
                    text.put(key, temp);
                    temp = 0;
                }

            for (i = 0; i < str; i++) {
                for (j = 0; j < sto; j++) {
                    Pair<Integer, Integer> key;
                    key = new Pair<Integer, Integer>(i, j);
                    if (text.get(key) != null)
                        System.out.print(text.get(key) + " ");
                    else
                        System.out.print("0 ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("Произведение невозможно");
    }
}