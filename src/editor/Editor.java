/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class Editor {
    
    
        /* Função especializada em salvar o valor de um BigInteger em um txt com nome informado pelo
           parâmetro "filename" */
        public static void anotar(String filename, BigInteger n) throws IOException{
            String path = filename+".txt";
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(n.toString());
            buffWrite.close();
        }
        
        /* Função anterior, porém para salvar o valor de uma String em um txt */
        public static void anotarMsg(String filename, String msg) throws IOException{
            String path = filename+".txt";
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(msg);
            buffWrite.close();
        }        

        /* Função especializada em recuperar o valor de um BigInteger em um txt com nome informado pelo
           parâmetro "filename" */
        public static BigInteger recuperarValor(String filename){
            BigInteger bigIntegerStr = null;
            try {
                Scanner scanner = new Scanner(new File(filename+".txt"));
                String leitor=null;
                while (scanner.hasNext()) {
                    leitor = scanner.nextLine();				
                }
                bigIntegerStr=new BigInteger(leitor);
                scanner.close();
                return bigIntegerStr;
                }catch (IOException e) {
                    e.printStackTrace();
                }
            return bigIntegerStr;
        }

        /* Função anterior, porém para recuperar o valor de uma String em um txt */
        public static String recuperarValorMsg(String filename){
            String leitor=null;
            try {
                Scanner scanner = new Scanner(new File(filename+".txt"));    
                while (scanner.hasNext()) {
                    leitor = scanner.nextLine();				
                }
                scanner.close();
                return leitor;
                }catch (IOException e) {
                    e.printStackTrace();
                }
            return leitor;
        }
    
}
