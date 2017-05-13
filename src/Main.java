import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InverseFizzBuzz fb = new InverseFizzBuzz();
        InverseFizzBuzz.FizzBuzz[] Array = fb.createArray();
        Random rnd = new Random();

        int a = 0;
        int b = 0;
        InverseFizzBuzz.FizzBuzz[] array = null;

        try{
            for(int itr = 0;itr < 200; itr++) {
                StringBuilder sb = new StringBuilder();
                while(a == b) {
                    a = rnd.nextInt(256);
                    b = rnd.nextInt(256);
                }
                array = Arrays.copyOfRange(Array, Math.min(a, b), Math.max(a,b));

                for(int i:fb.sequenceCreation(array, fb.lowestValueCalculation(array))){
                    sb.append(i + ",");
                }
                System.out.println(sb);

                a = b = 0;
            }
        }catch (Exception e){
            System.out.println(fb.lowestValueCalculation(array));
            System.out.println(a + "," + b + "," + e);
        }
    }
}
