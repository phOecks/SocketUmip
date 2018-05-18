
package cliente;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*; // Importa net porque será utilizado Socket para realizar a conexão
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;

public class ChatGUI extends javax.swing.JFrame {
    
    private String nome;
    private Socket s;
    private BufferedReader br;//Recebe/le a mensagem
    private InputStreamReader isr;//pega a mensagem do socket
    private boolean rodar;

    //Construtor
    public ChatGUI(String nome) {
        
        initComponents();
        
        setIcon();
        
        rodar = true;
        this.nome = nome;//nome do usuario
        
        
        
        try{//Operações desse tipo(conexões, requisições) precisam ser feitas com try/catch
            
        s = new Socket("127.0.0.1",5000);// Os parametros são "ip que irá se conectar","Porta que será utilizada"
                                         //Para enviar a mensagem para outro cliente, tem que adicionar o próprio ip
                                         //A porta de entrada deve ser habilitada para uso
        }
        catch(Exception e){
            
            showMessageDialog(null, "Não conseguiu se conectar ao Servidor","",ERROR_MESSAGE); // Apresenta o erro caso não seja estabelecida a conexão
            System.exit(0); //Fecha o programa
        }
        
        Thread();
    }
    
    private void Thread(){//Esta thread vai receber as mensagens
    
        Thread t = new Thread(new Runnable() {
            
            String mensagem;
            
            @Override
            public void run() {//deixa a thread rodando
            
                try{
                
                   isr = new InputStreamReader(s.getInputStream());//Pega a mensagem do socket
                   br = new BufferedReader(isr);//Le a mensagem recebida
                   
                   while((mensagem = br.readLine()) != null){//Enquanto a mensagem recebida for diferente de nulo
                       //a mensagem é lida
                       
                       mensagemRecebida.setText(mensagemRecebida.getText() + mensagem + "\n");
                       
                       if(!rodar){//Deixa o programa rodando enquanto for igual a rodar
                           break;//quando torna diferente de rodar, ele para o codigo
                           
                       }
                       
                   }
                }
                catch(IOException e){
                    
                    showMessageDialog(null,"Erro na conexão", "", ERROR_MESSAGE);
                    
                }
            }
        });
        
        t.start();//Inicia a thread para que possa ser feita a "troca" de mensagens
    
    }
    
        

        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        mensagemRecebida = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensagemEnviada = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Paperless");
        setPreferredSize(new java.awt.Dimension(500, 600));
        setResizable(false);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mensagemRecebida.setEditable(false);
        mensagemRecebida.setBackground(new java.awt.Color(255, 255, 204));
        mensagemRecebida.setColumns(20);
        mensagemRecebida.setLineWrap(true);
        mensagemRecebida.setRows(5);
        jScrollPane3.setViewportView(mensagemRecebida);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        mensagemEnviada.setBackground(new java.awt.Color(255, 255, 204));
        mensagemEnviada.setColumns(1);
        mensagemEnviada.setLineWrap(true);
        mensagemEnviada.setRows(3);
        mensagemEnviada.setTabSize(1);
        mensagemEnviada.setAutoscrolls(false);
        mensagemEnviada.setFocusCycleRoot(true);
        mensagemEnviada.setMaximumSize(new java.awt.Dimension(44, 58));
        mensagemEnviada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mensagemEnviadaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mensagemEnviadaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(mensagemEnviada);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        
        //Verifica se o campo de texto está vazio, e caso esteja, não faz nada
        //(não envia a mensagem nula, porém, o caractér espaço pode ser enviado)
        //Caso tenha algo escrito, envia o nome do usuário mais sua mensagem
        if("".equals(mensagemEnviada.getText().trim())){
            }
        else{
        String mensagem = nome + ": ";
        
       try{//Envia a mensagem e limpa a memória
           
            PrintStream ps = new PrintStream(s.getOutputStream()); //Pega a mensagem do socket para poder enviar a mensagem
            mensagem += mensagemEnviada.getText();//mensagem recebe o que foi digitado no campo de texto
            
            ps.println(mensagem);
            ps.flush();//Serve para limpar a memória, mas é pouco utilizado
            mensagemEnviada.setText("");//limpa todo o campo da mensagem(reset)
       } 
       catch(IOException e){
           //caso tenha algum erro de conexão, a mensagem não será enviada
           showMessageDialog(null,"Não enviou a mensagem", "", ERROR_MESSAGE);
           
       }
       
        }

    }//GEN-LAST:event_btnEnviarActionPerformed
      
    private void mensagemEnviadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensagemEnviadaKeyPressed
         //Acontece a mesma coisa do que o Botão entviar, porem, 
         //Verifica se o ENTER foi apertado para enviar a mensagem
        if (evt.getKeyCode() == evt.VK_ENTER) {
            
            if("".equals(mensagemEnviada.getText().trim())){
            }
            else{

            String mensagem = nome + ": ";

            try {//Envia a mensagem e limpa a memória

                PrintStream ps = new PrintStream(s.getOutputStream());
                mensagem += mensagemEnviada.getText();

                ps.println(mensagem);
                ps.flush();//Serve para limpar a memória, mas é pouco utilizado
                
                
            } catch (IOException e) {

                showMessageDialog(null, "Não enviou a mensagem", "", ERROR_MESSAGE);

            }

        }
       }
        
    }//GEN-LAST:event_mensagemEnviadaKeyPressed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

   
          Object[] options = { "Confirmar", "Cancelar" };//Opções para o OptionDialog
          
           int opcao = JOptionPane.showOptionDialog(null, "Realmente deseja sair?", "Aviso",
                                              JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
               while( opcao == 0 || opcao == -1){//-1 é a opção para o botão padrão fechar do frame
                  try {     
                  s.close();    //Encerra o serviço do socket
                 System.exit(0);//e fecha a aplicação
             } catch (Exception e) {
                 e.printStackTrace();
             }break;//Este break serve para caso o usuário desista de sair da aplicação
             //encerrando o código do loop, e retornando para a aplicação no estado em que estava
         }
             

    }//GEN-LAST:event_btnSairActionPerformed

    private void mensagemEnviadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensagemEnviadaKeyReleased
      //Este evento serve para que o campo de texto seja limpo ao soltar a tecla
      //ENTER
        if (evt.getKeyCode() == evt.VK_ENTER) {
          
          mensagemEnviada.setText("");
      }
    }//GEN-LAST:event_mensagemEnviadaKeyReleased

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea mensagemEnviada;
    private javax.swing.JTextArea mensagemRecebida;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        
        //Definição do icone para a aplicação        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icone.png")));

    }

}
