public class thread {






    private static class Test0 {
        public void runDialog() {
            System.out.println("Starting dialog from thread" + Thread.currentThread().getId());
        }
    }


    private static Test0 t = new Test0();

    private static class ThreadClass implements Runnable {
        public void run() {
            System.out.println("ThreadClass running t.runDialog()");
            t.runDialog();
        }
    }



public static void main(String[] args) {
Thread T1 = new Thread(new ThreadClass());
T1.start();
}
}
