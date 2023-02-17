/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tehyi
 */
public class Sport_centres extends System{
    
    private String Centre_ID;
    private String Centre_Name;
    Addresses address = new Addresses();
    
    Sport_centres(){
        File file = new File("sport_centre.txt");
            if(!file.exists()){
                try{
                   file.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        
    }
    
    public void set_centre_name(String cn){
        Centre_Name = cn;
    }
    
    public void set_address(String bn, String sn, String city, String zip, String state, String country){
        address.set_bn(bn);
        address.set_sn(sn);
        address.set_city(city);
        address.set_zip(zip);
        address.set_state(state);
        address.set_country(country);
    }
    
    public String get_centre_id(){
        return(this.Centre_ID);
    }
    
    public String get_centre_name(){
        return(this.Centre_Name);
    }
    
    public String[] get_address(){
        String[] ads = new String[6];
        ads[0] = address.get_bn();
        ads[1] = address.get_sn();
        ads[2] = address.get_city();
        ads[3] = address.get_zip();
        ads[4] = address.get_state();
        ads[5] = address.get_country();
        return(ads);
    }
    
    public String[] readname_to_array(){
        ArrayList<String> cnArrayL = new ArrayList<>();
        File file = new File("sport_centre.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
               
                cnArrayL.add(line.split(" , ")[1]);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = cnArrayL.toArray(new String[0]);
        return(array);
    }
    
        public String[] readid_to_array(){
        ArrayList<String> ciArrayL = new ArrayList<>();
        File file = new File("sport_centre.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
               
                ciArrayL.add(line.split(" , ")[0]);
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = ciArrayL.toArray(new String[0]);
        return(array);
    }
    @Override
    public void writer_accessor() {
        String[] addr = get_address();
        String line = Centre_ID + " , " + Centre_Name + " , " + addr[0] + " , " + addr[1]+ " , " + addr[2]+ " , " + addr[3]+ " , " + 
                addr[4]+ " , " + addr[5];
        writer("sport_centre.txt",line);
    }

    @Override
    public void id_generator_accessor() {
        Centre_ID= id_generator("sport_centre.txt", "SC");
    }      
}
    
