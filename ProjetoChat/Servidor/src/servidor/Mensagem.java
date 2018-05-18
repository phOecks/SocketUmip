package servidor;


import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Mensagem {
    
    private Socket s;
    private ArrayList<PrintStream> clientes;
    
    public Mensagem(Socket s, ArrayList<PrintStream> clientes){
        this.s = s;
        this.clientes = clientes;
        Thread();
    }
    
    private void Thread(){//A Thread é feita para que possa haver varios usuarios ao mesmo tempo
        
        Thread t = new Thread(new Runnable(){
            
            @Override
            public void run(){
                
                String mensagem = null; 
        
                try{

                    InputStreamReader isr = new InputStreamReader(s.getInputStream());//Pega a mensagem do socket
                    BufferedReader br = new BufferedReader(isr);//e exibe a mensagem na tela

                    while((mensagem = br.readLine()) != null){//Envia sempre que for diferente de vazio
                        enviarMensagem(mensagem);

                    }

                }
                catch(Exception e){
                    e.printStackTrace();
                } 
                
            }
        });
        t.start();
    }
    
    private void enviarMensagem(String mensagem){
        //Envia a mensagem para todos os usuarios que estiverem conectados 
        for(int i = 0; i< clientes.size(); i++){
            
            clientes.get(i).println(mensagem);//Printa a mensagem recebida pelo cliente 
            clientes.get(i).flush();
        
    }
        
    }
}

