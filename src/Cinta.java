import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Cinta {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private ConcurrentLinkedQueue<Elemento> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public void throwElement(int numTolva, int numElemento) throws InterruptedException {
        concurrentLinkedQueue.add(new Elemento(numTolva, numElemento));
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1,2));
        System.out.printf("%s - Tolva #%d ha dejado el elemento %d en la cinta transportadora\n", LocalTime.now().format(dtf), numTolva, numElemento);

    }

    public ConcurrentLinkedQueue<Elemento> getConcurrentLinkedQueue(){
        return this.concurrentLinkedQueue;
    }
}
