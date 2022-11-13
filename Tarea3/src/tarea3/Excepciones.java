package tarea3;

/*______________________________________NO HAY MONEDA______________________________________*/
class PagoIncorrectoException extends RuntimeException{
    public PagoIncorrectoException(){}
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}

/*______________________________________FALTA DINERO______________________________________*/
class PagoInsuficienteException extends RuntimeException{
    public PagoInsuficienteException(){}
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}

/*___________________________________SE ACABO LA BEBIDA____________________________________*/
class NoHayBebidaException extends RuntimeException{
    public NoHayBebidaException(){}
    public NoHayBebidaException(String mensaje){
        super(mensaje);
    }
}

/*______________________________RETIRAR BEBIDA DE LA MAQUINA_______________________________*/
class DepositoBebidaSacarException extends RuntimeException{
    public DepositoBebidaSacarException(){}
    public DepositoBebidaSacarException(String mensaje){
        super(mensaje);
    }
}

/*_________________________________NO HAY BEBIDA QUE RETIRAR_______________________________*/
class DepositoBebidaVacioException extends RuntimeException{
    public DepositoBebidaVacioException(){}
    public DepositoBebidaVacioException(String mensaje){
        super(mensaje);
    }
}

/*_______________________________NO HAY VUELTO QUE RETIRAR________________________________*/
class DepositoVueltoVacioException extends RuntimeException{
    public DepositoVueltoVacioException(){}
    public DepositoVueltoVacioException(String mensaje){
        super(mensaje);
    }
}