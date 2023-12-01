package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Candidato;
import modelo.Candidato2;
import modelo.Ciudades;
import modelo.PartidosPoliticos;
import modelo.Promesas;
import vista.Vista;

public class ControladorCiudadano {
   private Candidato2 modelo;
   private Vista vista;
   private Scanner scanner;
   Ciudades newCiudad;
   Promesas promesa;
   Promesas promesa2;
   PartidosPoliticos newPartido;
   int i = 0;
   List<Candidato> miLista = new ArrayList<>();
   int[] lista3 = {0,0,0,0,0,0,0,0,0,0};

   public ControladorCiudadano(Candidato2 modelo, Vista vista, Scanner scanner){
    this.modelo = modelo;
    this.vista = vista;
    this.scanner = scanner;
   }

   public void iniciar(){
    boolean salir = false;

    while(!salir){
        this.vista.menuInicial();
        int nSwitch = Integer.parseInt(this.scanner.nextLine());

        switch (nSwitch) {
            case 1:
                this.insertarCandidato();
                break;
            case 2:
                this.actualizarCandidato();
                break;
            case 3:
                this.eliminarCandidato();
                break;
            case 4:
                this.buscarCandidato();
                break;
            case 5:
                this.listaCandidatos();
                break;
            case 6:
                this.salirdelCRUD();
                break;
            case 0:
                salir = true;
                break;
            default :  System.out.println("Error...vuelva a intentarlo");
        }
    }
   }
private void insertarCandidato() {
    this.scanner.nextLine();
    System.out.println("Ingrese candidato");
    System.out.print("Ingresa su nombre: ");
    String nombre = this.scanner.nextLine();
    System.out.print("Ingresa su cedula: ");
    String cedula = this.scanner.nextLine();

    Ciudades ciudad[] = Ciudades.values();
    System.out.println("\n CIUDADAES DE VALLE DEL CAUCA: \n");
    
    for (int k = 0; k < ciudad.length;k++){
    System.out.print("  " + (k+1)+ "." + ciudad[k]);
    if((k+1)%4 == 0){System.out.println("\n");
    }}

    System.out.print("\n\nDijite el numero que corresponde a su ciudad: ");
    byte numCiudad = this.scanner.nextByte(); 
    this.newCiudad = ciudad[numCiudad - 1];
    System.out.println("\nDijita si eres de Derecha o Izquierda: ");
    System.out.println("1.Derecha       2.Izquierda  ");
    byte numEleccion = this.scanner.nextByte();                   
    boolean derecha;
    if(numEleccion == 1){
        derecha = true;
    }else{derecha = false;} 

    System.out.println("\nPARTIDOS POLITICOS DE COLOMBIA: ");
    PartidosPoliticos partidosP[] = PartidosPoliticos.values();
    for (int x = 0; x < partidosP.length;x++){ 
    System.out.print("  " + (x+1)+ "." + partidosP[x]);
    if((x+1)%2 == 0){System.out.println("\n");
       }
    }

    System.out.print("\n\nDijite el numero que corresponde a su Partido Politico: ");
    byte numPartido = this.scanner.nextByte();  //se guarda el num del pPolitico dijitado
    this.lista3[(int)numPartido-1] += 1;
    this.newPartido = partidosP[numPartido - 1];//se guarda en (newPartido) el valor de la lista paridosP[posicion -1(ya que las posiciones inician en 0)]
    
    System.out.println("\n-PROMESAS-");
    Promesas newPromesas[] = Promesas.values();
    for (int y = 0; y < newPromesas.length;y++){
    System.out.print("  " + (y+1)+ "." + newPromesas[y]);
    if((y+1)%2 == 0){System.out.println("\n");
    }}

    System.out.print("\n\nDijite el numero que corresponde a a promesa deseada: ");
    byte numPromesa = this.scanner.nextByte(); 
    this.promesa = newPromesas[numPromesa - (byte)1];
    
    System.out.print("\n\nDijite el numero de la segunda promesa deseada: ");
    byte numPromesa2 = this.scanner.nextByte(); 
    this.promesa2 = newPromesas[numPromesa2 - (byte)1];

    Candidato candidato = new Candidato(nombre, cedula, this.newCiudad, derecha, this.newPartido,this.promesa,this.promesa2);
    this.miLista.add(this.i, candidato);
    this.i+=1;
}
private void actualizarCandidato() {
    System.out.println("Lista de candidatos registrados");
    for (int j = 0; j < this.miLista.size(); j++) {                   
        Candidato candidatoExistente = this.miLista.get(j);
        System.out.println((j + 1) + " . " + candidatoExistente.getNombre());
    }
    System.out.println("¿Cual candidato desea hacerle una actualizacion? \n");
    int numeroCandidato = this.scanner.nextInt();

    if (numeroCandidato >= 1 && numeroCandidato <= this.miLista.size()) {
        this.scanner.nextLine();
        Candidato candidatoActualizar = this.miLista.get(numeroCandidato - 1);
                    
        System.out.println("Cambie el nombre:");  
        String nuevoNombre = this.scanner.nextLine();
        System.out.println("Cambie el numero de cedula:");
        String nuevaCedula = this.scanner.nextLine();

        Ciudades ciudad[] = Ciudades.values();    
        System.out.println("ciudades del valle del cauca:");
        for (int k = 0; k < ciudad.length; k++) {
            System.out.print((k + 1) + ". " + ciudad[k] + " ");
            System.out.println("\n");
        }
        System.out.println("\nDigite el numero que corresponde a la nueva ciudad:"); 
        byte numCiudad = this.scanner.nextByte();
        candidatoActualizar.setCiudades(ciudad[numCiudad - 1]);

        System.out.println("Cambie el partido politico:");
        PartidosPoliticos partidosP[] = PartidosPoliticos.values();
        for (int x = 0; x < partidosP.length; x++) {
            System.out.print((x + 1) + ". " + partidosP[x] + " ");
            System.out.println("\n");
        }
        System.out.println("\nDigite el numero que corresponde al nuevo partido politico:"); 
        byte numPartido = this.scanner.nextByte();
        candidatoActualizar.setPartidoPolitico(partidosP[numPartido - 1]);

        System.out.println("Cambie la postura politica:");
        System.out.println("1. Derecha");
        System.out.println("2. Izquierda");
        byte numEleccion = this.scanner.nextByte();
        boolean derecha = (numEleccion == 1);
        candidatoActualizar.setDerecha(derecha);


        candidatoActualizar.setNombre(nuevoNombre);
        candidatoActualizar.setCedula(nuevaCedula);

        System.out.println("Ha actualizado los datos del candidato.");
    } else {
        System.out.println("Este candidato no esta registrado.");
    }
}
private void eliminarCandidato() {
    System.out.println("Lista de candidatos inscritos"); 
    for(int z = 0; z < this.miLista.size(); z++){ // Guarda los nombres de los candidatos que se inscriben 
        Candidato candidatoExistente = this.miLista.get(z);
        System.out.println((z + 1) + " . " + candidatoExistente.getNombre());
    }
    System.out.println("Cuantos candidatos quiere eliminar");
    int numeroCandidato = this.scanner.nextInt();
    
    if(numeroCandidato >=1 && numeroCandidato <= this.miLista.size()){
        this.miLista.remove(numeroCandidato-1);
        System.out.println("El candidato a sido eliminado");
    }else{
        System.out.println("No estas escogiendo un numero del registro");
    }
}
private void buscarCandidato() {
    this.scanner.nextLine();

    System.out.println("Que candidato quiere buscar: ");
    String cBuscar = this.scanner.nextLine();

    boolean cambiar = false;

    for (Candidato candidato : this.miLista){
        if(candidato.getNombre().equalsIgnoreCase(cBuscar)){
           System.out.println("Encontrado");
           System.out.println("Nombre: " + candidato.getNombre());
           System.out.println("Cedula: " + candidato.getCedula());

           cambiar = true;
           break;
        }else{
            System.out.println("No existe este candidato");
        }
    }
}
private void listaCandidatos() {
    System.out.println("Lista de todos los candidatos registrados: \n");
    for (int j = 0; j < this.miLista.size(); j++) { //se recorre e imprime la lista de candidatos registrados
        Candidato candidato = this.miLista.get(j);
        System.out.println("Candidato #" + (j + 1) + ":");    //se imprime la informacion de cada candidato con un # que aumenta con el recorrido del for 
        System.out.println("Nombre: " + candidato.getNombre());
        System.out.println("Cédula: " + candidato.getCedula());
        System.out.println("Ciudad: " + candidato.getCiudades());
        System.out.println("Partido Político: " + candidato.getPartidoPolitico());
        System.out.println("postura Política: " + (candidato.isDerecha() ? "Derecha" : "Izquierda")); // el ? sirve como condicional para determinar la postura politica
        System.out.println();
    }
}