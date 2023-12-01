package modelo;
import java.util.ArrayList;
import java.util.List;
public class Candidato2 {
    private List<Candidato>miLista;

    public Candidato2(){
        this.miLista = new ArrayList<>();
    }
    public Candidato2(List<Candidato> miLista2) {
    }
    public List<Candidato>getMiLista(){
        return this.miLista;
    }
    public void insertarCandidato(Candidato candidato){
        this.miLista.add(candidato);
    }
    public void actualizarCandidato(int indice, Candidato candidato){
        this.miLista.set(indice, candidato);
    }
    public void eliminarCandidato(int indice){
        this.miLista.remove(indice);
    }
}
