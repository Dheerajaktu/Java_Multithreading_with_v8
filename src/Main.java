import creatingThreads.ThreadWithRunnable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Main Method...");
        Thread t1 = new Thread(new ThreadWithRunnable());
        t1.start();
    }
}