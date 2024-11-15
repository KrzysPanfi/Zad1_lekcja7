import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath = "liczby.txt";
        ArrayList<String> liczby = Download(filepath);
        System.out.println(zad1(liczby));
        ArrayList<String>wynik=zad2(liczby);
        for (String i:wynik){
            System.out.println(i);
        }
    }

    public static ArrayList<String> Download(String filepath) {
        ArrayList<String> Wynik = new ArrayList<>();
        Wynik.add("");
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Wynik.add(line);
            }
            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }
    public static int zad1(ArrayList<String>liczby){
        int count=0;
        for(String i:liczby){
            char[] chars=i.toCharArray();
            if(chars.length>0) {
                if (chars[chars.length - 1] == '0') {
                    count++;
                }
            }
        }
        return count;
    }
    public static ArrayList<String>zad2(ArrayList<String>liczby){
        ArrayList<String>Wynik=new ArrayList<>();
        int naj=0;
        for(String i:liczby){
            if(!i.equals("")) {
                int num = Integer.parseInt(i,2);
                if (num > naj) {
                    naj = num;
                }
            }
        }
        Wynik.add(Integer.toString(naj));
        Wynik.add(decimalToBinary(naj));
        return Wynik;
    }
   public static String decimalToBinary(int n)
    {



        int remainder, quotient = n;
        StringBuilder binaryNum = new StringBuilder();
        while (quotient > 0) {
            remainder = quotient % 2;
            binaryNum.insert(0, Integer.toString(remainder));
            quotient = quotient / 2;
        }
        return binaryNum.toString();
    }

}
