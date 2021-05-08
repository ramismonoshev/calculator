public class CalculatorOfNormalNumbers implements Calculateable{

    private String input = "";

    CalculatorOfNormalNumbers(String input){
            this.input = input;
    }


    public void definingAnOperator(){
        if (input.contains("+"))add();
        if (input.contains("-"))subtract();
        if (input.contains("*"))multiply();
        if (input.contains("/"))divide();
    }

    @Override
    public void add() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("+")));
        int second = Integer.parseInt(input.substring(input.indexOf("+")+1));
        System.out.println(first+second);
    }

    @Override
    public void subtract() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("-")));
        int second = Integer.parseInt(input.substring(input.indexOf("-")+1));
        System.out.println(first-second);
    }

    @Override
    public void multiply() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("*")));
        int second = Integer.parseInt(input.substring(input.indexOf("*")+1));
        System.out.println(first*second);
    }

    @Override
    public void divide() {
        int first = Integer.parseInt(input.substring(0,input.indexOf("/")));
        int second = Integer.parseInt(input.substring(input.indexOf("/")+1));
        System.out.println(first/second);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
