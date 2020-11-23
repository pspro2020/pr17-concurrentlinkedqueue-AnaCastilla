import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread tolvas;
        Cinta cinta = new Cinta();
        MaquinaSeparadora maquinaSeparadora = new MaquinaSeparadora(cinta);

        for(int i=0; i<5; i++) {
            tolvas = new Thread(new Tolva(cinta ,i));
            tolvas.start();
        }

        TimeUnit.SECONDS.sleep(3);

        maquinaSeparadora.classify();
    }

}
