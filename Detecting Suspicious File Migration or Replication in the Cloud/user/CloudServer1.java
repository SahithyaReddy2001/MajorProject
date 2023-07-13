import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class CloudServer1 extends JFrame implements ActionListener {
		
		
		Container c;
		JButton j1,j2,j3;
		JMenuBar mb;
		JMenu m;
		JMenuItem m1,m2,m3,m4,m6,m5,m7,m22,m222,m11;
		
		
		Font f2 = new Font("Times new Roman",Font.BOLD,14);
		Font f1 = new Font("Times new Roman",Font.BOLD,13);
		

		JLabel lcon,lcloud,lar,l2,l3;
		
		ImageIcon dc=dc=new ImageIcon(this.getClass().getResource("c1.jpg"));
		
		ImageIcon arrow1=arrow1=new ImageIcon(this.getClass().getResource("arrow1b.png"));
		ImageIcon arrow2=arrow2=new ImageIcon(this.getClass().getResource("arrow2b.png"));
		ImageIcon arrow3=arrow3=new ImageIcon(this.getClass().getResource("arrow3b.png"));
		ImageIcon vm1=vm1=new ImageIcon(this.getClass().getResource("vm1b.png"));
		ImageIcon vm2=vm2=new ImageIcon(this.getClass().getResource("vm2b.png"));
		ImageIcon vm3=vm3=new ImageIcon(this.getClass().getResource("vm3b.png"));
		
		ImageIcon arrow1g=arrow1g=new ImageIcon(this.getClass().getResource("arrow1g.png"));
		ImageIcon arrow2g=arrow2g=new ImageIcon(this.getClass().getResource("arrow2g.png"));
		ImageIcon arrow3g=arrow3g=new ImageIcon(this.getClass().getResource("arrow3g.png"));
		ImageIcon vm1g=vm1g=new ImageIcon(this.getClass().getResource("vm1g.png"));
		ImageIcon vm2g=vm2g=new ImageIcon(this.getClass().getResource("vm2g.png"));
		ImageIcon vm3g=vm3g=new ImageIcon(this.getClass().getResource("vm3g.png"));
		
		JLabel lbdc,lbcs,lbcsar;
		JLabel data,larrow1,larrow2,larrow3,lvm1,lvm2,lvm3;
		CloudServer1()
		{
			
			setTitle("CloudServer1::Combining Efficiency, Fidelity, and Flexibility in Resource Information Services");
			c = getContentPane();
			c.setLayout(null);
			
			mb = new JMenuBar();
			m = new JMenu("File");
		
			
			
			
			
			
			
			j1 =  new JButton("OWNERS VM DETAILS");
			j1.setFont(f1);
			j1.setBounds(110,510,182,30);
			c.add(j1);
			
			j2 =  new JButton("VIEW ALL OWNER FILES");
			j2.setFont(f1);
			j2.setBounds(300,510,181,30);
			c.add(j2);
			
			j3 =new JButton("ATTACKER DETAILS");
			j3.setBounds(490,510,157,30);
			j3.setFont(f1);
			c.add(j3);
			j3.addActionListener(this);
			
			m7 =  new JMenuItem("UNBLOCK USER");
			m.add(m7);
			m7.addActionListener(this);
			m4 =  new JMenuItem("EXIT");
			m.add(m4);
			
			m4.addActionListener(this);
			
			
			
			j1.addActionListener(this);
			j2.addActionListener(this);
			mb.add(m);
			setJMenuBar(mb);
			
			 data=new JLabel();
				data.setIcon(dc);
				data.setBounds(100, 190, 190, 180);
				c.add(data);
				
				
				 larrow1=new JLabel();
				larrow1.setIcon(arrow1);
				larrow1.setBounds(290, 130, 250, 150);
				c.add(larrow1);
				
				
				 larrow2=new JLabel();
				larrow2.setIcon(arrow2);
				larrow2.setBounds(295, 220, 280, 150);
				c.add(larrow2);
				
				
				 larrow3=new JLabel();
				larrow3.setIcon(arrow3);
				larrow3.setBounds(290, 310, 280, 150);
				c.add(larrow3);
				
				
				lvm1=new JLabel();
				lvm1.setIcon(vm1);
				lvm1.setBounds(580, 105, 180, 70);
				c.add(lvm1);
				
				
				 lvm2=new JLabel();
				lvm2.setIcon(vm2);
				lvm2.setBounds(580, 255, 180, 70);
				c.add(lvm2);
				
				
				 lvm3=new JLabel();
				lvm3.setIcon(vm3);
				lvm3.setBounds(580, 405, 180, 70);
				c.add(lvm3);
			
			ImageIcon d1 = new ImageIcon(this.getClass().getResource("Cloud Server.png"));
			JLabel d2 = new JLabel();
			d2.setIcon(d1);
			d2.setBounds(0, -35, 800, 600);
			c.add(d2);
			
			c.setBackground(Color.white);
			setSize(780,620);
			setVisible(true);
			
			int[] ports = new int[]{500,401,301,101,302,801,20141,3001,3002,6789,6699,200,10014,108,2014,402,442};
			for(int i=0;i<17;i++)
			{
				Thread th = new Thread(new portlistener(ports[i]));
				th.start();
			}
			
		}
		public class portlistener implements Runnable
		{
			int port;
			portlistener(int port)
			{
				this.port=port;
			}
			
			public void run()
			{
				
				
				if(this.port==401)
				{
					try
					{
						ServerSocket sc = new ServerSocket(401);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							
							String content = din.readUTF();
							String filename = (String)din.readUTF();
							String owner = (String)din.readUTF();
							String sk = (String)din.readUTF();
							String hash = (String)din.readUTF();
							String cloudname = (String)din.readUTF();
							int len=content.length();
							int cost=0;

							
							if (len > 0 && len < 2000) {
								cost = 100;
								
							}
							if (len > 2001 && len < 4000) {
								cost = 200;
								
							}
							if (len > 4001 && len < 6000) {
								cost = 300;
								
							}
							if (len > 6001 && len < 8000) {
								cost = 500;
								
							}

							if (len > 8001 && len < 10000) {
								cost = 700;
								
							}
							if (len > 10001 && len < 12000) {
								cost = 900;
								
							}
							if (len > 12001 && len < 14000) {
								cost = 1000;
								
							}
							if (len > 14001 && len < 16000) {
								cost = 1200;
								
							}
							if (len > 16001 && len < 18000) {
								cost = 1400;
								
							}
							if (len > 18001 && len < 40000000) {
								cost = 1600;
								
							}
							if (len > 40000001 && len < 45000000) {
								cost = 1800;
								
							}
							if (len > 45000001 && len < 50000000) {
								cost = 2000;
								
							}
							if (len > 50000000)  {
								cost = 2500;
								
							}
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();							
							
							data.setVisible(false);
							Thread.sleep(1000);
							data.setVisible(true);
							Thread.sleep(2000);
							data.setVisible(false);
							Thread.sleep(1000);
							data.setVisible(true);
							Thread.sleep(2000);
							data.setVisible(false);
							Thread.sleep(1000);
							data.setVisible(true);
							Thread.sleep(2000);
							
							
							ResultSet rs=stmt.executeQuery("select * from owner where name='"+owner+"' and cloudname='"+cloudname+"'");
							if(rs.next()==true)
							{

								int vm1=Integer.parseInt(rs.getString("vm1"));
								int vm2=Integer.parseInt(rs.getString("vm2"));
								int vm3=Integer.parseInt(rs.getString("vm3"));
								
								int tvm1=Integer.parseInt(rs.getString("tvm1"));
								int tvm2=Integer.parseInt(rs.getString("tvm2"));
								int tvm3=Integer.parseInt(rs.getString("tvm3"));
								
								int bw=Integer.parseInt(rs.getString("bw"));
								
								int v1=0,v2=0,v3=0;
								if(vm1>len)
								{
									v1=1;
								}
								if(vm2>len)
								{
									v2=1;
								}
								if(vm3>len)
								{
									v3=1;
								}
								
								
								if(v1==1&&v2==0&&v3==0)
								{
									//v1
									
									larrow1.setVisible(false);
									larrow1.setIcon(arrow1g);
									larrow1.setVisible(true);
									Thread.sleep(2000);
									
									lvm1.setVisible(false);
									lvm1.setIcon(vm1g);
									lvm1.setVisible(true);
									Thread.sleep(2000);
										
										tvm1=tvm1-1;
										vm1=vm1-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									
								}
								if(v1==0&&v2==1&&v3==0)
								{
									//v2
									larrow2.setVisible(false);
									larrow2.setIcon(arrow2g);
									larrow2.setVisible(true);
									Thread.sleep(2000);
									
									lvm2.setVisible(false);
									lvm2.setIcon(vm2g);
									lvm2.setVisible(true);
									Thread.sleep(2000);
									tvm2=tvm2-1;
									vm2=vm2-len;
									bw=bw-cost;
									Statement stmt1 = con.createStatement();
									String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
									stmt1.executeUpdate(sql1);
									
									
									
									String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
									stmt1.executeUpdate(sql11);
								
									String path = "CloudServer";
									 
									PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
									p.print(new String(content));
									
									DataOutputStream dout = new DataOutputStream(s.getOutputStream());
									dout.writeUTF("success");
								}
								if(v1==0&&v2==0&&v3==1)
								{
									//v3
									larrow3.setVisible(false);
									larrow3.setIcon(arrow3g);
									larrow3.setVisible(true);
									Thread.sleep(2000);
									
									lvm3.setVisible(false);
									lvm3.setIcon(vm3g);
									lvm3.setVisible(true);
									Thread.sleep(2000);
									tvm3=tvm3-1;
									vm3=vm3-len;
									bw=bw-cost;
									Statement stmt1 = con.createStatement();
									String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
									stmt1.executeUpdate(sql1);
									
									
									
									String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
									stmt1.executeUpdate(sql11);
								
									String path = "CloudServer";
									 
									PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
									p.print(new String(content));
									
									DataOutputStream dout = new DataOutputStream(s.getOutputStream());
									dout.writeUTF("success");
								}
								if(v1==0&&v2==1&&v3==1)
								{
									//v2 v3
									
									if(tvm2>=tvm1&&tvm2>=tvm3)
									{
										larrow2.setVisible(false);
										larrow2.setIcon(arrow2g);
										larrow2.setVisible(true);
										Thread.sleep(2000);
										
										lvm2.setVisible(false);
										lvm2.setIcon(vm2g);
										lvm2.setVisible(true);
										Thread.sleep(2000);
										tvm2=tvm2-1;
										vm2=vm2-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
									else if(tvm3>=tvm2&&tvm3>=tvm1)
									{
										larrow3.setVisible(false);
										larrow3.setIcon(arrow3g);
										larrow3.setVisible(true);
										Thread.sleep(2000);
										
										lvm3.setVisible(false);
										lvm3.setIcon(vm3g);
										lvm3.setVisible(true);
										Thread.sleep(2000);
										tvm3=tvm3-1;
										vm3=vm3-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
								}
								if(v1==1&&v2==0&&v3==1)
								{
									//v1 v3
									
									if(tvm1>=tvm2&&tvm1>=tvm3)
									{
										
										larrow1.setVisible(false);
										larrow1.setIcon(arrow1g);
										larrow1.setVisible(true);
										Thread.sleep(2000);
										
										lvm1.setVisible(false);
										lvm1.setIcon(vm1g);
										lvm1.setVisible(true);
										Thread.sleep(2000);
										
										tvm1=tvm1-1;
										vm1=vm1-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
									else if(tvm3>=tvm2&&tvm3>=tvm1)
									{
										larrow3.setVisible(false);
										larrow3.setIcon(arrow3g);
										larrow3.setVisible(true);
										Thread.sleep(2000);
										
										lvm3.setVisible(false);
										lvm3.setIcon(vm3g);
										lvm3.setVisible(true);
										Thread.sleep(2000);
										tvm3=tvm3-1;
										vm3=vm3-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
								}
								if(v1==1&&v2==1&&v3==0)
								{
									//v1 v2
									
									if(tvm1>=tvm2&&tvm1>=tvm3)
									{
										
										larrow1.setVisible(false);
										larrow1.setIcon(arrow1g);
										larrow1.setVisible(true);
										Thread.sleep(2000);
										
										lvm1.setVisible(false);
										lvm1.setIcon(vm1g);
										lvm1.setVisible(true);
										Thread.sleep(2000);
										
										tvm1=tvm1-1;
										vm1=vm1-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
									else if(tvm2>=tvm1&&tvm2>=tvm3)
									{
										larrow2.setVisible(false);
										larrow2.setIcon(arrow2g);
										larrow2.setVisible(true);
										Thread.sleep(2000);
										
										lvm2.setVisible(false);
										lvm2.setIcon(vm2g);
										lvm2.setVisible(true);
										Thread.sleep(2000);
										tvm2=tvm2-1;
										vm2=vm2-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
								}
								if(v1==1&&v2==1&&v3==1)
								{
									if(tvm1>=tvm2&&tvm1>=tvm3)
									{
										
										larrow1.setVisible(false);
										larrow1.setIcon(arrow1g);
										larrow1.setVisible(true);
										Thread.sleep(2000);
										
										lvm1.setVisible(false);
										lvm1.setIcon(vm1g);
										lvm1.setVisible(true);
										Thread.sleep(2000);
										
										tvm1=tvm1-1;
										vm1=vm1-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
									else if(tvm2>=tvm1&&tvm2>=tvm3)
									{
										larrow2.setVisible(false);
										larrow2.setIcon(arrow2g);
										larrow2.setVisible(true);
										Thread.sleep(2000);
										
										lvm2.setVisible(false);
										lvm2.setIcon(vm2g);
										lvm2.setVisible(true);
										Thread.sleep(2000);
										tvm2=tvm2-1;
										vm2=vm2-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
									else if(tvm3>=tvm2&&tvm3>=tvm1)
									{
										larrow3.setVisible(false);
										larrow3.setIcon(arrow3g);
										larrow3.setVisible(true);
										Thread.sleep(2000);
										
										lvm3.setVisible(false);
										lvm3.setIcon(vm3g);
										lvm3.setVisible(true);
										Thread.sleep(2000);
										tvm3=tvm3-1;
										vm3=vm3-len;
										bw=bw-cost;
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"','"+hash+"','"+cloudname+"')";
										stmt1.executeUpdate(sql1);
										
										
										
										String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+owner+"' and cloudname='"+cloudname+"' ";
										stmt1.executeUpdate(sql11);
									
										String path = "CloudServer";
										 
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									}
								}
								
								
								
								
							}
							
							Thread.sleep(4000);
							larrow1.setVisible(false);
							larrow1.setIcon(arrow1);
							larrow1.setVisible(true);
							
							
							lvm1.setVisible(false);
							lvm1.setIcon(vm1);
							lvm1.setVisible(true);
							
							
							larrow2.setVisible(false);
							larrow2.setIcon(arrow2);
							larrow2.setVisible(true);
							
							lvm2.setVisible(false);
							lvm2.setIcon(vm2);
							lvm2.setVisible(true);
							
							
							larrow3.setVisible(false);
							larrow3.setIcon(arrow3);
							larrow3.setVisible(true);
							
							
							lvm3.setVisible(false);
							lvm3.setIcon(vm3);
							lvm3.setVisible(true);
						
					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(this.port==200)
				{
					try
					{
						ServerSocket sc = new ServerSocket(200);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String username = din.readUTF();
							String cloudname = din.readUTF();
							
							System.out.println(username);
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from owner where name='"+username+"' and cloudname='"+cloudname+"'";
							ResultSet rs = stmt.executeQuery(sql);
							if(rs.next()==true)
							{
								System.out.println("success");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("Success");
							}
							else if(rs.next()==false)
							{
								System.out.println("failure");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
							}
							
							
							
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if (this.port == 2014) {
					try {

						ServerSocket server3 = new ServerSocket(2014);
						Socket con2;
						while (true) {
							con2 = server3.accept();
							DataInputStream dis11 = new DataInputStream(
									con2.getInputStream());

							String name = dis11.readUTF();
							String password = dis11.readUTF();
							String email = dis11.readUTF();
							String org = dis11.readUTF();
							String city = dis11.readUTF();
							
							
							
														
								DBCon db = new DBCon();
								Connection con = db.getConnection();
								Statement stmt = con.createStatement();
								
								ResultSet rs=stmt.executeQuery("select * from owner where name='"+name+"' and cloudname='CS1'");
								if(rs.next()==true)
								{
									
									String message = "update";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
								}
								else
								{
									String sql = "insert into owner values('"+name+"','"+password+"','"+email+"','"+org+"','"+city+"','NO','NO','NO','NO','NO','NO','NO','NO','NO','CS1')";
									stmt.executeUpdate(sql);
									String message = "success";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
								}
								
								
								 
							

						}
					}

					catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (this.port == 20141) {
					try {

						ServerSocket server3 = new ServerSocket(20141);
						Socket con2;
						while (true) {
							con2 = server3.accept();
							DataInputStream dis11 = new DataInputStream(
									con2.getInputStream());

							String name = dis11.readUTF();
							int memory =Integer.parseInt( dis11.readUTF());
							
							
							Calendar cal1 = Calendar.getInstance();
							
							
							Calendar cal = Calendar.getInstance();
							
							cal.add(Calendar.MONTH, Integer.parseInt("1"));
							
							
							SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
							String strDate = sdfDate.format(cal.getTime());
						      
						    String strDate1 = sdfDate.format(cal1.getTime());

								
								DBCon db = new DBCon();
								Connection con = db.getConnection();
								Statement stmt = con.createStatement();
								
								ResultSet rs=stmt.executeQuery("select * from owner where name='"+name+"' and vm1<>'NO' and vm2<>'NO' and vm3<>'NO' and cloudname='CS1'");
								if(rs.next()==true)
								{
									int vm1=Integer.parseInt(rs.getString("vm1"));
									int vm2=Integer.parseInt(rs.getString("vm2"));
									int vm3=Integer.parseInt(rs.getString("vm3"));
									
									int tvm1=Integer.parseInt(rs.getString("tvm1"));
									int tvm2=Integer.parseInt(rs.getString("tvm2"));
									int tvm3=Integer.parseInt(rs.getString("tvm3"));
									
									int bw=Integer.parseInt(rs.getString("bw"));
									
									vm1=memory+vm1;
									vm2=memory+vm2;
									vm3=memory+vm3;
									
									tvm1=18+tvm1;
									tvm2=18+tvm2;
									tvm3=18+tvm3;
									
									bw=memory+bw;
									
									String sql = "update owner set vm1='"+vm1+"',vm2='"+vm2+"',vm3='"+vm3+"',tvm1='"+tvm1+"',tvm2='"+tvm2+"',tvm3='"+tvm3+"',bw='"+bw+"',sd='"+strDate1+"', ed='"+strDate+"' where name='"+name+"' and cloudname='CS1' ";
									stmt.executeUpdate(sql);
									String message = "update";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
								}
								ResultSet rs1=stmt.executeQuery("select * from owner where name='"+name+"' and  vm1='NO' and vm2='NO' and vm3='NO' and cloudname='CS1'");
								if(rs1.next()==true)
								
								{
									
									
									
									String sql = "update owner set vm1='"+memory+"',vm2='"+memory+"',vm3='"+memory+"',tvm1='18',tvm2='18',tvm3='18',bw='"+memory+"',sd='"+strDate1+"', ed='"+strDate+"' where name='"+name+"' and cloudname='CS1' ";
									stmt.executeUpdate(sql);
									String message = "success";

									DataOutputStream os = new DataOutputStream(
											con2.getOutputStream());
									os.writeUTF(message);
								}
								
								
								 
							

						}
					}

					catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(this.port==302)
				{
					try
					{
						ServerSocket sc = new ServerSocket(302);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String msg = din.readUTF();
							if(msg.equalsIgnoreCase("check"))
							{
							String name = din.readUTF();
							String owner = din.readUTF();
							String ip = din.readUTF();
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							
							
							
							
								Statement block = con.createStatement();
								String blocksql = "select * from attacker where Attacker_name = '"+ name + "' and cloudname='CS1' ";
								ResultSet blockrs = block.executeQuery(blocksql);
								
								if (blockrs.next() == true) {
									System.out.println("in blocking");
									DataOutputStream ds = new DataOutputStream(s.getOutputStream());
									ds.writeUTF("block");
									
									
								}
								else if (blockrs.next() == false) {
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("success");	
								}
							
							
							
							}
							else if(msg.equalsIgnoreCase("download"))
							{
								
								String name = din.readUTF();
								String owner = din.readUTF();
								String filename = din.readUTF();
								String sk = din.readUTF();
								String ip = din.readUTF();
								
								DBCon db = new DBCon();
								Connection con = db.getConnection();
								Statement stmt = con.createStatement();
								String sql = "select * from cloudfiles where Owner='"+owner+"'and filename='"+filename+"' and sk='"+sk+"' and cloudname='CS1'";
								ResultSet rs = stmt.executeQuery(sql);
							
								
								if(rs.next()==true)
								{
									
									FileInputStream fin = new FileInputStream("CloudServer/"+filename);
									byte[] b = new byte[fin.available()];
									fin.read(b);
									
									String st = new String(b);
									
									DataOutputStream oout = new DataOutputStream(s.getOutputStream());
									System.out.println("success");
									oout.writeUTF("success");
									oout.writeUTF(st);
									
									}
									
								else if(rs.next()==false)
								{
									
									Statement stmt2 = con.createStatement();
									String sql2 = "insert into attacker values('attacker','"+name+"','"+filename+"','"+sk+"','"+ip+"','CS1')";
									 stmt2.executeUpdate(sql2);
									DataOutputStream oout = new DataOutputStream(s.getOutputStream());
									oout.writeUTF("failure");
									
								}
								
								}
								
								
								
								}
							}
						
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				if(this.port==301)
				{
					try
					{
						ServerSocket sc = new ServerSocket(301);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String op = din.readUTF();
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from cloudfiles";
							ResultSet rs = stmt.executeQuery(sql);
							/*ArrayList a1 = new ArrayList();
							ArrayList a2 = new ArrayList();*/
							
							String own = null;
							String file = null;
							
							
							
							while(rs.next()==true)
							{
								 own = rs.getString(1);
								 file = rs.getString(2);
								
								/*a1.add(own);
								a2.add(file);*/
							}
							
							DataOutputStream oout = new DataOutputStream(s.getOutputStream());
							oout.writeUTF(own);
							oout.writeUTF(file);
							
						}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
				}
				if(this.port==6699)
				{
					try
					{
						
						ServerSocket sc = new ServerSocket(6699);
						
						while(true)
						{
							
							Socket ss=sc.accept();
							DataInputStream din3 = new DataInputStream(ss.getInputStream());
							String name = din3.readUTF();
							String pass = din3.readUTF();
							
							DBCon db=new DBCon();
							Connection con=db.getConnection();
							Statement st=con.createStatement();
							String sql="select * from remote where RemoteUser='"+name+"' and Password='"+pass+"' and cloudname='CS1'";
							ResultSet rs=st.executeQuery(sql);
							
							if(rs.next()==true)
							{
								DataOutputStream don = new DataOutputStream(ss.getOutputStream());
								don.writeUTF("SUCCESS");
							}
							else
							{
								DataOutputStream don = new DataOutputStream(ss.getOutputStream());
								don.writeUTF("Failure");
							}
							
							
						}
					}catch(Exception es){System.out.println(es);}
				}
				if(this.port==6789)
				{
					try
					{
						
						ServerSocket sc = new ServerSocket(6789);
						
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String name = din.readUTF();
							String email = din.readUTF();
							String ph = din.readUTF();
							String comp = din.readUTF();
							String add = din.readUTF();
							String city = din.readUTF();
							int pw = din.readInt();
							String oname = din.readUTF();
							
							
							String pass=Integer.toString(pw);
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "insert into remote values('"+name+"','"+oname+"','"+email+"','"+ph+"','"+comp+"','"+add+"','"+city+"','"+pass+"','CS1')";
							stmt.executeUpdate(sql);
							
							
							DataOutputStream don = new DataOutputStream(s.getOutputStream());
							 don.writeUTF("SUCCESS");
							
							
						}
						
					}catch(Exception es ){System.out.println(es);}
				}
				if(this.port==500)
				{
					try
					{
						ServerSocket sc = new ServerSocket(500);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String username = din.readUTF();
							String password = din.readUTF();
							System.out.println(username);
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							String sql = "select * from owner where name='"+username+"' and pass='"+password+"' and cloudname='CS1'";
							ResultSet rs = stmt.executeQuery(sql);
							if(rs.next()==true)
							{
								System.out.println("success");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("Success");
							}
							else if(rs.next()==false)
							{
								System.out.println("failure");
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
							}
							
							
							
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				if(this.port==571)
				{
					try
					{
						ServerSocket sc = new ServerSocket(571);
						while(true)
						{
							Socket s = sc.accept();
							DataInputStream din = new DataInputStream(s.getInputStream());
							String content = din.readUTF();
							String filename = (String)din.readUTF();
							String owner = (String)din.readUTF();
							String sk = (String)din.readUTF();
							
						/*	lbdc.setVisible(false);
							lbdc.setIcon(gdc);
							lbdc.setVisible(true);
							Thread.sleep(2000);
							
							lbcsar.setVisible(false);
							lbcsar.setIcon(gcsar);
							lbcsar.setVisible(true);
							Thread.sleep(2000);
							
							
							lbcs.setVisible(false);
							lbcs.setIcon(gcs);
							lbcs.setVisible(true);
							Thread.sleep(2000);*/
							
							DBCon db = new DBCon();
							Connection con = db.getConnection();
							Statement stmt = con.createStatement();
							
										
										Statement stmt1 = con.createStatement();
										String sql1 = "insert into cloudfiles values('"+owner+"','"+filename+"','"+sk+"')";
										stmt1.executeUpdate(sql1);
										String path = "CloudServer/"+owner;
										new File("CloudServer/"+owner).mkdir();
										PrintStream p = new PrintStream(new FileOutputStream(path+"/"+filename));
										p.print(new String(content));
										
										
										
										
										DataOutputStream dout = new DataOutputStream(s.getOutputStream());
										dout.writeUTF("success");
									
										
										
										Thread.sleep(6000);
																		
									/*	lbcs.setVisible(false);
										lbcs.setIcon(bcs);
										lbcs.setVisible(true);
										Thread.sleep(2000);
										
										lbcsar.setVisible(false);
										lbcsar.setIcon(bcsar);
										lbcsar.setVisible(true);
										Thread.sleep(2000);
										
										lbdc.setVisible(false);
										lbdc.setIcon(bdc);
										lbdc.setVisible(true);
										Thread.sleep(2000);*/
										
										
							}
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
							
				}
						 
			}
		
		}
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==j3)
			{
				
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						Attackerdetails1 vm=new Attackerdetails1();
						vm.setSize(600,600);
						vm.setVisible(true);
					}
				});
				
				
				
			}
			if(e.getSource()==j1)
			{
				
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						CS1ViewUsersMemory vm=new CS1ViewUsersMemory();
						
						vm.setSize(800, 350);
						vm.setVisible(true);
					}
				});
				
				
				
			}
			if(e.getSource()==j2)
			{
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						Cloud1Files csf=new Cloud1Files();
						csf.setSize(600,600);      
						csf.setVisible(true);
					}
				});
			}
			
			
			
			
			
			
			
			
			
			if(e.getSource()==m4)
			{
				System.exit(0);
			}
			
			
			
			
			if(e.getSource()==m7)
			{
				String uname = JOptionPane.showInputDialog(null,
						"Enter username to be Unblock..!!");
				if(uname.isEmpty())
				{
					
					JOptionPane.showMessageDialog(null, "User Name cannot be null ");
					
				}
				else
				{
					
				
				try {
					DBCon db = new DBCon();
					 Connection con = db.getConnection();
					Statement st = con.createStatement();
					String sql = "delete from attacker where Attacker_name = '" + uname+"' and cloudname='CS1'";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "User Unblocked Successfully");

				} catch (Exception exx) {
					System.out.println(exx);
				}
				}
			}
			
			if(e.getSource()==m1)
			{
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						new Register();
					}
				});
			}
			
		
			
		}
		
		public static void main(String[] args) {
			
			try {
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					new CloudServer1();
				}
			});
		}
}

