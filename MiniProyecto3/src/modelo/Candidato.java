package modelo;

public class Candidato extends Ciudadano{
    private boolean derecha;
    private PartidosPoliticos partidoPolitico;
    private Promesas promesas;
    private Promesas promesas2;
    public Candidato(String nombre, String cedula, Ciudades ciudades, boolean derecha, PartidosPoliticos partidoPolitico,
                    Promesas promesas, Promesas promesas2) {
        super(nombre, cedula, ciudades);
        this.derecha = derecha;
        this.partidoPolitico = partidoPolitico;
        this.promesas = promesas;
        this.promesas2 = promesas2;
    }
    public boolean isDerecha() {
        return this.derecha;
    }
    public void setDerecha(boolean derecha) {

        this.derecha = derecha;
    }
    public PartidosPoliticos getPartidoPolitico() {
        return this.partidoPolitico;
    }
    public void setPartidoPolitico(PartidosPoliticos partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public Promesas getPromesas(){
        return this.promesas;
    }

    public Promesas getPromesas2(){
        return this.promesas2;
    }

    public void setPromesas(Promesas promesas){
        this.promesas = promesas;
    }

    public void setPromesas2(Promesas promesas2){
        this.promesas2 = promesas2;
    }
}
