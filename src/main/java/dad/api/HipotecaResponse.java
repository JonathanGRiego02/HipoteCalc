package dad.api;

import java.util.List;

public class HipotecaResponse {
    public Hipoteca hipoteca;
    public List<Cuota> cuotas;

    public static class Hipoteca {
        public double capital;
        public double interes;
        public int plazos;
    }

    public static class Cuota {
        public int numero;
        public int anyo;
        public int mes;
        public double capitalInicial;
        public double intereses;
        public double capitalAmortizado;
        public double cuota;
        public double capitalPendiente;
    }
}