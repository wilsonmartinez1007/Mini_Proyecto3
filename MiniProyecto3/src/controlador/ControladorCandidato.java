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