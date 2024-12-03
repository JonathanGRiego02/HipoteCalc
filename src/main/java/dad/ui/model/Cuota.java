package dad.ui.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Cuota {
    public IntegerProperty cuota = new SimpleIntegerProperty();
    public DoubleProperty capitalInicial = new SimpleDoubleProperty();
    public DoubleProperty intereses = new SimpleDoubleProperty();
    public DoubleProperty capitalAmortizado = new SimpleDoubleProperty();
    public DoubleProperty capitalPendiente = new SimpleDoubleProperty();

    public Cuota(int cuota, double capitalInicial, double intereses, double capitalAmortizado, double capitalPendiente) {
        this.cuota.set(cuota);
        this.capitalInicial.set(capitalInicial);
        this.intereses.set(intereses);
        this.capitalAmortizado.set(capitalAmortizado);
        this.capitalPendiente.set(capitalPendiente);
    }
    public IntegerProperty cuotaProperty() {
        return cuota;
    }

    public DoubleProperty capitalInicialProperty() {
        return capitalInicial;
    }

    public DoubleProperty interesesProperty() {
        return intereses;
    }

    public DoubleProperty capitalAmortizadoProperty() {
        return capitalAmortizado;
    }

    public DoubleProperty capitalPendienteProperty() {
        return capitalPendiente;
    }
}
