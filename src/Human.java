
import java.util.Random;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Human implements Runnable {
    private String name;
    Semaphore accessToLibrary;
    Semaphore door = new Semaphore(1);

    public Human(Semaphore access, String name) {
        this.accessToLibrary = access;
        this.name = name;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }


    @Override
    public void run() {
        System.out.println(this.getName() + " пришел ко входу в библиотеку");


        try {
            if (accessToLibrary.availablePermits() == 0) {
                System.out.println(this.getName() + " ждет входа в библиотеку");
                accessToLibrary.acquire();
                System.out.println(this.getName() + " подошел к двери с улицы");
                try {
                    door.acquire();
                    System.out.println(this.getName() + " проходит через дверь внутрь");
                    try {
                        sleep(500);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                    System.out.println(this.getName() + " прошел через дверь внутрь");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                door.release();
                System.out.println(this.getName() + " вошел в библиотеку");
                System.out.println(this.getName() + " читает книгу ");
                Random random = new Random();
                int i = random.nextInt(5000 + 1);
                try {
                    sleep(i);
                } catch (InterruptedException f) {
                    f.printStackTrace();
                }
                System.out.println(this.getName() + " вышел из библиотеки");
            } else {
                accessToLibrary.acquire();
                System.out.println(this.getName() + " подошел к двери с улицы");
                try {
                    door.acquire();
                    System.out.println(this.getName() + " проходит через дверь внутрь");
                    try {
                        sleep(500);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                    System.out.println(this.getName() + " прошел через дверь внутрь");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                door.release();
                System.out.println(this.getName() + " вошел в библиотеку");
                System.out.println(this.getName() + " читает книгу ");
                Random random = new Random();
                int i = random.nextInt(5000 + 1);
                try {
                    sleep(i);
                } catch (InterruptedException f) {
                    f.printStackTrace();
                }
                System.out.println(this.getName() + " вышел из библиотеки");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessToLibrary.release();


    }
}
