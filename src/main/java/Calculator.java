import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    static double sum;
    static boolean flagIfAnyPeople;
    static int peopleNumber;
    static List<Good> goods = new ArrayList<>();

    public static void helloAndAsk() {
        System.out.println("Привет!");
        while (true) {
            System.out.println("Сколько вас? Введи количество людей или напиши \"Завершить\"");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("завершить")) {
                flagIfAnyPeople=false;
                break;
            } else {
                try {
                    int people = Integer.parseInt(input);
                    if (people <= 1) {
                        System.out.println("Ммм..Я точно нужен для подсчётов?");
                    }
                    else{
                        peopleNumber=people;
                        flagIfAnyPeople=true;
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный ввод");
                        /* я нагуглил это, но не уверен, насколько это гладкий способ выйти из ситуации, когда
                        нужно избежать момента с тем, что проверка (if scanner.hasNextDouble перескакивает
                        на новую строку. Очень жду совета по этому моменту!! ^-^
                         */
                }
            }
        }
    }
    public static void goodAdd(){

        while(true) {
            System.out.println("Добавим товар? Введи название или напиши \"Завершить\"");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.trim().isEmpty()){
                System.out.println("Пустой ввод, попробуйте ввести название.");
            }
            else {
                if (input.equalsIgnoreCase("завершить")) {
                    break;
                } else {
                    String name = input;
                    System.out.println("Введи стоимость товара, или напиши \"Завершить\"");
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("завершить")) {
                        break;
                        /* была мысль, что такой большой метод надо разбить,
        но как из этого метода сделать break для цикла while true в вышестоящем методе..?  */
                    } else {
                        tryParseDouble(input,name);
                    }
                }
            }
        }
    }

    public static void tryParseDouble(String input, String name){
        try {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Неверный ввод");
            } else {
                Good good = new Good(name, price);
                goods.add(good);
                sum += price;
                System.out.println("Я добавил товар. ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод");
                        /* я нагуглил это, но не уверен, насколько это гладкий способ выйти из ситуации, когда
                        нужно избежать момента с тем, что проверка (if scanner.hasNextDouble перескакивает
                        на новую строку. Очень жду совета по этому моменту!! ^-^
                         */
        }
    }
}
