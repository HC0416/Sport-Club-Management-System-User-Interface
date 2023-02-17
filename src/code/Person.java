/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tehyi
 */
public class Person extends System{
    private String id;
    private String name;
    private String email;
    private String phone;
    private String c_code;
    private String s_code;
    private String p_word;
    private String jdate;
    private String tdate;
    private double h_rate;
    private double rating;
    private String coach_id;
    Addresses address = new Addresses();
    
    Person(){
        File file = new File("account.txt");
        if(!file.exists()){
            try{
               file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }  
    }
    
    public void set_id(String id){
        this.id = id;
    }
    public String get_id(){
        return(id);
    }
    public void set_password(String p_word){
        this.p_word = p_word;
    }
    public String get_password(){
        return(this.p_word);
    }
    
    public void set_name(String name){
        this.name = name;
    }
    public String get_name(){
        return(name);
    }
    public void set_email(String email){
        this.email = email;
    }
    public String get_email(){
        return(email);
    }
    public void set_phone(String phone){
        this.phone = phone;
    }
    public String get_phone(){
        return(phone);
    }
    public void set_c_code(String c_code){
        this.c_code = c_code;
    }
    public String get_c_code(){
        return(c_code);
    }
    public void set_s_code(String s_code){
        this.s_code = s_code;
    }
    public String get_s_code(){
        return(s_code);
    }
    public void set_jdate(String jdate){
        this.jdate = jdate;
    }
    public String get_jdate(){
        return(jdate);
    }
    public void set_tdate(String tdate){
        this.tdate = tdate;
    }
    public String get_tdate(){
        return(tdate);
    }
    public void set_h_rate(Double h_rate){
        this.h_rate = h_rate;
    }
    public Double get_h_rate(){
        return(h_rate);
    }
    public void set_rating(double rating){
        this.rating = rating;
    }
    public double get_rating(){
        return(rating);
    }
    public void set_coach_id(String coach_id){
        this.coach_id = coach_id;
    }
    public String get_coach_id(){
        return(coach_id);
    }
    
    public void set_address(String bno, String sname, String city, String zip, String state, String country){
        address.set_bn(bno);
        address.set_sn(sname);
        address.set_city(city);
        address.set_state(state);
        address.set_zip(zip);
        address.set_country(country);
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
    
     
    public boolean login(){
        File file = new File("account.txt");
        String[] strarray;
        boolean flag = false;
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(id.equals(strarray[0]) && p_word.equals(strarray[1])){
                    flag = true;    
                }
            }
        }catch(IOException ex){
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

     public void getPassword(String id) {
        File fileAccount = new File("account.txt");
        String[] strarray2;
        
        try {
            Scanner sc = new Scanner(fileAccount);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                strarray2 = line.split(" , ");
                if (id.equals(strarray2[0])) {
                    set_password(strarray2[1]);

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    @Override
    public void writer_accessor() {
        String line = id + " , " + p_word;
        writer("account.txt", line);
    }
    
    public void writer_accessor(String file_name, String line){
        writer(file_name, line);
    }
    
    @Override
    public void id_generator_accessor() {
       this.id = id_generator("account.txt", "AD");
    }
    
    public void id_generator_accessor(String file_name, String id_header){
        this.id = id_generator(file_name, id_header);
    }
    
        
    public boolean isStudent(String id){
        if(id.indexOf("ST")!=-1){
            return true;
        }else{
            return false;
        }
    }
    
}