public class CalculatorOfRomanNumbers implements Calculateable {

    private String input = "";

    public CalculatorOfRomanNumbers(String input) {
        this.input = input;
    }


    public void definingAnOperator(){
        if (input.contains("+")){add();IntegerToRomanNumeral(result);}
        if (input.contains("-")){subtract();IntegerToRomanNumeral(result);}
        if (input.contains("*")){multiply();IntegerToRomanNumeral(result);}
        if (input.contains("/")){divide();IntegerToRomanNumeral(result);}
    }

    private int result = 0;
    @Override
    public void add() {
        int first = RomanNumeralsToIntegers(input.substring(0, input.indexOf("+")));
        int second = RomanNumeralsToIntegers(input.substring(input.indexOf("+")+1));
        result = first + second;
    }

    @Override
    public void subtract() {
        int first = RomanNumeralsToIntegers(input.substring(0, input.indexOf("-")));
        int second = RomanNumeralsToIntegers(input.substring(input.indexOf("-")+1));
        result = first - second;
    }

    @Override
    public void multiply() {
        int first = RomanNumeralsToIntegers(input.substring(0, input.indexOf("*")));
        int second = RomanNumeralsToIntegers(input.substring(input.indexOf("*")+1));
        result = first * second;
    }

    @Override
    public void divide() {
        int first = RomanNumeralsToIntegers(input.substring(0, input.indexOf("/")));
        int second = RomanNumeralsToIntegers(input.substring(input.indexOf("/")+1));
        result = first / second;
    }


    private static int RomanNumeralsToIntegers(String input1){
        int normalNumbers = 0;
        String input = input1.toUpperCase();
        for (int index =0; index<input.length();){
            if (input.charAt(index) == 'M'){
                normalNumbers += 1000;
                index++;
            }
            if (index < input.length()-1 && input.charAt(index) == 'C' && input.charAt(index+1) == 'M' ){
                normalNumbers += 900;
                index++ ;
            }
            if (index < input.length() && input.charAt(index) == 'D' ){
                normalNumbers += 500;
                index++;
            }
            if (index < input.length()-1 && input.charAt(index) == 'C' && input.charAt(index+1) == 'D'){
                normalNumbers += 400;
                index += 2;
            }
            if (index < input.length() && input.charAt(index) == 'C' ){
                normalNumbers += 100;
                index++;
            }
            if (index < input.length()-1 && input.charAt(index) == 'X' && input.charAt(index+1) == 'C' ){
                normalNumbers += 90;
                index += 2;
            }
            if (index < input.length()-1 && input.charAt(index) == 'L' ){
                normalNumbers += 50;
                index++;
            }
            if (index < input.length()-1 && input.indexOf(index) == 'X' && input.indexOf(index+1) == 'L' ){
                normalNumbers += 40;
                index += 2;
            }
            if (index < input.length() && input.charAt(index) == 'X' ){
                normalNumbers += 10;
                index++;
            }
            if (index < input.length()-1 && input.charAt(index) == 'I' && input.charAt(index+1) == 'X' ){
                normalNumbers += 9;
                index += 2;
            }
            if (index < input.length() && input.charAt(index) == 'V' ){
                normalNumbers += 5;
                index++;
            }
            if (index < input.length()-1 && input.charAt(index) == 'I' && input.charAt(index+1) == 'V' ){
                normalNumbers += 4;
                index += 2;
            }
            if (index < input.length() && input.charAt(index) == 'I' ){
                normalNumbers++;
                index++;
            }
        }
        return normalNumbers;
    }


    public static void IntegerToRomanNumeral(int input) {
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        System.out.println(s);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
