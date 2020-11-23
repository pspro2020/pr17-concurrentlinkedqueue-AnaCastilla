import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MaquinaSeparadora {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Cinta cinta;

    public MaquinaSeparadora(Cinta cinta) {
        this.cinta = cinta;
    }

    public void classify() throws InterruptedException {
        System.out.printf("%s - La máquina separadora se pone a trabajar\n", LocalTime.now().format(dtf));
        while(!cinta.getConcurrentLinkedQueue().isEmpty()) {
            System.out.print(cinta.getConcurrentLinkedQueue().element().toString());
            cinta.getConcurrentLinkedQueue().remove();
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,2));
        }
        System.out.printf("%s - Todos los elementos han sido clasificados\n", LocalTime.now().format(dtf));
    }
}

