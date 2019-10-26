package dhe;
import java.io.*;
import java.math.BigInteger;
import editor.Editor;

 /**
 *
 * @author Guilherme
 */
class DHE
{
 public static void main(String args[]) throws IOException
 {       
        //Módulo p público sendo um número primo escolhido entre os dois usuários
        BigInteger p = Editor.recuperarValor("DHE - p");
        System.out.println("Leitura do número primo escolhido para calcular o módulo: "+ p);
        
        
        //Número inteiro público escolhido entre os dois usuários
        BigInteger g = Editor.recuperarValor("DHE - g");
        System.out.println("Leitura do número inteiro público que trabalhará como root de "+ p +": "+ g);
        
        //Número secreto do usuário 1 que não será compartilhado publicamente
        BigInteger x = Editor.recuperarValor("DHE - x");
        System.out.println("Leitura do número secreto para o usuário 1 menor do que "+ p +": "+ x);
        
        //Cálculo do usuário 1 com os dados obtidos, g^x mod p
        BigInteger R1 = g.modPow(x,p);
        System.out.println("R1 = "+ R1);
        
        //Número secreto do usuário 2 que não será compartilhado publicamente
        BigInteger y = Editor.recuperarValor("DHE - y");
        System.out.println("Leitura do número secreto para o usuário 2 menor do que "+ p +": "+y);
        
        //Cálculo do usuário 2 com os dados obtidos, g^y mod p
        BigInteger R2 = g.modPow(y,p);
        System.out.println("R2 = "+R2);
        
        //Chave secreta do usuário 1 calculada com os dados obtidos pelo usuário 2, R2^x mod p
        BigInteger k1 = R2.modPow(x,p);
        System.out.println("Chave secreta para o usuário 1: "+ k1);
        
        //Chave secreta do usuário 2 calculada com os dados obtidos pelo usuário 1, R1^y mod p
        BigInteger k2 = R1.modPow(y,p);
        System.out.println("Chave secreta para o usuário 2: "+ k2);
        
        if(k1.equals(k2))
        {
            System.out.println("Ambos os usuários podem se comunicar entre si.");
        }

        else
        {
            System.out.println("Houve um erro entre as chaves, os usuários não podem se comunicar entre si.");
        }
        
    }
}