package groupproj;
import java.io.*;
import java.text.*;
import java.util.*;
import java.time.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class GroupProj extends JFrame {

    public static Date startTime = new Date(); 
    public static Date endTime = new Date();
    String[] families = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "AM", "PM"};
    
    public static void main(String[] args) throws ParseException {
	GroupProj g = new GroupProj();
	g.setTitle("ALARM");
	g.setSize(200,160);
	g.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	//put logic here
        
	g.setVisible(true);
        
        while(getCurrentCounter() > 0){
            g.paint(g.getGraphics(), getCurrentCounter());
        }
        
        g.paint(g.getGraphics(), 0);
    }
    
    public GroupProj() throws ParseException{
        setStartTime();
        setEndTime(1500000);
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
        long counter = endTime.getTime() - C.getTimeInMillis() ;
        return counter/1000;
    }
            
    
    public void paint(Graphics g, long seconds) {
        Font output = new Font("", Font.BOLD, 55);
        g.clearRect(0, 0, 200, 160);
        g.setFont(output);
        g.drawString(seconds/600 + "" + (seconds/60) % 10 + ":" + (seconds%60) / 10 + "" + (seconds%60) % 10, 20, 100);
    }
}
