import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Elemento {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private int numTolva, numElemento;

    public Elemento(int numTolva, int numElemento) {
        this.numTolva = numTolva;
        this.numElemento = numElemento;
    }

    public String toString(){
        return String.format("%s - Se ha clasificado el elemento %d de Tolva #%d\n", LocalTime.now().format(dtf)
                                , numElemento, numTolva);
    }
}
