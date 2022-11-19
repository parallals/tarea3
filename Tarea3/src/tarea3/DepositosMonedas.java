package tarea3;

import java.util.ArrayList;


public class DepositosMonedas {
    // PROPIEDADES
    protected ArrayList<Moneda> DepositoVuelto;
    protected ArrayList<Moneda> DepositoPagado;
    //METODOS
    protected DepositosMonedas(){
        DepositoVuelto = new ArrayList<>();
        DepositoPagado = new ArrayList<>();
    }
}
