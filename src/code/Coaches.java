/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tehyi
 */
public class Coaches extends Person{

    private String old_string = "";
    private String new_string = "";
    private int rated_people_number;
    
    
    Coaches(){
        File file = new File("coach.txt");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public void set_rate_number(int i){
        rated_people_number = i;        
    }
    
    public int get_rate_number(){
        return(rated_people_number);
    }
    
    public String [] readRate_to_array(String c_code){
        ArrayList<String>CoachR= new ArrayList<>();
        String[] strarray = new String[5];
        File file= new File("coach.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_code.equals(strarray[12])){
                    CoachR.add(strarray[14]);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = CoachR.toArray(new String[0]);
        return(array);
    }
    
    public String[] readname_to_array(String c_code){
        ArrayList<String> coachnArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_code.equals(strarray[12])){
                    coachnArrayL.add(strarray[1]);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = coachnArrayL.toArray(new String[0]);
        return(array);
    }     
    
    public String[] readname_to_array(String c_code, String s_code){
        ArrayList<String> coachnArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_code.equals(strarray[12]) && s_code.equals(strarray[13])){
                    coachnArrayL.add(strarray[1]);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = coachnArrayL.toArray(new String[0]);
        return(array);
    }   
    
    public String[] readid_to_array(String c_code){
        ArrayList<String> coachidArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_code.equals(strarray[12])){
                    coachidArrayL.add(strarray[0]);
                }
            }   
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = coachidArrayL.toArray(new String[0]);
        return(array);
    }  
    
    public String[] readid_to_array(String c_code, String s_code){
        ArrayList<String> coachidArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_code.equals(strarray[12]) && s_code.equals(strarray[13])){
                    coachidArrayL.add(strarray[0]);
                }
            }   
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] array = coachidArrayL.toArray(new String[0]);
        return(array);
    }  
    
    public String[] display_coach(String coach_id){ 
        String[] strarray = new String[3];
        File file = new File("coach.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(coach_id.equals(strarray[0])){
                    break;
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(strarray);
    }
    
    public String[] sort_by_name() throws FileNotFoundException{
        ArrayList<String> coachidArrayL = new ArrayList<>();
        ArrayList<String> newcoachidArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            strarray = line.split(" , ");
            String record_line = strarray[1] + " , " + strarray[0] + " , " + strarray[2]+ " , "+strarray[3]+" , "+strarray[4]+" , "+strarray[5]+" , "+strarray[6]+" , "+strarray[7]+" , "+strarray[8]+" , "+strarray[9]+" , "+strarray[10]+" , "+strarray[11]+" , "+strarray[12]+" , "+strarray[13]+" , "+strarray[14]+" , "+strarray[15];
            coachidArrayL.add(record_line);
        }
        Collections.sort(coachidArrayL);
        String[] array = coachidArrayL.toArray(new String[0]);
        for(int i=0;i<array.length;i++){
            String line = array[i];
            strarray = line.split(" , ");
            String new_record_line = strarray[1] + " , " + strarray[0] + " , " + strarray[2]+ " , "+strarray[3]+" , "+strarray[4]+" , "+strarray[5]+" , "+strarray[6]+" , "+strarray[7]+" , "+strarray[8]+" , "+strarray[9]+" , "+strarray[10]+" , "+strarray[11]+" , "+strarray[12]+" , "+strarray[13]+" , "+strarray[14]+" , "+strarray[15];
            newcoachidArrayL.add(new_record_line);
        }
        String[] newarray = newcoachidArrayL.toArray(new String[0]);
        return(newarray);
    }


    public String[] sort_by_hourly() throws FileNotFoundException{
        ArrayList<String> coachidArrayL = new ArrayList<>();
        ArrayList<String> newcoachidArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            strarray = line.split(" , ");
            String record_line = strarray[4] + " , " + strarray[0] + " , " + strarray[1]+ " , "+strarray[2]+" , "+strarray[3]+" , "+strarray[5]+" , "+strarray[6]+" , "+strarray[7]+" , "+strarray[8]+" , "+strarray[9]+" , "+strarray[10]+" , "+strarray[11]+" , "+strarray[12]+" , "+strarray[13]+" , "+strarray[14]+" , "+strarray[15];
            coachidArrayL.add(record_line);
        }
        Collections.sort(coachidArrayL);
        String[] array = coachidArrayL.toArray(new String[0]);
        for(int i=0;i<array.length;i++){
            String line = array[i];
            strarray = line.split(" , ");
            String new_record_line = strarray[1] + " , " + strarray[2] + " , " + strarray[3]+ " , "+strarray[4]+" , "+strarray[0]+" , "+strarray[5]+" , "+strarray[6]+" , "+strarray[7]+" , "+strarray[8]+" , "+strarray[9]+" , "+strarray[10]+" , "+strarray[11]+" , "+strarray[12]+" , "+strarray[13]+" , "+strarray[14]+" , "+strarray[15];
            newcoachidArrayL.add(new_record_line);
        }
        String[] newarray = newcoachidArrayL.toArray(new String[0]);
        return(newarray);
    }
    
    public String[] sort_by_rating() throws FileNotFoundException{
        ArrayList<String> coachidArrayL = new ArrayList<>();
        ArrayList<String> newcoachidArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("coach.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            strarray = line.split(" , ");
            String record_line = strarray[14] + " , " + strarray[1] + " , " + strarray[2]+ " , "+strarray[3]+" , "+strarray[4]+" , "+strarray[5]+" , "+strarray[6]+" , "+strarray[7]+" , "+strarray[8]+" , "+strarray[9]+" , "+strarray[10]+" , "+strarray[11]+" , "+strarray[12]+" , "+strarray[13]+" , "+strarray[0]+" , "+strarray[15];
            coachidArrayL.add(record_line);
        }
        Collections.sort(coachidArrayL);
        String[] array = coachidArrayL.toArray(new String[0]);
        for(int i=0;i<array.length;i++){
            String line = array[i];
            strarray = line.split(" , ");
            String new_record_line = strarray[14] + " , " + strarray[1] + " , " + strarray[2]+ " , "+strarray[3]+" , "+strarray[4]+" , "+strarray[5]+" , "+strarray[6]+" , "+strarray[7]+" , "+strarray[8]+" , "+strarray[9]+" , "+strarray[10]+" , "+strarray[11]+" , "+strarray[12]+" , "+strarray[13]+" , "+strarray[0]+" , "+strarray[15];
            newcoachidArrayL.add(new_record_line);
        }
        String[] newarray = newcoachidArrayL.toArray(new String[0]);
        return(newarray);
    }

    
     public void getDetail(String id) {
        File file = new File("coach.txt");
        String[] strarrayCoaches;
        
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                strarrayCoaches = line.split(" , ");
                if (id.equals(strarrayCoaches[0])) {
                    set_coach_id(strarrayCoaches[0]);
                    set_name(strarrayCoaches[1]);
                    set_jdate(strarrayCoaches[2]);
                    set_tdate(strarrayCoaches[3]);
                    //set_h_rate(strarrayCoaches[4].toString());
                    set_phone(strarrayCoaches[5]);
                    address.set_bn(strarrayCoaches[6]); 
                    set_c_code(strarrayCoaches[12]);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    public String[] search_coach_by_stid(String student_id){
       String[] student_record = search_by_id("student.txt", student_id);
       String[] coach_record = search_by_id("coach.txt",student_record[12]);
       String[] centre_record = search_by_id("sport_centre.txt",coach_record[12]);
       String[] sport_record = search_by_id("sport.txt",coach_record[13]);
       set_coach_id(coach_record[0]);
       set_name(coach_record[1]);
       set_jdate(coach_record[2]);
       set_tdate(coach_record[3]);
       set_h_rate(Double.parseDouble(coach_record[4]));
       set_phone(coach_record[5]);
       set_address(coach_record[6],coach_record[7],coach_record[8],coach_record[9],coach_record[10],coach_record[11]);
       set_c_code(coach_record[12]);
       set_s_code(coach_record[13]);
       set_rating(Double.parseDouble(coach_record[14]));
       set_rate_number(Integer.parseInt(coach_record[15]));
       ArrayList<String> coach_i = new ArrayList<>(); 
       Collections.addAll(coach_i,coach_record);
       coach_i.set(12, centre_record[1]);
       coach_i.set(13, sport_record[1]);
       String[] coach_array = coach_i.toArray(new String[0]);
       return(coach_array);
    }
    public void update_rating(int i) throws IOException{
        int new_number = get_rate_number() + 1;
        double new_rating = Math.round(((i+(get_rating()*get_rate_number()))/new_number)*100.0)/100.0;
        String[] address = get_address();
        String old_line = get_coach_id() + " , " + get_name() + " , " + get_jdate() + " , " + get_tdate() + " , " +
                get_h_rate() + " , " + get_phone() + " , " + address[0] + " , " + address[1] + " , " + address[2] + " , " +
                address[3] + " , " + address[4] + " , " + address[5] + " , " + get_c_code() + " , " + get_s_code() + " , " +
                get_rating() + " , " + get_rate_number();
        String new_line = get_coach_id() + " , " + get_name() + " , " + get_jdate() + " , " + get_tdate() + " , " +
                get_h_rate() + " , " + get_phone() + " , " + address[0] + " , " + address[1] + " , " + address[2] + " , " +
                address[3] + " , " + address[4] + " , " + address[5] + " , " + get_c_code() + " , " + get_s_code() + " , " +
                new_rating + " , " + new_number; 
        modifier(old_line, new_line, "coach.txt");
    }
    
    public void add_coach(){
        set_coach_id(id_generator("coach.txt", "CH"));
        String[] address = get_address();
        String line1 = get_coach_id() + " , " + get_name() + " , " + get_jdate() + " , - , "+ get_h_rate() + " , " + get_phone() +
                " , " + address[0] + " , " + address[1] + " , " + address[2] + " , " + address[3] + " , " + address[4] + " , " +
                address[5] + " , " + get_c_code() + " , " + get_s_code() + " , 0.0 , 0";
        writer("coach.txt", line1);
        writer_accessor();
    }
    
    public void set_old_coach_detail(String coach_id){
        String[] coach_record = search_by_id("coach.txt",coach_id);
        set_coach_id(coach_record[0]);
        set_name(coach_record[1]);
        set_jdate(coach_record[2]);
        set_tdate(coach_record[3]);
        set_h_rate(Double.parseDouble(coach_record[4]));
        set_phone(coach_record[5]);
        set_address(coach_record[6],coach_record[7],coach_record[8],coach_record[9],coach_record[10],coach_record[11]);
        set_c_code(coach_record[12]);
        set_s_code(coach_record[13]);
        set_rating(Double.parseDouble(coach_record[14]));
        set_rate_number(Integer.parseInt(coach_record[15]));
        String[] address = get_address();
        old_string = get_coach_id() + " , " + get_name() + " , " + get_jdate() + " , " + get_tdate() + " , " +
                        get_h_rate() + " , " + get_phone() + " , " + address[0] + " , " + address[1] + " , " + address[2] + " , " +
                        address[3] + " , " + address[4] + " , " + address[5] + " , " + get_c_code() + " , " + get_s_code() + " , " +
                        get_rating() + " , " + get_rate_number();
    }
    
    public void update_coach_detail() throws IOException{
        String[] address = get_address();
        new_string = get_coach_id() + " , " + get_name() + " , " + get_jdate() + " , " + get_tdate() + " , " +
                        get_h_rate() + " , " + get_phone() + " , " + address[0] + " , " + address[1] + " , " + address[2] + " , " +
                        address[3] + " , " + address[4] + " , " + address[5] + " , " + get_c_code() + " , " + get_s_code() + " , " +
                        get_rating() + " , " + get_rate_number();
        modifier(old_string, new_string, "coach.txt");
    }
}

