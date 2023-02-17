/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author tehyi
 */
public class Admins extends Person{
    Admins(){
        File file = new File("admin.txt");
            if(!file.exists()){
                try{
                   file.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
    }
    public void set_admins_info(){
        String[] admin_array= search_by_id("admin.txt",get_id());
        set_c_code(admin_array[1]);
    }
    
    public void add_admins(){
        set_id(id_generator("admin.txt", "AD"));
        String line1 = get_id() + " , " + get_c_code();
        writer("admin.txt", line1);
        writer_accessor();
    }
}
