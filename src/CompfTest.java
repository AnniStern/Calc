// Тест для компилятора формул.
import java.util.Scanner;

public class CompfTest {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите формулу -> ");

        Compf c = new Compf();
        while (true)
            c.compile(scanner.nextLine().toCharArray());
    }
}