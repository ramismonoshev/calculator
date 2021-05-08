public class CalculatorOfArabNumbers implements Calculateable{

    private String input = "";

    CalculatorOfArabNumbers(String input){
        this.input = input;
    }


    char[] arabNumbers = new char[]{'٠','١','٢','٣','٤','٥','٦','٧','٨','٩'};
    char[] normalNumbers = new char[]{'0','1','2','3','4','5','6','7','8','9'};


    private  String result = "";
    public void definingAnOperator(){
        if (input.contains("+"))     {add();
            ArabNumeralsToIntegers(result);}
        if (input.contains("-"))     {subtract();
            ArabNumeralsToIntegers(result);}
        if (input.contains("*"))     {multiply();
            ArabNumeralsToIntegers(result);}
        if (input.contains("/"))     {divide();
            ArabNumeralsToIntegers(result);}
    }

    @Override
    public void add() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("+")));
        int second = Integer.parseInt(input.substring(input.indexOf("+")+1));
        result += first + second;
    }

    @Override
    public void subtract() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("-")));
        int second = Integer.parseInt(input.substring(input.indexOf("-")+1));
        result += first - second;
    }

    @Override
    public void multiply() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("*")));
        int second = Integer.parseInt(input.substring(input.indexOf("*")+1));
        result += first * second;
    }

    @Override
    public void divide() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("/")));
        int second = Integer.parseInt(input.substring(input.indexOf("/")+1));
        result += first / second;
    }


    public void ArabNumeralsToIntegers(String result) {
        char[] chars = result.toCharArray();
        for (int k = 0; k<chars.length; k++){
            for (int l=0; l<arabNumbers.length; l++){
                if (chars[k]==normalNumbers[l]){
                    chars[k]=arabNumbers[l];
                }
            }
        }
        System.out.println(chars);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}


