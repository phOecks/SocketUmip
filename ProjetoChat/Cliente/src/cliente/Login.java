/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

/**
 *
 * @author Paulo
 */
public class Login {
    
     static void nomeLogin() {

        JFrame frame = new JFrame("Bate-papo APS Meio Ambiente");
        String nome = "";

        do {//Este loop manda repedir a tela de login enquanto o nome de usuario
            //for menor que 5 caracteres ou ele decidir sair da aplicação

            nome = showInputDialog(frame, "Digite seu nome: ", "Bate-papo APS Meio Ambiente", PLAIN_MESSAGE);//Input do nome de usuario

            if (nome == null) {//Se o usuario decidir fechar a aplicação

                sairLogin();//Leva para a tela de confirmação de saída

            } else if (nome.length() < 5) {//Senão, verifica se o usuario tem menos que 5 caracteres
                JOptionPane.showMessageDialog(null, "Nome do usuário está em branco\nOU\nNome do usuário < 5 caracteres");
            } else {//Caso ele atenda ao requerimento, inicia o chat

                ChatGUI chat = new ChatGUI(nome); //Instancia e inicia a 
                chat.setVisible(true);            //interface gráfica do chat
            }

        } while (nome.length() < 5);

    }

     static void sairLogin(){//Se o usuario desejar sair, aparecera a tela de confirmação
          Object[] options = { "Confirmar", "Cancelar" };//Opções para o OptionDialog
          
           int opcao = JOptionPane.showOptionDialog(null, "Realmente deseja sair?", "Aviso",
                                              JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
               if( opcao == 0 || opcao == -1){//-1 é a opção para o botão padrão fechar do frame
                   System.exit(0);//Fecha a aplicação
               }
               else{//Caso ele desista de sair, volta para a parte do login
                   nomeLogin();
               }
    }
    
}
