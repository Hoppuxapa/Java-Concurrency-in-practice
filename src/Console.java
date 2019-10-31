import java.util.Scanner;

public class Console {

    public int setPeopleCount() {
        System.out.print("Введите любое положительное целое число для колличества людей: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()&&scan.nextInt()>0) {
            System.out.println("Это не целое положительное число! Введите любое целое положительное число!");
            scan.next();
        }
        int peopleCount = scan.nextInt();
        return peopleCount;

    }

    public int setMaxAmount() {
        System.out.print("Введите любое целое число для лимита колличества людей в библиотеке: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()&&scan.nextInt()>0) {
            System.out.println("Это не целое положительное число! Введите любое целое положительное число!");
            scan.next();
        }
        int maxAmount = scan.nextInt();
        return maxAmount;
    }

}
