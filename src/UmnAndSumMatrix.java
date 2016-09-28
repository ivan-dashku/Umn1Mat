/**
 * Created by Иван on 21.09.2016.
 */
import java.util.Scanner;
import java.util.stream.Stream;
public class UmnAndSumMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("фаил2");
        String name1 = scan.next();
        System.out.println("фаил1");
        String name2 = scan.next();
        System.out.println("0-полные 1-разряженые");
        int temp=scan.nextInt();
        if (temp==1) {
            PolnMat pol = new PolnMat(name1,name2);
        }
        else{
            //RazMat rez = new RazMat(name1,name2);
        }
    }
}
