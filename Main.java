import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        CheckingPart checkingPart = new CheckingPart(input);

        System.out.println();

        CalculatorOfNormalNumbers calculator = new CalculatorOfNormalNumbers(input);
        CalculatorOfArabNumbers calculator1 = new CalculatorOfArabNumbers(input);
        CalculatorOfRomanNumbers calculator2 = new CalculatorOfRomanNumbers(input);



        String type = checkingPart.checking();

        if (type.equals("normal nuumber")){
            calculator.definingAnOperator();
        }else if (type.equals("arabic number")){
            calculator1.definingAnOperator();
        }else if (type.equals("roman number")){
            calculator2.definingAnOperator();
        }
    }
}