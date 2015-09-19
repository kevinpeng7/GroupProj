package groupproj;
import java.io.*;
import java.text.*;
import java.util.*;
import java.time.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class GroupProj extends JFrame {

    public static Date startTime; 
    public static Date endTime; 
    
    public static void main(String[] args) throws ParseException {
	GroupProj g = new GroupProj();
	g.setTitle("ALARM");
	g.setSize(800,600);
	g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	//put logic here
        
	g.setVisible(true);
        
        startTime = new Date();
        endTime = new Date();
        setStartTime();
        setEndTime(1500000);
        Date d = new Date();
        for (int k = 0; true; k++){
            d.setTime(getCurrentCounter());
            System.out.println(d.toString());
        }
    }
    
    public static void setStartTime() throws ParseException{
        Calendar c = Calendar.getInstance();
        startTime.setTime(c.getTimeInMillis());
    }
    
    public static void setEndTime(long milliseconds) throws ParseException{
        endTime.setTime(milliseconds + startTime.getTime());
    }
    
    public static long getCurrentCounter(){
        Calendar C = Calendar.getInstance();
        long counter = C.getTimeInMillis() - startTime.getTime();
        
        return counter; 
    }
}
