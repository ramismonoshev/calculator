public class CheckingPart {

    final  char[] arabNumbers = new char[]{'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
    final  char[] normalNumbers = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private  final String normalNumbers1 = "1234567890+-/*";
    private  final String arabicNumbers1 = "٩٨٧٦٥٤٣٢١٠+-*/";
    private  final String romanNumbers1 = "MCDXLIV+-*/";

    private String input;

    public void setInput(String input) {
        this.input = input;
    }

    public  CheckingPart(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    private  String first = definingFirstPart();
    private  String second = definingSecondPart();

    private  String first_part = checkingForSyntax(first);
    private   String second_part = checkingForSyntax(second);

    private  String firstType = definingTypes(first_part);
    private  String secondType = definingTypes(second_part);

    public  String checking() throws IllegalArgumentException {

        checkingAmountOfInput();

        checkinForSyntax2();

        comparingFirstToSecond();

        String type  = definingFinalTypes();

        return type;

    }

    private  String definingFinalTypes(){
        String type = "";
        if (firstType.equals("normal") && secondType.equals("normal")){
            type += "normal number";
        }else if (firstType.equals("arabic") && secondType.equals("arabic")){
            type += "arabic number";
        }else if (firstType.equals("roman") && secondType.equals("roman")){
            type += "roman number";
        }
        return type;
    }

    private  void comparingFirstToSecond() {
        try{
            if (firstType == secondType) {

            }else {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println("Type of first part have to be the same with second. ");
        }
    }

    private  String definingTypes(String input){
        String type = "";
        if(input.charAt(0) == '+'){
            type += "normal";
        }else if (input.charAt(0) == '-'){
            type += "arabic";
        }else if (input.charAt(0) == '/'){
            type += "roman";
        }
        return type;
    }

    private  void checkingAmountOfInput(){
        try{
            if ( romanNumeralsToIntegers(first) > 10 || romanNumeralsToIntegers(first) < 1 || arabicNumeralsToIntegers(first) > 10 || arabicNumeralsToIntegers(first) < 1 ) {
                throw new IllegalArgumentException();
            }
            if ( romanNumeralsToIntegers(second) > 10 || romanNumeralsToIntegers(second) < 1 || arabicNumeralsToIntegers(second) > 10 || arabicNumeralsToIntegers(second) < 1 ) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal input!  --> 10 >= input > 0 <-- ");
        }
    }

    private  void checkinForSyntax2(){
        try {
            if ( first_part.equals("+") || first_part.equals("-") || first_part.equals("/") || first_part.equals("//") || first_part.equals("++") || first_part.equals("--") || first_part != "///" ){

            } else {
                throw new IllegalArgumentException();
            }
            if ( second_part.equals("+") || second_part.equals("-") || second_part.equals("/") || second_part.equals("//") || second_part.equals("++") || second_part.equals("--") || second_part.equals("///")){

            }else{
                throw new IllegalArgumentException();
            }

        }catch (IllegalArgumentException e){
            System.out.println("Parts have to have correct type! not: <١0>, <10>");
        }
    }


    private  String checkingForSyntax(String input){
        StringBuilder output = new StringBuilder();
        String input1 = input.toUpperCase();

        for (int i = 0; i<input1.length();) {
            if (normalNumbers1.contains(Character.toString(input1.charAt(i)))){
                output.append("+");
                i++;
            }else if (arabicNumbers1.contains(Character.toString(input1.charAt(i)))){
                output.append("-");
                i++;
            }
            else if (romanNumbers1.contains(Character.toString(input1.charAt(i)))){
                output.append("/");
                i++;
            }
        }

        String output2 = output.toString();

        return output2;
    }


    private  int arabicNumeralsToIntegers(String input) {

        char[] chars = input.toCharArray();

        for (int k = 0; k < chars.length; k++) {
            for (int l = 0; l < arabNumbers.length; l++) {
                if (chars[k] == arabNumbers[l]) {
                    chars[k] = normalNumbers[l];
                }
            }
        }

        String s = "";
        for (char c:chars) {
            s += c;
        }

        int a;
        try{
            a = Integer.parseInt(s);
        }catch (NumberFormatException e){
            a = 1;
        }
        return a;
    }


    private  int romanNumeralsToIntegers(String input1) {
        int normalNumbers = 0;
        String input = input1.toUpperCase();
        for (int index = 0; index < input.length();) {
            if (input.charAt(index) == 'M'){
                normalNumbers += 1000;
                index++;
            }
            else if (index < input.length()-1 && input.charAt(index) == 'C' && input.charAt(index+1) == 'M' ){
                normalNumbers += 900;
                index++ ;
            }
            else if (index < input.length() && input.charAt(index) == 'D' ){
                normalNumbers += 500;
                index++;
            }
            else if (index < input.length()-1 && input.charAt(index) == 'C' && input.charAt(index+1) == 'D'){
                normalNumbers += 400;
                index += 2;
            }
            else if (index < input.length() && input.charAt(index) == 'C' ){
                normalNumbers += 100;
                index++;
            }
            else if (index < input.length()-1 && input.charAt(index) == 'X' && input.charAt(index+1) == 'C' ){
                normalNumbers += 90;
                index += 2;
            }
            else if (index < input.length()-1 && input.charAt(index) == 'L' ){
                normalNumbers += 50;
                index++;
            }
            else if (index < input.length()-1 && input.indexOf(index) == 'X' && input.indexOf(index+1) == 'L' ){
                normalNumbers += 40;
                index += 2;
            }
            else if (index < input.length() && input.charAt(index) == 'X') {
                normalNumbers += 10;
                index++;
            }
            else if(index < input.length() - 1 && input.charAt(index) == 'I' && input.charAt(index + 1) == 'X') {
                normalNumbers += 9;
                index += 2;
            }
            else if (index < input.length() && input.charAt(index) == 'V') {
                normalNumbers += 5;
                index++;
            }
            else if (index < input.length() - 1 && input.charAt(index) == 'I' && input.charAt(index + 1) == 'V') {
                normalNumbers += 4;
                index += 2;
            }
            else if (index < input.length() && input.charAt(index) == 'I') {
                normalNumbers++;
                index++;
            }
            else{
                index++;
            }
        }

        if (normalNumbers == 0){
            normalNumbers = 1;
        }

        return normalNumbers;
    }


    private  String definingFirstPart() {
        String first = "";

        if (input.contains("+")) {
            first = input.substring(0, input.indexOf("+"));
        }

        if (input.contains("-")){
            first = input.substring(0, input.indexOf("-"));
        }

        if (input.contains("*")){
            first = input.substring(0, input.indexOf("*"));
        }

        if (input.contains("/")){
            first = input.substring(0, input.indexOf("/"));
        }
        return first;
    }


    private   String definingSecondPart(){

        String second = "";

        if (input.contains("+")){
            second = input.substring(input.indexOf("+")+1);
        }

        if (input.contains("-")){
            second = input.substring(input.indexOf("-")+1);
        }

        if (input.contains("*")){
            second = input.substring(input.indexOf("*")+1);
        }

        if (input.contains("/")){
            second = input.substring(input.indexOf("/")+1);
        }
        return second;
    }
}
