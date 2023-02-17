/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author tehyi
 */
public class Students extends Person {

    static Students[] student = new Students[100];
    private String old_line = "";
    private String new_line = "";
    private String old_account_info = "";
    private String new_account_info = "";
    Students() {
        File file = new File("student.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDetail(String id) {
        File file = new File("student.txt");
        String[] strarray;

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if (id.equals(strarray[0])) {
                    set_id(strarray[0]);
                    set_name(strarray[1]);
                    set_email(strarray[2]);
                    set_phone(strarray[3]);
                    set_coach_id(strarray[12]);
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getStudentDetail(String ID) {
        File file = new File("student.txt"); //use search_by_id()
        String[] strarray;

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                strarray = line.split(" , ");
                if (ID.equals(strarray[0])) {
                    set_id(strarray[0]);
                    set_name(strarray[1]);
                    set_email(strarray[2]);
                    set_phone(strarray[3]);
                    set_c_code(strarray[10]);
                    set_s_code(strarray[11]);
                    set_coach_id(strarray[12]);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void register() {
        set_id(id_generator("student.txt", "ST"));
        String[] adrs = get_address();
        String line1 = get_id() + " , " + get_name() + " , " + get_email() + " , " + get_phone() + " , " + adrs[0] + " , " + adrs[1]
                + " , " + adrs[2] + " , " + adrs[3] + " , " + adrs[4] + " , " + adrs[5] + " , " + get_c_code() + " , " + get_s_code() + " , " + get_coach_id();
        writer("student.txt", line1);
        writer_accessor();
    }

    public String[] find_coach() {
        Coaches coach = new Coaches();
        String[] strarray = search_by_id("student.txt", get_id());
        String[] coach_record = coach.display_coach(strarray[12]);
        return (coach_record);
    }
    //done until returning coach records 

    public void set_old_student_detail(){
        String[] student_record = search_by_id("student.txt", get_id());
        set_name(student_record[1]);
        set_email(student_record[2]);
        set_phone(student_record[3]);
        set_address(student_record[4], student_record[5], student_record[6], student_record[7], student_record[8], student_record[9]);
        set_c_code(student_record[10]);
        set_s_code(student_record[11]);
        set_coach_id(student_record[12]);
        String[] adrs = get_address();
        old_line = get_id() + " , " + get_name() + " , " + get_email() + " , " + get_phone()+ " , " + adrs[0] + " , " + adrs[1]
                + " , " + adrs[2] + " , " + adrs[3] + " , " + adrs[4] + " , " + adrs[5] + " , " + get_c_code() + " , " + get_s_code() + " , " + get_coach_id();
    }
    
    public void set_old_password(){
        String[] account = search_by_id("account.txt", get_id());
        set_password(account[1]);
        old_account_info = get_id() + " , " + get_password();
    }
    
    public void update_student_detail() throws IOException{
        String[] adrs = get_address();
        new_line = get_id() + " , " + get_name() + " , " + get_email() + " , " + get_phone()+ " , " + adrs[0] + " , " + adrs[1]
                + " , " + adrs[2] + " , " + adrs[3] + " , " + adrs[4] + " , " + adrs[5] + " , " + get_c_code() + " , " + get_s_code() + " , " + get_coach_id();
        modifier(old_line, new_line, "student.txt");
    }
    
    public void update_student_password() throws IOException{
        new_account_info = get_id() + " , " + get_password();
        java.lang.System.out.println(new_account_info);
        modifier(old_account_info, new_account_info, "account.txt");
     }
}
