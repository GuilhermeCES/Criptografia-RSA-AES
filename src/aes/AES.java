package aes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import editor.Editor;

/**
 *
 * @author Guilherme
 */
public class AES {
    
        /*
        
        A princípio, para o funcionamento correto, é necessário um arquivo
        nomeado de "AES - Mensagem.txt" na pasta padrão do projeto, dentro deste arquivo é inserido a mensagem
        que se deseja criptografar.
        A chave também deve ser informada em um arquivo de texto, chamado de "AES - Chave.txt" onde
        o tamanho da chave deve ser entre:
        32 caracteres -> 256 bits
        24 caracteres -> 192 bits
        16 caracteres -> 128 bits
        */
    
    public static void main(String[] args) throws IOException {
        /* Recupera a chave armazenada no arquivo "AES - Chave.txt" */
        String chave = Editor.recuperarValorMsg("AES - Chave");
        System.out.println("Chave: "+chave);
        
        SecretKey key = new SecretKeySpec(chave.getBytes(), "AES"); 
        
        
        try {
            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, key);	 	 
            /* Recupera a mensagem a ser criptografada no arquivo "AES - Mensagem.txt" */
            String msg = Editor.recuperarValorMsg("AES - Mensagem");	 	 
            /* Criptografa a mensagem */	 	 
            byte[] msgcrip = cipher.doFinal(msg.getBytes());
            /* Salva a mensagem criptografada em seu respectivo txt */
            Editor.anotarMsg("AES - Mensagem criptografada",msgcrip.toString());
            
            /* Exibe a mensagem criptografada salva */	 	 
            System.out.println("Mensagem criptografada: "+ Editor.recuperarValorMsg("AES - Mensagem criptografada"));
            /* Informa ação de descriptografar */	 	 
            cipher.init(Cipher.DECRYPT_MODE, key);	 	 
            /* Recebe a mensagem criptografada e descriptografa */
            byte[] msgdescrip = cipher.doFinal(msgcrip);	 	 
            /* Converte para a base 64 e amazena a mensagem em uma variavel */
            String msgOriginal = new String(msgdescrip);	 	 

            /* Exibe a mensagem descriptografada */
            System.out.println("Mensagem descriptografada: " + msgOriginal);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
}
