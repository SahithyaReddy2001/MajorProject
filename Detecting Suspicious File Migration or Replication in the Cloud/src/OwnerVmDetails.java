import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.io.*;
import java.util.*;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;

import java.net.*;




public class OwnerVmDetails extends JFrame 

{
 
 JPanel panel;
  Vector data;
Vector heading;
JScrollPane pane;
JTable table;
int v,h;
String s,d,call,dt;
Container c;

JLabel imglabel;

OwnerVmDetails(Vector data) 
  {
this.data=data;
setTitle("Data-Owner Vm  Details::Detecting Suspicious File Migration or Replication in the Cloud");
c= getContentPane();
c.setLayout (null);



c.setBackground(Color.green);
setSize(800,100);
setVisible(true);

try { 
	
	 
	 Vector heading = new Vector();
	 
	 heading.addElement("Owner Name");
	 heading.addElement("Password");
	 heading.addElement("Email");
	 heading.addElement("Organization");
	 heading.addElement("Address");
	 heading.addElement("VM1-Memory");
	 heading.addElement("VM2-Memory");
	 heading.addElement("VM3-Memory");
	
	 heading.addElement("VM1-Tasks");
	 heading.addElement("VM2-Tasks");
	 heading.addElement("VM3-Tasks");
	 heading.addElement("Bandwidth");
	 heading.addElement("Start Date");
	 heading.addElement("End Date");
	 heading.addElement("Cloud");
			  
			JTable table = new JTable(data,heading);
			  
			  pane = new JScrollPane(table);
			 
			  pane.setBounds(30,50,700,200);
			  c.add(pane);
			 // c.add(image);
	 } 
	 catch(Exception ex) {ex.printStackTrace();} 




  }





}