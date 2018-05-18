
package servidor;


import java.io.*;
import java.net.*; // Importa net porque será utilizado Socket para realizar a conexão
import java.util.ArrayList;

public class Servidor {

    
    public static void main(String[] args) {
        
        ArrayList<PrintStream> clientes = new ArrayList<>();//Aqui nós definimos a lista de usuários conectados
        
        try{  //Operações desse tipo(conexões, requisições) precisam ser feitas com try/catch      
            
            ServerSocket server = new ServerSocket(5000); //Aqui você define qual porta de entrada será usada quando o cliente solicitar a conexão
            Socket socket;         
                        
            while(true){ //Roda sempre que receber novas conexões 
                
                socket = server.accept(); // verifica se a conexão foi aceita  
                
                clientes.add(new PrintStream(socket.getOutputStream())); //Guarda o endereço do cliente
                
                Mensagem mensagem = new Mensagem(socket,clientes);//Recebe a mensagem e os clientes

                    
                }                         
        }    
        catch(IOException e){            
             e.printStackTrace(); 
        }
        
    }
    
}
