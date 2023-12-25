
public class Formatter {
public static void useOutput() {
    System.out.println("Добавленные товары:");
    int i=1;
    for (Good good : Calculator.goods) {
        System.out.print(""+i+" ");
        format(good.getPrice(), good.getName());
        i++;
    }
    System.out.println("--------");             // Как принято делать такое оформление подчеркиванием или ещё чем-то, или так пойдёт?
    format (Calculator.sum, "Итого: ");
    System.out.println("--------");
    format(Calculator.sum/Calculator.peopleNumber, "С каждого по: ");   //надо ли выделить расчёт в отдельный метод у калькулятора?
}

    public static void format(double rubles, String name){

            if (((int) rubles%100>=5 && (int) rubles%100<=20) || (int) rubles%100==0 || (int) rubles%10==0 || (int) rubles % 10 == 5 || (int) rubles % 10 == 6 || (int) rubles % 10 == 7 || (int) rubles % 10 == 8 || (int) rubles % 10 == 9 ){
                System.out.println(String.format("%-15s",name)+" "+String.format("%5.2f", rubles) +" рублей");
            }
            else if ((int) rubles % 10 == 2 || (int) rubles % 10 == 3 || (int) rubles % 10 == 4){
                System.out.println(String.format("%-15s",name)+" "+String.format("%5.2f", rubles) +" рубля");
            }
            else {
                System.out.println(String.format("%-15s",name) +" "+String.format("%5.2f", rubles) +" рубль");
            }
        }           //для коротких название товаров вроде выводится ровно, но.. может, есть способ сделать красивее?
    }

