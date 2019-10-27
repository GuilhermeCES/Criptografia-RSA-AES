/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha2;
import editor.Editor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Guilherme
 */
public class SHA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
       
       String mensagem = Editor.recuperarValorMsg("SHA2 - Mensagem");
       
       //MessageDigest sendo utilizado para selecionar a implementação SHA2 que será utilizada
       MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
       //reset antes de iniciar o trabalho para evitar problemas
       algoritmo.reset();
       //o método digest retorna um byte array que o algoritmo sha trabalhou com a string original
       //com isso, o armazena em messageDigest
       byte messageDigest[] = algoritmo.digest(mensagem.getBytes("UTF-8"));
       
       
       //O for abaixo percorre os bytes e e converte os valores para String
       //concatenando com a classe StringBuilder
       StringBuilder hexString = new StringBuilder();
       for (byte b : messageDigest) {
         //máscara de bits sendo utilizada para evitar números negativos  
         hexString.append(String.format("%02X", 0xFF & b));
       }
       //valor final sendo salvo em uma string para que possa ser armazenado e exibido
       String sha2 = hexString.toString();
       
       Editor.anotarMsg("SHA2 - Mensagem em SHA2", sha2);
       System.out.println( "O SHA2 de \""+ mensagem + "\" é: "+sha2);
       
   }
          
}
