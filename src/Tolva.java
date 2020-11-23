import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Tolva implements Runnable {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Cinta cinta;
    private int numTolva;

    public Tolva(Cinta cinta, int numTolva) {
        this.cinta = cinta;
        this.numTolva = numTolva;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                cinta.throwElement(numTolva, i);
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,3));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%s - Tolva #%d está vacía\n", LocalTime.now().format(dtf), numTolva);
    }

}
