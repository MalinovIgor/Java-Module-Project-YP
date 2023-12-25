
public class Main {
    public static void main(String[] args) {

       Calculator.helloAndAsk();
        if(Calculator.flagIfAnyPeople){
            Calculator.goodAdd();
            Formatter.useOutput();
        }
        else
            System.out.println("Пока!");

    }
}