
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) {

        Console console = new Console();

        int peopleCount = console.setPeopleCount();

        Semaphore access = new Semaphore(console.setMaxAmount());

        for (int i = 1; i <= peopleCount; i++) {
            String name = "Human ID=" + i;
            Thread thread = new Thread(new Human(access, name));
            thread.start();
        }


    }

}
