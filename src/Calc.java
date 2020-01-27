public class Calc extends Compf {
    private StackInt s;
    private static int char2int(char c) {
        return (int)c - (int)'0';
    }
    protected int symOther(char c) {
        if (c < '0' || c > '9') {
            System.out.println("Недопустимый символ»: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        int second = s.pop();
        int first = s.pop();
        switch (c) {
case '+':
            s.push(first + second); break;
case '-':
            s.push(first - second); break;
case '*':
            s.push(first * second); break;
case '/':
            s.push(first / second); break;
        }
    }
    protected void nextOther(char c) {

        if(Num) {
            int chisl = ((s.pop()) * 10) + char2int(c);
            s.push(chisl);
            Num = true;
        }
        else {
            s.push(char2int(c));
            Num = true;
        }


    }
    public Calc() {
        s = new StackInt();
    }
    public final void compile(char[] str) {
        super.compile(str);
        System.out.println("" + hexadecimal(s.top()));
        Num = false;
    }

    public String hexadecimal(int N) {
        char hexadecimal[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        StringBuilder s = new StringBuilder (); //создание нового объекта класса/При работе со строками, которые часто будут модифицироваться
        if (N <= 0) return "0";
        while (N != 0) {
            int number = N % 16;
           s.append(hexadecimal[number]);//формируем нужную нам строку, находя объект из char hexadecimal.Добавить символ к текущей изменяемой строке
            N = N / 16;
        }

        return s.reverse().toString();// результирующая строка,выстроенная в обратном(правильном порядке)
    }
}