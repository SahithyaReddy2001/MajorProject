import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Owner implements ActionListener {
	String str;
	Socket client;
	String filename;
	String content;
	String us;
	byte[] b;
	String hash;
	public Font f = new Font("Times new roman", Font.BOLD, 25);
	public Font f1 = new Font("Times new roman", Font.BOLD, 16);
	public Font f2 = new Font("Times new roman", Font.BOLD, 16);
	public Font f3 = new Font("Times new roman", Font.BOLD, 14);
	public Font f4 = new Font("Times new roman", Font.BOLD, 15);
	public JLabel T0 = new JLabel("User");

	public JLabel T11 = new JLabel("File Name");

	public JLabel T12 = new JLabel("                    ");

	public JTextField head = new JTextField();

	public JButton upload = new JButton("ENCRYPT & UPLOAD");
	public JButton verify = new JButton("VIEW MY FILES");
	public JButton pur = new JButton("PURCHASE VM");
	public JTextArea tf = new JTextArea();

	public JScrollPane pane = new JScrollPane();

	public JButton browse = new JButton("BROWSE");

	JLabel imageLabel = new JLabel();
	JLabel image = new JLabel();
	JLabel imageLabel1 = new JLabel();
	JLabel image1 = new JLabel();

	JLabel imageLabel2 = new JLabel();
	JLabel image12 = new JLabel();

	JPanel jp = new JPanel();
	JPanel jp1 = new JPanel();

	public JFrame jf;
	public Container c;
	DataOutputStream out;

	Key secKey;
	final static String strPassword = "password12345678";
	static SecretKeySpec key = new SecretKeySpec(strPassword.getBytes(), "AES");

	Cipher encoder = null;
	Key prKey;
	public static Key pubKey;

	String priKey, fname, publKey, path1, path2, path3, path4, f1Sign, f2Sign,
			f3Sign;
	JLabel image11,image122;
	ImageIcon im,im1;

	JButton sign = new JButton("VIEW MY VM");
	JButton update = new JButton("UPDATE");

	MenuBar mbr = new MenuBar();
	Menu file = new Menu("FILE");
	
	MenuItem item4 = new MenuItem("Exit");
	
	

	JButton fid = new JButton("Check VM Availability");
	JButton fle = new JButton("Migrate");
	
	private static Connection con;

	String keyword = "2d2b3bef2bfa3a8cfdb0277b25ed94d79ca0cb99";

	Owner(String username) {
		this.us=username;
		jf = new JFrame();
		c = jf.getContentPane();
		c.setLayout(null);
		
		jf.setTitle(us+"::Detecting Suspicious File Migration or Replication in the Cloud");

		jf.setMenuBar(mbr);
		mbr.add(file);
		
		file.add(item4);
		
		head.setBounds(290, 60, 400, 25);
		head.setFont(f2);
		head.setForeground(Color.black);
		c.add(head);
		
		
		T11.setBounds(210, 60, 200, 25);
		T12.setBounds(230, 29, 1000, 50);
		//T12.setForeground(Color.MAGENTA);
		T11.setForeground(Color.blue);
		T11.setFont(f2);
		
		T12.setFont(f);
		c.add(T11);
		
		
		image11 = new JLabel();
		image11.setIcon(im);
		image11.setBounds(0, -20, 1200, 110);
		
		

		image122 = new JLabel();
		image122.setIcon(im1);
		image122.setBounds(70, -50, 500, 500);

		c.setBackground(Color.white);
		T0.setBounds(440, 60, 350, 45);
		T0.setFont(f);

		T0.setForeground(Color.RED);

	
		
		
		fid.setBounds(720, 200, 180, 30);
		fid.setFont(f3);
		
		fle.setBounds(750, 270, 110, 30);
		fle.setFont(f3);
		
		

		jp.setBounds(40, 80, 800, 540);
		jp.setBackground(Color.yellow);

		jp1.setBounds(35, 75, 765, 550);
     
		upload.setBounds(20, 160, 180, 30);
		upload.setFont(f3);
		browse.setBounds(50, 110, 140, 30);
		browse.setFont(f3);
		
		verify.setBounds(50, 260, 140, 30);
		verify.setFont(f3);

		pur.setBounds(50, 310, 140, 30);
		pur.setFont(f3);
		sign.setBounds(50, 210, 140, 30);
		sign.setFont(f3);
		fid.addActionListener(this);
		fle.addActionListener(this);

		pane.setBounds(290, 90, 400, 300);

		tf.setColumns(100);
		tf.setForeground(Color.black);
		tf.setFont(f1);
		tf.setRows(200);
		tf.setName("tf");
		pane.setName("pane");
		pane.setViewportView(tf);

		upload.addActionListener(this);

		browse.setMnemonic(KeyEvent.VK_B);
		upload.setMnemonic(KeyEvent.VK_S);
		jf.setVisible(true);

		c.add(upload);
		c.add(sign);
		//c.add(update);
		c.add(pane, BorderLayout.CENTER);
		c.add(browse);
		
		c.add(fid);
		c.add(fle);
		c.add(verify);
		c.add(pur);
		c.add(imageLabel1);
		//c.add(jp);
		//c.add(jp1);
		//c.add(image11);
		
		ImageIcon d1 = new ImageIcon(this.getClass().getResource("DataOwner2.png"));
		JLabel d2 = new JLabel();
		d2.setIcon(d1);
		d2.setBounds(0, -55, 1000, 600);
		c.add(d2);
		jf.setSize(960, 550);
		
		pur.addActionListener(this);
		verify.addActionListener(this);
		browse.addActionListener(this);
		sign.addActionListener(this);
		update.addActionListener(this);
		
		item4.addActionListener(this);
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});

	}



	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {

		String strLine = null;
		
		if (e.getSource() == item4) {System.exit(0);}
		
         // Data Migration
		if (e.getSource() == fle) {
			
			try
			{
				String hcode="";
				String fname=JOptionPane.showInputDialog("Enter the Filename");
				
				String[] dsname1 = { "Select Your Cloud Server", "CS1", "CS2" , "CS3"  };
				
				String dataname1 = (String) JOptionPane.showInputDialog(null,
						"Select Your Cloud Server", "Cloud Server Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname1,  dsname1[0]);
				
				
				
				DBCon db = new DBCon();
				Connection con = db.getConnection();
				Statement stmt = con.createStatement();
				
				ResultSet rs=stmt.executeQuery("select * from OwnerFiles where cloudname='"+dataname1+"' and FName='"+fname+"' ");
				if(rs.next()==true)
				{
					hcode=rs.getString(3);
					
				}
				
				if(dataname1.equalsIgnoreCase("CS1"))
				{
					
					
					
					
					String[] dsname = { "Select Cloud Server to Migrate",  "CS2" , "CS3"  };
					
					String dataname = (String) JOptionPane.showInputDialog(null,
							"Select Cloud Server to Migrate", "Cloud Server Name",
							JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
					String ip=JOptionPane.showInputDialog("Enter Cloud Server IP Address");
					
					
					 ResultSet rs1=stmt.executeQuery("select * from cloudfiles where cloudname='"+dataname+"' and mackey='"+hcode+"' ");
					 
					 
						if(rs1.next()==true)
						{
							JOptionPane.showMessageDialog(null, "Detecting Suspicious File Migration or Replication");
					
						}
						else
						{
							Socket socket=new Socket(ip,603); 
							DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
							
							dos.writeUTF(us);
							dos.writeUTF(dataname1);
							dos.writeUTF(dataname);
							dos.writeUTF(fname);
							
							DataInputStream din= new DataInputStream(socket.getInputStream());
							String msg=din.readUTF();
							
							JOptionPane.showMessageDialog(null, msg);
							
						}
					
				}
				if(dataname1.equalsIgnoreCase("CS2"))
				{
					String[] dsname = { "Select Cloud Server to Migrate",  "CS1" , "CS3"  };
					
					String dataname = (String) JOptionPane.showInputDialog(null,
							"Select Cloud Server to Migrate", "Cloud Server Name",
							JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
					String ip=JOptionPane.showInputDialog("Enter Cloud Server IP Address");
					
					 ResultSet rs2=stmt.executeQuery("select * from cloudfiles where cloudname='"+dataname+"' and mackey='"+hcode+"' ");
						if(rs2.next()==true)
						{JOptionPane.showMessageDialog(null, "Detecting Suspicious File Migration or Replication");
					
					
						}
						else
						{
							
							Socket socket=new Socket(ip,603); 
							DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
							
							dos.writeUTF(us);
							dos.writeUTF(dataname1);
							dos.writeUTF(dataname);
							dos.writeUTF(fname);
							
							DataInputStream din= new DataInputStream(socket.getInputStream());
							String msg=din.readUTF();
							
							JOptionPane.showMessageDialog(null, msg);
						}
					
				}
				if(dataname1.equalsIgnoreCase("CS3"))
				{
					String[] dsname = { "Select Cloud Server to Migrate",  "CS1" , "CS2"  };
					
					String dataname = (String) JOptionPane.showInputDialog(null,
							"Select Cloud Server to Migrate", "Cloud Server Name",
							JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
					String ip=JOptionPane.showInputDialog("Enter Cloud Server IP Address");
					
					 ResultSet rs3=stmt.executeQuery("select * from cloudfiles where cloudname='"+dataname+"' and mackey='"+hcode+"' ");
						if(rs3.next()==true)
						{
							JOptionPane.showMessageDialog(null, "Detecting Suspicious File Migration or Replication");
					
						}
					else
					{
						Socket socket=new Socket(ip,603); 
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						
						dos.writeUTF(us);
						dos.writeUTF(dataname1);
						dos.writeUTF(dataname);
						dos.writeUTF(fname);
						
						DataInputStream din= new DataInputStream(socket.getInputStream());
						String msg=din.readUTF();
						
						JOptionPane.showMessageDialog(null, msg);
						
					}
					
				}
				
				
				
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
			
			
			
			
		}

		
			
		if (e.getSource() == browse) {

			

			JFileChooser chooser = new JFileChooser();

			try {

				File f = new File(new File("filename.txt").getCanonicalPath());

				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			chooser.showOpenDialog(browse);
			int retval = chooser.showOpenDialog(browse);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				 path1=field.getAbsolutePath();
				 filename = field.getName();
			}
			File curFile = chooser.getSelectedFile();

			try {
				
				FileInputStream fstream = new FileInputStream(curFile);
				b = new byte[fstream.available()];
				fstream.read(b);
				 content = new String(b);
				tf.setText(content);
				head.setText(path1);
				System.out.println(content);
				AES a2= new AES();
				 String path = "Owner/"+us;
					new File("Owner/"+us).mkdir();
					PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
					p.print(new String(a2.encrypt(content,keyword)));
					
					
					MessageDigest md = MessageDigest.getInstance("SHA1");
					FileInputStream fstream1 = new FileInputStream("Owner\\"+us+"\\"+filename);
					DigestInputStream dis1 = new DigestInputStream(fstream1, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
					BigInteger bi1 = new BigInteger(md.digest());
					hash = bi1.toString(16);
					
					System.out.println(hash);
					
					
				

			} catch (Exception e1) {
				System.err.println("Error: " + e1.getMessage());
			}

		}
		if (e.getSource() == sign) {
	
			try
			{
				String[] dsname = { "Select Cloud Server",  "CS1" , "CS2" , "CS3" };
				
				String dataname = (String) JOptionPane.showInputDialog(null,
						"Select Cloud Server", "Cloud Server Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
			String ip=JOptionPane.showInputDialog("Enter Cloud Server IP Address");
			
			Socket socket=new Socket(ip,10014); 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			dos.writeUTF(us);
			dos.writeUTF(dataname);
			
			ObjectInputStream din= new ObjectInputStream(socket.getInputStream());
			Vector data=(Vector) din.readObject();
			
			OwnerVmDetails aa=new OwnerVmDetails(data);
			aa.setSize(800, 350);
			aa.setVisible(true);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		
if (e.getSource() == pur) {
			
			
			try
			{String[] csserver1 = { "Select the Memory", "100", "1000","10000","100000","1000000","10000000","100000000","1000000000","10000000000" };
			
			 String cloudname1 = (String) JOptionPane.showInputDialog(null,
					"Select the Memory", "Memory Details",
					JOptionPane.QUESTION_MESSAGE, null, csserver1, csserver1[0]);
			
			String[] csname = { "Select Cloud Server", "CS1", "CS2","CS3" };
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
			String ip=JOptionPane.showInputDialog("Enter Cloud Server IP Address");
			 if(cloudname.equalsIgnoreCase("CS1"))
			 {
			try{
				Socket skt = new Socket(ip,20141);
				 System.out.println("sending Registration details to Cloud");
				 DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
				 dos.writeUTF(us);
				 dos.writeUTF(cloudname1);
				
				 
				 
				 
				 
				 DataInputStream dis=new DataInputStream(skt.getInputStream());
				 String status=dis.readUTF();
				 
				 if(status.equals("success"))
				 {
					 JOptionPane.showMessageDialog(null, "Registration Successfull for "+us);
					 
				 }
				 else  
				 {
					 JOptionPane.showMessageDialog(null, "Memory Updated Successfully in Cloud With Name "+us);
					
				 }
				 
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			
			
		}
		
			 if(cloudname.equalsIgnoreCase("CS2"))
			 {
			try{
				Socket skt = new Socket(ip,20151);
				 System.out.println("sending Registration details to Cloud");
				 DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
				 dos.writeUTF(us);
				 dos.writeUTF(cloudname1);
				 
				 DataInputStream dis=new DataInputStream(skt.getInputStream());
				 String status=dis.readUTF();
				 
				 if(status.equals("success"))
				 {
					 JOptionPane.showMessageDialog(null, "Registration Successfull for "+us);
					 
				 }
				 else  
				 {
					 JOptionPane.showMessageDialog(null, "Memory Updated Successfully in Cloud With Name "+us);
					
				 }
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			
			
		}
			 if(cloudname.equalsIgnoreCase("CS3"))
			 {
			try{
				Socket skt = new Socket(ip,20161);
				 System.out.println("sending Registration details to Cloud");
				 DataOutputStream dos = new DataOutputStream(skt.getOutputStream());
				 dos.writeUTF(us);
				 dos.writeUTF(cloudname1);
				 
				 
				 
				 DataInputStream dis=new DataInputStream(skt.getInputStream());
				 String status=dis.readUTF();
				 
				 if(status.equals("success"))
				 {
					 JOptionPane.showMessageDialog(null, "Registration Successfull for "+us);
					 
				 }
				 else  
				 {
					 JOptionPane.showMessageDialog(null, "Memory Updated Successfully in Cloud With Name "+us);
					 
				 }
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			
			
			
		}}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		
		if (e.getSource() == verify) {
			
			
			try
			{
				String[] dsname = { "Select Cloud Server",  "CS1" , "CS2" , "CS3" };
				
				String dataname = (String) JOptionPane.showInputDialog(null,
						"Select Cloud Server", "Cloud Server Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
			String ip=JOptionPane.showInputDialog("Enter Cloud Server IP Address");
			
			Socket socket=new Socket(ip,9005); 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			dos.writeUTF(us);
			dos.writeUTF(dataname);
			
			ObjectInputStream din= new ObjectInputStream(socket.getInputStream());
			Vector data=(Vector) din.readObject();
			
			OwneFileDetails aa=new OwneFileDetails(data);
			aa.setSize(800, 350);
			aa.setVisible(true);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		
		
		if (e.getSource() == fid) {
			
			try
			{
				if(head.getText().equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(null, "Browse the File to Check Fidility");
				}
				else
				{
				String[] dsname = { "Select Cloud Server",  "CS1" , "CS2" , "CS3" };
				
				String dataname = (String) JOptionPane.showInputDialog(null,
						"Select Cloud Server", "Cloud Server Name",
						JOptionPane.QUESTION_MESSAGE, null,  dsname,  dsname[0]);
			String ip=JOptionPane.showInputDialog("Enter HDFS IP Address");
			
			Socket socket=new Socket(ip,3000); 
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			dos.writeUTF(dataname);
			dos.writeUTF(us);
			dos.writeUTF(String.valueOf(content.length()));
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			 String dname= dis.readUTF();
			 
			 
			 JOptionPane.showMessageDialog(null, dname);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
			
		}
		if (e.getSource() == upload) {
			
			
			if(tf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Browse the File and Upload");
			}
			
			else{
				
			
			JFrame frame = new JFrame();

			
			String[] csname = { "Select Cloud Server", "CS1", "CS2", "CS3" };
			
			String cloudname = (String) JOptionPane.showInputDialog(null,
					"Select Cloud Server", "CloudName",
					JOptionPane.QUESTION_MESSAGE, null,  csname,  csname[0]);
			
				 
			String ip = JOptionPane.showInputDialog(frame,
					"Please Enter the IP Address Of Cloud Server");

			
			Socket socket1;
			DataOutputStream dos1;

			try
			 {
				KeyGenerator kgenerate = new KeyGenerator();
				 String sk = String.valueOf(kgenerate.getKeys());
					
				 
				 DBCon db = new DBCon();
				 Connection con = db.getConnection();
				 Statement stmt = con.createStatement();
				 String sql = "insert into OwnerFiles values('"+filename+"','"+sk+"','"+hash+"','"+us+"','"+cloudname+"')";
				 stmt.executeUpdate(sql);
				 
				 if(cloudname.equalsIgnoreCase("CS1"))
				 {
					
				 AES a2= new AES();
				 Socket sc = new Socket(ip,501);
				 DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				 
				 System.out.println(a2.encrypt(content,keyword));
				 
				
				 dout.writeUTF(a2.encrypt(content,keyword));
				 dout.writeUTF(filename);
				 dout.writeUTF(us);
				 dout.writeUTF(sk);
				 dout.writeUTF(hash);
				 dout.writeUTF(cloudname);
				 
				 
				 DataInputStream din = new DataInputStream(sc.getInputStream());
				 String msg = din.readUTF();
				 if(msg.equalsIgnoreCase("success"))
				 {
					 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
					 head.setText(null);
					 tf.setText(null);
					 
				 }
				 else if(msg.equalsIgnoreCase("block"))
				 {
					 JOptionPane.showMessageDialog(null, "Now You are blocked and to access contact Cloud");
					 head.setText(null);
					 tf.setText(null);
				 }
				 else if(msg.equalsIgnoreCase("failure"))
				 {
					 JOptionPane.showMessageDialog(null, "You Dont Have Memory to Upload data to the Cloud");
				 }
				
				 }
//cs1 completed			
				 
				 
				 else if(cloudname.equalsIgnoreCase("CS2"))
				 {
					
							
				 AES a2= new AES();
				 Socket sc = new Socket(ip,502);
				 DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				 
				 System.out.println(a2.encrypt(content,keyword));
				 
				
				 dout.writeUTF(a2.encrypt(content,keyword));
				 dout.writeUTF(filename);
				 dout.writeUTF(us);
				 dout.writeUTF(sk);
				 dout.writeUTF(hash);
				 dout.writeUTF(cloudname);
				 
				 
				 DataInputStream din = new DataInputStream(sc.getInputStream());
				 String msg = din.readUTF();
				 if(msg.equalsIgnoreCase("success"))
				 {
					 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
					 head.setText(null);
					 tf.setText(null);
					 
				 }
				 else if(msg.equalsIgnoreCase("block"))
				 {
					 JOptionPane.showMessageDialog(null, "You Dont Have VM to Upload data to the Cloud");
					 head.setText(null);
					 tf.setText(null);
				 }
				 else if(msg.equalsIgnoreCase("failure"))
				 {
					 JOptionPane.showMessageDialog(null, "You Dont Have Memory to Upload data to the Cloud");
				 }
				
					
						}
				 
				 
				 //cs2completed
				 else if(cloudname.equalsIgnoreCase("CS3"))
				 {
					 
							
					 AES a2= new AES();
				 Socket sc = new Socket(ip,503);
				 DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
				 
				 System.out.println(a2.encrypt(content,keyword));
				 
				
				 dout.writeUTF(a2.encrypt(content,keyword));
				 dout.writeUTF(filename);
				 dout.writeUTF(us);
				 dout.writeUTF(sk);
				 dout.writeUTF(hash);
				 dout.writeUTF(cloudname);
				 
				 
				 DataInputStream din = new DataInputStream(sc.getInputStream());
				 String msg = din.readUTF();
				 if(msg.equalsIgnoreCase("success"))
				 {
					 JOptionPane.showMessageDialog(null, "File Uploaded Successfully");
					 head.setText(null);
					 tf.setText(null);
					 
				 }
				 else if(msg.equalsIgnoreCase("block"))
				 {
					 JOptionPane.showMessageDialog(null, "You Dont Have VM to Upload data to the Cloud");
					 head.setText(null);
					 tf.setText(null);
				 }
				 else if(msg.equalsIgnoreCase("failure"))
				 {
					 JOptionPane.showMessageDialog(null, "You Dont Have Memory to Upload data to the Cloud");
				 }
						
							
							
							
				 }
			 }
			 catch(Exception e1)
			 {
				 e1.printStackTrace();
			 }
				
			
			}

			
			
		}
	}

	public static void main(String args[]) {
		//new DataOwner(" ");
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Owner("aaa");
			}
		});
	}
}
