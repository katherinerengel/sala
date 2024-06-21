import java.util.Scanner;

public class Menu {
  
    //Método para crear el menú
    public static void MenuInicio(){
        //Para instanciar los métodos de la clase Sala.
        Sala sala = new Sala();

        //Scanner para capturar la información de la consola
        @SuppressWarnings("resource")
        Scanner inputScanner = new Scanner(System.in);  
        boolean salir = true;

        while (salir) {
            System.out.println("*************************");
            System.out.println("       MENU INICIO");
            System.out.println("*************************");
            System.out.println("1. Alta Grupo");
            System.out.println("2. Baja Grupo");
            System.out.println("3. Alta Concierto");
            System.out.println("4. Baja Concierto");
            System.out.println("5. Asignar Concierto");
            System.out.println("6. Listar Conciertos");
            System.out.println("7. Listar Grupos");
            System.out.println("8. Salir");   
    
            //Para que el usuario elija en la consola la opción.
            System.out.print("Elije una opción: ");
            int opcion = inputScanner.nextInt();
            inputScanner.nextLine();  //Para que no se pierda en la búsqueda        
            
            //Condicional Switch para hacer validciones múltiples.
            //Usar el System.out.print SIN el el ln para que no haga salto de línea.
            switch (opcion) {
                case 1: //Alta Grupo.
                    System.out.print("Ingrese el nombre del grupo: ");
                    String nombre = inputScanner.nextLine(); //Para capturar el valor introducido y lo guarde en la variable nombre.
                    System.out.print("Ingrese el tipo de música: ");
                    String tipoMusica = inputScanner.nextLine(); 
                    sala.AltaGrupo(nombre, tipoMusica); //Llama al método alta de grupo y registra la información, la muestra al usuario y hace el break.
                    break;
                case 2: //Baja Grupo.
                    System.out.print("Ingrese el nombre del grupo: ");
                    String nombre1 = inputScanner.nextLine();
                    sala.BajaGrupo(nombre1); //Va al método BajaGrupo, registra la información, lo busca con el método internamente,
                    //si lo encuentra, lo elimina y muestra al usuario la acción y hace el break.
                    break;
                case 3: //Alta Concierto.
                    System.out.print("Ingrese la fecha del concierto (dd-mm-yyyy): ");
                    String fecha = inputScanner.nextLine();
                    System.out.print("Ingrese la hora de inicio (HH:mm): ");
                    String horaInicio = inputScanner.nextLine();
                    System.out.print("Ingrese la hora de finalización (HH:mm): ");
                    String horaCierre = inputScanner.nextLine();
                    //Una vez capturados los valores, va a sala, al metodo AltaConcierto, le asigna los valores y realiza la accion, muestra el usuario cuando termino.
                    sala.AltaConcierto(fecha, horaInicio, horaCierre);
                    break;
                case 4: //Baja Concierto.
                    System.out.print("Ingrese la fecha del conciero (dd-mm-yyyy): ");
                    String fecha1 = inputScanner.nextLine();//Para capturar el valor introducido y lo guarde en la variable nombre.
                    sala.BajaConcierto(fecha1);//Va al método BajaConcierto, registra la información, lo busca con el método internamente,
                    //si lo encuentra, lo elimina y muestra al usuario la acción y hace el break.
                    break;  
                case 5: //Asignar Concierto.
                    System.out.print("Ingrese el nombre del grupo: ");
                    String nombre2 = inputScanner.nextLine();
                    System.out.print("Ingrese la fecha del concierto (dd-mm-yyyy): ");
                    String fecha2 = inputScanner.nextLine();
                    sala.AsignarConcierto(nombre2, fecha2);
                    break; 
                case 6: //Lista de Conciertos por día.
                    System.out.print("Ingrese la fecha del concierto (dd-mm-yyyy): ");
                    String fecha3 = inputScanner.nextLine();
                    sala.ListarConcierto(fecha3);
                    break; 
                case 7: //Lista de Grupos.
                    sala.ListarGrupos();
                    break;                      
                default:
                    salir = false;
                    break;
            }
        }
    }
}
