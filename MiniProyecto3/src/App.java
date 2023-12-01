import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Candidato> miLista = new ArrayList<>();

        Candidato2 candidato2 = new Candidato2(miLista);
        Vista vista = new Vista();
        ControladorCiudadano controladorCiudadano = new ControladorCiudadano(candidato2, vista, scanner);
        controladorCiudadano.iniciar();
    }
}
