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
public class Sports extends System{
    private String sport_id;
    private String sport_name;
    private String centre_id;
    private String[] schedule_id;
    
    Sports(){
        File file = new File("sport.txt");
            if(!file.exists()){
                try{
                   file.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        
    }
    
    public void set_sport_id(String sport_id){
        this.sport_id = sport_id;
    }
    public String get_sport_id(){
        return(sport_id);
    }
    public void set_sport_name(String sport_name){
        this.sport_name = sport_name;
    }
    public String get_sport_name(){
        return(sport_name);
    }
    public void set_centre_id(String centre_id){
        this.centre_id = centre_id;
    }
    public String get_centre_id(){
        return(centre_id);
    }
    public void set_schedule_id(String[] schedule_id){
        this.schedule_id = schedule_id;
    }
    public String[] get_schedule_id(){
        return(schedule_id);
    }

    @Override
    public void writer_accessor() {
        id_generator_accessor();
        String line = sport_id + " , " + sport_name + " , " + centre_id;
        for(int i=0;i<schedule_id.length;i++){
            line = line + " , ";
            line = line + schedule_id[i];
        }
        writer("sport.txt",line);
    }


    @Override
    public void id_generator_accessor() {
        sport_id = id_generator("sport.txt", "SP");
    }
    
    public String[] readname_to_array(String c_id){
        ArrayList<String> snArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("sport.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_id.equals(strarray[2])){
                    snArrayL.add(strarray[1]);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        String[] array = snArrayL.toArray(new String[0]);
        return(array);
    }
    
        public String[] readid_to_array(String c_id){
        ArrayList<String> snArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("sport.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(c_id.equals(strarray[2])){
                    snArrayL.add(strarray[0]);
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        String[] array = snArrayL.toArray(new String[0]);
        return(array);
    }
        
        public String[] find_schedule(String sport_id){
            Sport_schedules ssd = new Sport_schedules();
            ArrayList<String> schedule_record = new ArrayList<>();
            String[] sdarray = new String[20];
            File file = new File("sport.txt");
            try{
                Scanner sc = new Scanner(file);
                while(sc.hasNextLine()){
                    String line = sc.nextLine();
                    sdarray = line.split(" , ");
                    if(sport_id.equals(sdarray[0])){ 
                        for(int i=3; i<sdarray.length; i++){ 
                            
                            
                            schedule_record.add(ssd.display_schedule(sdarray[i]));
        
                        }
                    }
                }
            }catch (FileNotFoundException ex){
                Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] schedule = schedule_record.toArray(new String[0]);
            return(schedule);
        }
        
        public String[] display_all_schedule(String centre_id){
            String[] sport_ids = readid_to_array(centre_id);
            String[] sport_name = readname_to_array(centre_id);
            ArrayList<String> sport_schedule = new ArrayList<>(); 
            for (int i=0; i<sport_ids.length; i++){
                String[] schedule = find_schedule(sport_ids[i]);
                for(int x=0; x<schedule.length; x++){
                    String record_line = sport_name[i] + " > " + schedule[x];
                    sport_schedule.add(record_line);
                }
            }
            return(sport_schedule.toArray(new String[0]));
        }
        public void update_sport(String[] new_schedule_id) throws IOException{
            String[] sport_record = search_by_id("sport.txt",get_sport_id());
            ArrayList<String> schedule_id = new ArrayList<>();
            sport_name = sport_record[1];
            centre_id = sport_record[2];
            for(int i=3; i<sport_record.length; i++){
                schedule_id.add(sport_record[i]);    
            }
            String old_line = sport_id + " , " + sport_name + " , " + centre_id;
            String[] ScheduleArray = schedule_id.toArray(new String[0]);
            for(int i=0;i<ScheduleArray.length;i++){
                old_line = old_line + " , ";
                old_line = old_line + ScheduleArray[i];
            }
            String new_line = sport_id + " , " + sport_name + " , " + centre_id;
            for(int i=0;i<new_schedule_id.length;i++){
                new_line = new_line + " , ";
                new_line = new_line + new_schedule_id[i];
            }
            modifier(old_line, new_line, "sport.txt");
        }
}
