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
public class Sport_schedules extends System{
    
    private String schedule_id;
    private String day;
    private String time;
    
    Sport_schedules(){
        File file = new File("sport_schedule.txt");
            if(!file.exists()){
                try{
                   file.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }  
    }
    public void set_schedule_id(String schedule_id){
        this.schedule_id = schedule_id;
    }
    public void set_day(String day){
        this.day = day;
    }
    
    public void set_time(String time){
        this.time = time;
    }
    
    public String get_schedule_id(){
        return(schedule_id);
    }
    
    public String day(){
        return(day);
    }
    
    public String time(){
        return(time);
    }
    
    public String display_schedule(String schedule_id){
        ArrayList<String> Schedule = new ArrayList<>();
        String[] strarray = new String[3];
        String schedule_row = "";
        File file = new File("sport_schedule.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if(schedule_id.equals(strarray[0])){
                    schedule_row = strarray[1] +  " " + strarray[2];
                }
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(schedule_row);
    }
    
    @Override
    public void writer_accessor() {
        id_generator_accessor();
        String line = schedule_id + " , " + day + " , " + time;
        writer("sport_schedule.txt",line);
    }

    @Override
    public void id_generator_accessor() {
        schedule_id = id_generator("sport_schedule.txt", "SD");
    }
    public void update_schedule(String new_day, String start_time, String end_time) throws IOException{
        String[] schedule_record = search_by_id("sport_schedule.txt", get_schedule_id());
        set_day(schedule_record[1]);
        set_time(schedule_record[2]);
        String old_string = schedule_id + " , " + day + " , " + time;
        String new_time = start_time + " - " + end_time;
        String new_string = schedule_id + " , " + new_day + " , " + new_time;
        modifier(old_string, new_string, "sport_schedule.txt");
    }
    
    public String[] readtime_to_array(){
        ArrayList<String> snArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("sport_schedule.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                String timeline = strarray[1] + " --> " + strarray[2];
                snArrayL.add(timeline);

            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        String[] array = snArrayL.toArray(new String[0]);
        return(array);
    }
    
        public String[] readid_to_array(){
        ArrayList<String> snArrayL = new ArrayList<>();
        String[] strarray = new String[5];
        File file = new File("sport_schedule.txt");
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                strarray = line.split(" , ");
                snArrayL.add(strarray[0]);
             
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Sport_centres.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        String[] array = snArrayL.toArray(new String[0]);
        return(array);
    }
}
