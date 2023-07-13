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

public class Costs extends JFrame implements ActionListener

{

	JButton property, Reset;
	JPanel panel;
	JLabel label1;
	JTextField text1;
	Vector data;
	Vector heading;

	JButton view;
	JScrollPane pane;
	JTable table;
	int v, h;
	String s, d, call, dt;
	Container c;

	JLabel imglabel;

	Costs(Vector data) {

		setTitle("CLOUD COSTS DETAILS::Combining Efficiency, Fidelity, and Flexibility in Resource Information Services");
		c = getContentPane();
		c.setLayout(new FlowLayout());

		label1 = new JLabel();
		label1.setText("Enter Username");

		text1 = new JTextField(20);
		property = new JButton("View Property");

		property.addActionListener(this);

		// c.add(label1);
		// c.add(text1);
		// c.add(property);

		c.setBackground(Color.ORANGE);
		setSize(600, 500);
		setVisible(true);

		try {

			Vector heading = new Vector();

			heading.addElement("Memory");
			heading.addElement("Bandwidth");
			heading.addElement("CPU Speed");
			heading.addElement("Price");

			

			JTable table = new JTable(data, heading);

			pane = new JScrollPane(table);

			pane.setBounds(100, 50, 650, 500);
			c.add(pane);
			// c.add(image);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent ae) {

		Object o = ae.getSource();

		if (o == property) {

		}

	}

}