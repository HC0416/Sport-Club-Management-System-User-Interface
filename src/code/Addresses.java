/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment;

/**
 *
 * @author tehyi
 */

public class Addresses {
    private String buildingNo;
    private String streetName;
    private String city;
    private String zip;
    private String state;
    private String country;
    
    public String get_bn(){
        return buildingNo;
    }
    public void set_bn(String buildingNo){
        this.buildingNo = buildingNo;
    }
    public String get_sn(){
        return streetName;
    }
    public void set_sn(String streetName){
        this.streetName = streetName;
    }
    public String get_city(){
        return city;
    }
    public void set_city(String city){
        this.city = city;
    }
    public String get_zip(){
        return zip;
    }
    public void set_zip(String zip){
        this.zip = zip;
    }
    public String get_state(){
        return state;
    }
    public void set_state(String state){
        this.state = state;
    }
    public String get_country(){
        return country;
    }
    public void set_country(String country){
        this.country = country;
    }
}

