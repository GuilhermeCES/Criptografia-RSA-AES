package sha1;

import java.math.BigInteger;
import java.security.MessageDigest;
import editor.Editor;
import java.io.IOException;

public class SHA1 {

	public static void main(String[] argv) throws IOException{

		String mensagem = Editor.recuperarValorMsg("SHA1 - Mensagem");

		String sha1 = "";
		
		try {
                //MessageDigest sendo utilizado para selecionar a implementação SHA1 que será utilizada
                    MessageDigest algoritmo = MessageDigest.getInstance("SHA-1");
	        //reset antes de iniciar o trabalho para evitar problemas
                    algoritmo.reset();
	        
                //Input da string sendo armazenado no algoritmo como byte array, preparando a base do algoritmo
                    algoritmo.update(mensagem.getBytes("utf8"));
	        
                //string em sha1 sendo criada, seguindo formato hexadecimal e aplicando o valor da string após
                //o método digest retornar um byte array que o algoritmo sha trabalhou com a string original
                    sha1 = String.format("%040x", new BigInteger(1, algoritmo.digest()));
		} catch (Exception e){
			e.printStackTrace();
		}
                //editor salvando o resultado final em um txt
                Editor.anotarMsg("SHA1 - Mensagem em SHA1", sha1.toString());
		System.out.println( "O SHA1 de \""+ mensagem + "\" é: "+sha1);
     }
}