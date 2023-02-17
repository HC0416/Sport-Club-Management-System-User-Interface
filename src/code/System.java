/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tehyi
 */
abstract class System {
    public void writer(String file_name, String line){
        File file1 = new File(file_name);
        try{
            FileWriter fw = new FileWriter(file1,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(line);
            bw.newLine();
            pw.close();
        }catch(IOException ex){
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
    public String id_generator(String file_name, String id_header){
        String id;
        int count = counter(file_name);
        count = count + 1;
        id = id_formator(count, id_header);
        while(checker(file_name, id)){
            count = count+1;
            id = id_formator(count,id_header);
        }
        return(id);
    }
    
    public String id_formator(int count, String id_header){
        String id;
        if(count<10){
            id = id_header + 0 + 0 + 0 + count;
        }else if(count >= 10 & count < 100){
            id = id_header + 0 + 0 + count;
        }else if(count >= 100 & count < 1000){
            id = id_header + 0 + count;
        }else{
            id = id_header + count;
        } 
        return(id);
    }
    
    public int counter(String file_name){
        int count = 0;
        File file = new File(file_name);
        try 
        {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    count = count+1;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count);
    }
    
    public boolean checker(String file_name, String id){
        String[] strarray;
        boolean flag = false;
        File file = new File(file_name);
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(id.equals(strarray[0])){
                    flag = true;
                    java.lang.System.out.println(strarray[0]);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public void modifier(String oldString, String newString, String file_name) throws IOException 
    {
        File file = new File(file_name);
        String oldContent = "";
        BufferedReader bfr = null;
        FileWriter fw = null;
        try{
            FileReader fr = new FileReader(file);
            bfr = new BufferedReader(fr);
            String line = bfr.readLine();
            while(line!=null){
                oldContent = oldContent+line+java.lang.System.lineSeparator();
                line = bfr.readLine();
            }
            String newContent = oldContent.replaceAll(oldString,newString);
            fw = new FileWriter(file);
            fw.write(newContent);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try{
               bfr.close();
               fw.close();
            }catch (FileNotFoundException ex) {
                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    public String[] search_by_id(String file_name, String id){
        File file = new File(file_name);
        String[] strarray = new String[30];
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(id.equals(strarray[0])){
                    break;
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(strarray);
    }
    
    abstract public void writer_accessor();
    abstract public void id_generator_accessor();
   
}


