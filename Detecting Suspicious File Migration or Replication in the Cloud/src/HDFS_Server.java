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
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;



public class HDFS_Server extends JFrame implements ActionListener {

	
	Container c;
	JButton j1,j2;
	JMenuBar mb;
	JMenu m;
	JMenuItem m1,m2,m3,m4,m6,m5,m7,m66;
	
	
	
	Font f1 = new Font("Times new Roman",Font.BOLD,18);
	Font f2 = new Font("Times new Roman",Font.BOLD,14);
	
	ImageIcon da = new ImageIcon(this.getClass().getResource("DataOwner Icon.jpg"));
	ImageIcon bcs1 = new ImageIcon(this.getClass().getResource("bcs1.png"));
	ImageIcon bcs2 = new ImageIcon(this.getClass().getResource("bcs2.png"));
	ImageIcon bcs3 = new ImageIcon(this.getClass().getResource("bcs3.png"));
	
	ImageIcon gcs1 = new ImageIcon(this.getClass().getResource("gcs1.png"));
	ImageIcon gcs2 = new ImageIcon(this.getClass().getResource("gcs2.png"));
	ImageIcon gcs3 = new ImageIcon(this.getClass().getResource("gcs3.png"));
	
	ImageIcon rcs1 = new ImageIcon(this.getClass().getResource("rcs1.png"));
	ImageIcon rcs2 = new ImageIcon(this.getClass().getResource("rcs2.png"));
	ImageIcon rcs3 = new ImageIcon(this.getClass().getResource("rcs3.png"));
	
	ImageIcon con = new ImageIcon(this.getClass().getResource("RISP Icon.jpg"));
	
	ImageIcon cloud1 = new ImageIcon(this.getClass().getResource("cloud1.jpg"));
	ImageIcon cloud2= new ImageIcon(this.getClass().getResource("Cloud2.jpg"));
	ImageIcon cloud3  = new ImageIcon(this.getClass().getResource("CS3.jpg"));
	
	ImageIcon block = new ImageIcon(this.getClass().getResource("blockar.png"));
	
	
	JLabel lda,lda1,lbcs1,lbcs2,lbcs3,lbcs11,lbcs12,lbcs13,ldoar1,ldoar2,lcon1,lcon2,lcl1,lcl2,lcl3,lcl11,lcl12,lcl13;
	JLabel l1,l2,l3,l4,l5,l11,l12,l13,l14,l15,lblock,lblock1,l6,l7;
	
	HDFS_Server()
	{
		setTitle("HDFS_Server::Detecting Suspicious File Migration or Replication in the Cloud");
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		setSize(780,590);
		setVisible(true);
		
		
		ImageIcon d1 = new ImageIcon(this.getClass().getResource("HDFS_Server.png"));
		JLabel d2 = new JLabel();
		d2.setIcon(d1);
		d2.setBounds(0, -35, 800, 600);
		
		lda=new JLabel();
		lda.setIcon(da);
		lda.setBounds(90, 170, 200, 200);
		c.add(lda);
		
		ldoar1=new JLabel();
		ldoar1.setIcon(bcs2);
		ldoar1.setBounds(190, 220, 150, 100);
		c.add(ldoar1);
		
		lcon1=new JLabel();
		lcon1.setIcon(con);
		lcon1.setBounds(310, 195, 150, 150);
		c.add(lcon1);
		
		lbcs1=new JLabel();
		lbcs1.setIcon(bcs1);
		lbcs1.setBounds(450, 160, 150, 100);
		c.add(lbcs1);
		
		lbcs2=new JLabel();
		lbcs2.setIcon(bcs2);
		lbcs2.setBounds(450, 220, 150, 100);
		c.add(lbcs2);
		
		lbcs3=new JLabel();
		lbcs3.setIcon(bcs3);
		lbcs3.setBounds(455, 280, 150, 100);
		c.add(lbcs3);
		
		lcl1=new JLabel();
		lcl1.setIcon(cloud1);
		lcl1.setBounds(580, 80, 150, 150);
		c.add(lcl1);
		
		lcl2=new JLabel();
		lcl2.setIcon(cloud2);
		lcl2.setBounds(580, 180, 150, 150);
		c.add(lcl2);
		
		lcl3=new JLabel();
		lcl3.setIcon(cloud3);
		lcl3.setBounds(580, 280, 150, 150);
		c.add(lcl3);
		
		l1=new JLabel("Data  Owner");
		l1.setFont(f2);
		l1.setForeground(Color.BLUE);
		l1.setBounds(90, 225, 200, 200);
		c.add(l1);
		
		l2=new JLabel("HDFS");
		l2.setFont(f2);
		l2.setForeground(Color.BLUE);
		l2.setBounds(360, 230, 200, 200);
		c.add(l2);
		
		l3=new JLabel("CS1");
		l3.setFont(f2);
		l3.setForeground(Color.BLUE);
		l3.setBounds(600, 100, 200, 200);
		c.add(l3);
		
		l4=new JLabel("CS2");
		l4.setFont(f2);
		l4.setForeground(Color.BLUE);
		l4.setBounds(600, 190, 200, 200);
		c.add(l4);
		
		l5=new JLabel("CS3");
		l5.setFont(f2);
		l5.setForeground(Color.BLUE);
		l5.setBounds(600, 300, 200, 200);
		c.add(l5);
		
		lblock=new JLabel();
		lblock.setIcon(block);
		lblock.setBounds(80, 120, 150, 150);
		c.add(lblock);
		
		l6=new JLabel("Duplicate File Found");
		l6.setFont(f2);
		l6.setForeground(Color.red);
		l6.setBounds(35, 150, 200, 200);
		c.add(l6);
		
		
		
		
		
		lblock1=new JLabel();
		lblock1.setIcon(block);
		lblock1.setBounds(80, 460, 150, 150);
		c.add(lblock1);
		
		
		l7=new JLabel("Owner Uploaded Duplicate File");
		l7.setFont(f2);
		l7.setForeground(Color.red);
		l7.setBounds(35, 490, 200, 200);
		c.add(l7);
		
		lblock.setVisible(false);
		l6.setVisible(false);
		lblock1.setVisible(false);
		l7.setVisible(false);
		c.add(d2);
		
		
		
		
		SimpleDateFormat sdfDate = new SimpleDateFormat(
				"dd/MM/yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat(
				"HH:mm:ss");

		Date now = new Date();

		String strDate = sdfDate.format(now);
		
		try
		{
		DBCon db = new DBCon();
		Connection con = db.getConnection();
		Statement stmt = con.createStatement();
		String sql = "select * from owner where ed='"+strDate+"' ";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()==true)
		{
			
			String sql1 = "update owner set tvm1='15',tvm2='15',tvm3='15' where ed='"+strDate+"' ";
			stmt.executeUpdate(sql1);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		int[] ports = new int[]{501,502,503,102,103,104,3000,3001,3002,6789,6699,9005,10014,110,2014,402,442,603};
		for(int i=0;i<18;i++)
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
			
			
			
			if(this.port==9005)
			{
				try
				{
					ServerSocket server1 = new ServerSocket(9005);
			        Socket regSocket;
					while (true) 
					{				
						regSocket = server1.accept();
						DataInputStream dis = new DataInputStream(regSocket.getInputStream());
						 String uname= dis.readUTF();
						 String dname= dis.readUTF();
						 
						 if(dname.equalsIgnoreCase("CS1"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs1.setVisible(false);
								lbcs1.setIcon(gcs1);
								lbcs1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
							 
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From cloudfiles where Owner='"+uname+"' and cloudname='"+dname+"' ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
								
								
						 }
						 if(dname.equalsIgnoreCase("CS2"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs2.setVisible(false);
								lbcs2.setIcon(gcs2);
								lbcs2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From cloudfiles where Owner='"+uname+"' and cloudname='"+dname+"' ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
						 }
						 if(dname.equalsIgnoreCase("CS3"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs3.setVisible(false);
								lbcs3.setIcon(gcs3);
								lbcs3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From cloudfiles where Owner='"+uname+"' and cloudname='"+dname+"' ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
						 }
					
					
					}
					
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}

}
			
			if(this.port==10014)
			{
				try
				{
					ServerSocket server1 = new ServerSocket(10014);
			        Socket regSocket;
					while (true) 
					{				
						regSocket = server1.accept();
						DataInputStream dis = new DataInputStream(regSocket.getInputStream());
						 String uname= dis.readUTF();
						 String dname= dis.readUTF();
						 
						 if(dname.equalsIgnoreCase("CS1"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs1.setVisible(false);
								lbcs1.setIcon(gcs1);
								lbcs1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
							 
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From owner where name='"+uname+"' and cloudname='"+dname+"' ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
								
								
						 }
						 if(dname.equalsIgnoreCase("CS2"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs2.setVisible(false);
								lbcs2.setIcon(gcs2);
								lbcs2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From owner where name='"+uname+"' and cloudname='"+dname+"' ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
						 }
						 if(dname.equalsIgnoreCase("CS3"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs3.setVisible(false);
								lbcs3.setIcon(gcs3);
								lbcs3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From owner where name='"+uname+"' and cloudname='"+dname+"' ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
						 }
					
					
					}
					
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}

}
			
			if(this.port==110)
			{
				try
				{
					ServerSocket server1 = new ServerSocket(110);
			        Socket regSocket;
					while (true) 
					{				
						regSocket = server1.accept();
						DataInputStream dis = new DataInputStream(regSocket.getInputStream());
						 String dname= dis.readUTF();
						 
						 if(dname.equalsIgnoreCase("CS1"))
						 {
							 
							    lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs1.setVisible(false);
								lbcs1.setIcon(gcs1);
								lbcs1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
							 
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From cost1 ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
								
								
						 }
						 if(dname.equalsIgnoreCase("CS2"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs2.setVisible(false);
								lbcs2.setIcon(gcs2);
								lbcs2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From cost2 ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
						 }
						 if(dname.equalsIgnoreCase("CS3"))
						 {
							 
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs3.setVisible(false);
								lbcs3.setIcon(gcs3);
								lbcs3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
							 Vector data = new Vector();
								
							 DBCon db = new DBCon();
								Connection con=db.getConnection();
								Statement stmt = con.createStatement();

								String query = "SELECT * From cost3 ";
								ResultSet rs = stmt.executeQuery(query);

								ResultSetMetaData rsm = rs.getMetaData();
								int col = rsm.getColumnCount();

								while (rs.next()) {
									Vector row = new Vector();
									for (int i = 1; i <= col; i++) {
										row.addElement(rs.getObject(i));

									}

									data.addElement(row);
								}
							 
						
						
								
								ObjectOutputStream dout=new ObjectOutputStream(regSocket.getOutputStream());
								
								dout.writeObject(data);
								Thread.sleep(3000);
								refresh();
						 }
					
					
					}
					
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}

}
			
			
			
			if(this.port==3000)
			{
				try
				{
					ServerSocket server1 = new ServerSocket(3000);
			        Socket regSocket;
					while (true) 
					{				
						regSocket = server1.accept();
						DataInputStream dis = new DataInputStream(regSocket.getInputStream());
						 String dname= dis.readUTF();
						 String uname= dis.readUTF();
						 int len= Integer.parseInt(dis.readUTF());
						 
						 
						 if(dname.equalsIgnoreCase("CS1"))
						 {
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs1.setVisible(false);
								lbcs1.setIcon(gcs1);
								lbcs1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
						 }
						 
						 if(dname.equalsIgnoreCase("CS2"))
						 {
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs2.setVisible(false);
								lbcs2.setIcon(gcs2);
								lbcs2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
						 }
						 
						 if(dname.equalsIgnoreCase("CS3"))
						 {
							 lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs3.setVisible(false);
								lbcs3.setIcon(gcs3);
								lbcs3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
						 }
						 
						 String v1="Not Available",v2="Not Available",v3="Not Available";
						 
						 DBCon db = new DBCon();
							Connection con=db.getConnection();
							Statement stmt = con.createStatement();
						  
							 ResultSet rs=stmt.executeQuery("select * from owner where name='"+uname+"' and cloudname='"+dname+"'");
								if(rs.next()==true)
								{
									int vm1=Integer.parseInt(rs.getString("vm1"));
									int vm2=Integer.parseInt(rs.getString("vm2"));
									int vm3=Integer.parseInt(rs.getString("vm3"));
									
									
									if(vm1>len)
									{
										v1="Available";
									}
									if(vm2>len)
									{
										v2="Available";
									}
									if(vm3>len)
									{
										v3="Available";
									}
									
									DataOutputStream dos = new DataOutputStream(regSocket.getOutputStream());
									
									dos.writeUTF("VM1 is->"+v1+", VM2 is->"+v2+", VM3 is->"+v3);
									
									Thread.sleep(3000);
									refresh();
								}
								else
								{
									DataOutputStream dos = new DataOutputStream(regSocket.getOutputStream());
									
									dos.writeUTF("You Dont Have VM in Cloud");
									Thread.sleep(3000);
									refresh();
								}
						
					}
					
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}

}
			
			if(this.port==603)
				
			{
				try
				{
					ServerSocket server1 = new ServerSocket(603);
	                Socket regSocket;
					while (true) 
					{				
						regSocket = server1.accept();
						DataInputStream dis = new DataInputStream(regSocket.getInputStream());
						 String dname= dis.readUTF();
						 String ocloud= dis.readUTF();
						 String mcloud= dis.readUTF();
						 String fname= dis.readUTF();
						 DBCon db = new DBCon();
						 Connection delete=db.getConnection();
						
						 Statement stmt=delete.createStatement();
						 Statement stmt1=delete.createStatement();
						 
						 
							String del="select * from cloudfiles where Owner='"+dname+"'  and filename='"+fname+"' and  cloudname='"+ocloud+"' ";
							Statement delst=delete.createStatement();
							ResultSet delrs = delst.executeQuery(del);
							
							String path = "";
							String path1 = "";
							
							if(ocloud.equalsIgnoreCase("CS1"))
							{
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs1.setVisible(false);
								lbcs1.setIcon(gcs1);
								lbcs1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
								lcl1.setVisible(false);
								Thread.sleep(1000);
								lcl1.setVisible(true);
								Thread.sleep(1000);
								
								
								path = "CloudServer";
							}
							if(ocloud.equalsIgnoreCase("CS2"))
							{
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs2.setVisible(false);
								lbcs2.setIcon(gcs2);
								lbcs2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
								lcl2.setVisible(false);
								Thread.sleep(1000);
								lcl2.setVisible(true);
								Thread.sleep(1000);
								
								path = "CloudServer2";
							}
							if(ocloud.equalsIgnoreCase("CS3"))
							{
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								ldoar1.setVisible(false);
								ldoar1.setIcon(gcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lbcs3.setVisible(false);
								lbcs3.setIcon(gcs3);
								lbcs3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
								lcl3.setVisible(false);
								Thread.sleep(1000);
								lcl3.setVisible(true);
								Thread.sleep(1000);
								
								path = "CloudServer3";
							}
							if(mcloud.equalsIgnoreCase("CS1"))
							{
								path1 = "CloudServer";
							}
							if(mcloud.equalsIgnoreCase("CS2"))
							{
								path1 = "CloudServer2";
							}
							if(mcloud.equalsIgnoreCase("CS3"))
							{
								path1 = "CloudServer3";
							}
							
							
							
							if(delrs.next())
							{
								
								FileInputStream fstream = new FileInputStream(path+"/"+fname);
							    byte[]	b = new byte[fstream.available()];
								fstream.read(b);
								String content = new String(b);
								fstream.close();
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
								
								
								
								 ResultSet rs=stmt.executeQuery("select * from owner where name='"+dname+"' and cloudname='"+mcloud+"'");
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
										
										if(mcloud.equalsIgnoreCase("CS1"))
										{
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lbcs1.setVisible(false);
											lbcs1.setIcon(gcs1);
											lbcs1.setVisible(true);
											Thread.sleep(1000);
											lcl1.setVisible(false);
											Thread.sleep(1000);
											lcl1.setVisible(true);
											Thread.sleep(1000);
											lcl1.setVisible(false);
											Thread.sleep(1000);
											lcl1.setVisible(true);
											Thread.sleep(1000);
										}
										if(mcloud.equalsIgnoreCase("CS2"))
										{
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lbcs2.setVisible(false);
											lbcs2.setIcon(gcs2);
											lbcs2.setVisible(true);
											Thread.sleep(1000);
											lcl2.setVisible(false);
											Thread.sleep(1000);
											lcl2.setVisible(true);
											Thread.sleep(1000);
											lcl2.setVisible(false);
											Thread.sleep(1000);
											lcl2.setVisible(true);
											Thread.sleep(1000);
										}
										if(mcloud.equalsIgnoreCase("CS3"))
										{
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lbcs3.setVisible(false);
											lbcs3.setIcon(gcs3);
											lbcs3.setVisible(true);
											Thread.sleep(1000);
											lcl3.setVisible(false);
											Thread.sleep(1000);
											lcl3.setVisible(true);
											Thread.sleep(1000);
											lcl3.setVisible(false);
											Thread.sleep(1000);
											lcl3.setVisible(true);
											Thread.sleep(1000);
										}
										
										
										
										if(v1==1&&v2==0&&v3==0)
										{
											//v1
											
											
												
												tvm1=tvm1-1;
												vm1=vm1-len;
												bw=bw-cost;
												
												
												
												String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											
										}
										if(v1==0&&v2==1&&v3==0)
										{
											//v2
											
											tvm2=tvm2-1;
											vm2=vm2-len;
											bw=bw-cost;
											
											
											
											
											String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
											stmt1.executeUpdate(sql11);
										
											PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
											p.print(new String(content));
											p.close();
											
											File file1 = new File(path+"/"+fname);
							            	file1.delete();
											
											Statement delst1=delete.createStatement();
											delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
											
											DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
											
											dout.writeUTF("All Files are Migrated to "+mcloud);
										}
										if(v1==0&&v2==0&&v3==1)
										{
											//v3
											
											tvm3=tvm3-1;
											vm3=vm3-len;
											bw=bw-cost;
											
											
											
											
											String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
											stmt1.executeUpdate(sql11);
										
											PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
											p.print(new String(content));
											p.close();
											
											File file1 = new File(path+"/"+fname);
							            	file1.delete();
											
											Statement delst1=delete.createStatement();
											delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
											
											DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
											
											dout.writeUTF("All Files are Migrated to "+mcloud);
										}
										if(v1==0&&v2==1&&v3==1)
										{
											//v2 v3
											
											if(tvm2>=tvm1&&tvm2>=tvm3)
											{
												
												tvm2=tvm2-1;
												vm2=vm2-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
											else if(tvm3>=tvm2&&tvm3>=tvm1)
											{
												
												tvm3=tvm3-1;
												vm3=vm3-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
										}
										if(v1==1&&v2==0&&v3==1)
										{
											//v1 v3
											
											if(tvm1>=tvm2&&tvm1>=tvm3)
											{
												
												
												
												tvm1=tvm1-1;
												vm1=vm1-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"' where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
											else if(tvm3>=tvm2&&tvm3>=tvm1)
											{
												
												tvm3=tvm3-1;
												vm3=vm3-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
										}
										if(v1==1&&v2==1&&v3==0)
										{
											//v1 v2
											
											if(tvm1>=tvm2&&tvm1>=tvm3)
											{
												
												
												
												tvm1=tvm1-1;
												vm1=vm1-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
											else if(tvm2>=tvm1&&tvm2>=tvm3)
											{
												
												tvm2=tvm2-1;
												vm2=vm2-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
										}
										if(v1==1&&v2==1&&v3==1)
										{
											if(tvm1>=tvm2&&tvm1>=tvm3)
											{
												
												
												
												tvm1=tvm1-1;
												vm1=vm1-len;
												bw=bw-cost;
																				
												
												
												String sql11 = "update owner set vm1='"+vm1+"',tvm1='"+tvm1+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
											else if(tvm2>=tvm1&&tvm2>=tvm3)
											{
												
												tvm2=tvm2-1;
												vm2=vm2-len;
												bw=bw-cost;
												
												
												
												
												String sql11 = "update owner set vm2='"+vm2+"',tvm2='"+tvm2+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
											else if(tvm3>=tvm2&&tvm3>=tvm1)
											{
												
												tvm3=tvm3-1;
												vm3=vm3-len;
												bw=bw-cost;
																						
												
												
												String sql11 = "update owner set vm3='"+vm3+"',tvm3='"+tvm3+"',bw='"+bw+"'  where name='"+dname+"' and cloudname='"+mcloud+"' ";
												stmt1.executeUpdate(sql11);
											
												PrintStream p = new PrintStream(new FileOutputStream(path1+"/"+fname));
												p.print(new String(content));
												p.close();
												
												File file1 = new File(path+"/"+fname);
								            	file1.delete();
												
												Statement delst1=delete.createStatement();
												delst1.executeUpdate("update cloudfiles set cloudname='"+mcloud+"' where filename='"+fname+"' and Owner='"+dname+"' ");
												
												DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
												
												dout.writeUTF("All Files are Migrated to "+mcloud);
											}
										}
										if(v1==0&&v2==0&&v3==0)
										{
											
											if(mcloud.equalsIgnoreCase("CS1"))
											{
																						
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												
												
												lbcs1.setVisible(false);
												lbcs1.setIcon(gcs1);
												lbcs1.setVisible(true);
												Thread.sleep(1000);
												
												lcl1.setVisible(false);
												Thread.sleep(1000);
												lcl1.setVisible(true);
												Thread.sleep(1000);
												lcl1.setVisible(false);
												Thread.sleep(1000);
												lcl1.setVisible(true);
												Thread.sleep(1000);
												
												lbcs1.setVisible(false);
												lbcs1.setIcon(rcs1);
												lbcs1.setVisible(true);
												Thread.sleep(1000);
												
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												
												ldoar1.setVisible(false);
												ldoar1.setIcon(rcs2);
												ldoar1.setVisible(true);
												Thread.sleep(1000);
												
												lda.setVisible(false);
												Thread.sleep(1000);
												lda.setVisible(true);
												Thread.sleep(1000);
												lda.setVisible(false);
												Thread.sleep(1000);
												lda.setVisible(true);
												Thread.sleep(1000);
											}
											if(mcloud.equalsIgnoreCase("CS2"))
											{
												
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											
											
											lbcs2.setVisible(false);
											lbcs2.setIcon(gcs2);
											lbcs2.setVisible(true);
											Thread.sleep(1000);
											
											lcl2.setVisible(false);
											Thread.sleep(1000);
											lcl2.setVisible(true);
											Thread.sleep(1000);
											lcl2.setVisible(false);
											Thread.sleep(1000);
											lcl2.setVisible(true);
											Thread.sleep(1000);
											
											lbcs2.setVisible(false);
											lbcs2.setIcon(rcs2);
											lbcs2.setVisible(true);
											Thread.sleep(1000);
											
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											
											ldoar1.setVisible(false);
											ldoar1.setIcon(rcs2);
											ldoar1.setVisible(true);
											Thread.sleep(1000);
											
											lda.setVisible(false);
											Thread.sleep(1000);
											lda.setVisible(true);
											Thread.sleep(1000);
											lda.setVisible(false);
											Thread.sleep(1000);
											lda.setVisible(true);
											Thread.sleep(1000);
											}
											if(mcloud.equalsIgnoreCase("CS3"))
											{
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												
												
												lbcs3.setVisible(false);
												lbcs3.setIcon(gcs3);
												lbcs3.setVisible(true);
												Thread.sleep(1000);
												
												lcl3.setVisible(false);
												Thread.sleep(1000);
												lcl3.setVisible(true);
												Thread.sleep(1000);
												lcl3.setVisible(false);
												Thread.sleep(1000);
												lcl3.setVisible(true);
												Thread.sleep(1000);
												
												lbcs3.setVisible(false);
												lbcs3.setIcon(rcs3);
												lbcs3.setVisible(true);
												Thread.sleep(1000);
												
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												lcon1.setVisible(false);
												Thread.sleep(1000);
												lcon1.setVisible(true);
												Thread.sleep(1000);
												
												ldoar1.setVisible(false);
												ldoar1.setIcon(rcs2);
												ldoar1.setVisible(true);
												Thread.sleep(1000);
												
												lda.setVisible(false);
												Thread.sleep(1000);
												lda.setVisible(true);
												Thread.sleep(1000);
												lda.setVisible(false);
												Thread.sleep(1000);
												lda.setVisible(true);
												Thread.sleep(1000);
											}
											
											DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
											
											dout.writeUTF("Required Memory is not Available in Cloud"+mcloud);
											
											Thread.sleep(2000);
											refresh();
										}
										Thread.sleep(2000);
										refresh();
										
									}
									else
									{
										
										if(mcloud.equalsIgnoreCase("CS1"))
										{
																					
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											
											
											lbcs1.setVisible(false);
											lbcs1.setIcon(gcs1);
											lbcs1.setVisible(true);
											Thread.sleep(1000);
											
											lcl1.setVisible(false);
											Thread.sleep(1000);
											lcl1.setVisible(true);
											Thread.sleep(1000);
											lcl1.setVisible(false);
											Thread.sleep(1000);
											lcl1.setVisible(true);
											Thread.sleep(1000);
											
											lbcs1.setVisible(false);
											lbcs1.setIcon(rcs1);
											lbcs1.setVisible(true);
											Thread.sleep(1000);
											
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											
											ldoar1.setVisible(false);
											ldoar1.setIcon(rcs2);
											ldoar1.setVisible(true);
											Thread.sleep(1000);
											
											lda.setVisible(false);
											Thread.sleep(1000);
											lda.setVisible(true);
											Thread.sleep(1000);
											lda.setVisible(false);
											Thread.sleep(1000);
											lda.setVisible(true);
											Thread.sleep(1000);
										}
										if(mcloud.equalsIgnoreCase("CS2"))
										{
											
										lcon1.setVisible(false);
										Thread.sleep(1000);
										lcon1.setVisible(true);
										Thread.sleep(1000);
										lcon1.setVisible(false);
										Thread.sleep(1000);
										lcon1.setVisible(true);
										Thread.sleep(1000);
										
										
										lbcs2.setVisible(false);
										lbcs2.setIcon(gcs2);
										lbcs2.setVisible(true);
										Thread.sleep(1000);
										
										lcl2.setVisible(false);
										Thread.sleep(1000);
										lcl2.setVisible(true);
										Thread.sleep(1000);
										lcl2.setVisible(false);
										Thread.sleep(1000);
										lcl2.setVisible(true);
										Thread.sleep(1000);
										
										lbcs2.setVisible(false);
										lbcs2.setIcon(rcs2);
										lbcs2.setVisible(true);
										Thread.sleep(1000);
										
										lcon1.setVisible(false);
										Thread.sleep(1000);
										lcon1.setVisible(true);
										Thread.sleep(1000);
										lcon1.setVisible(false);
										Thread.sleep(1000);
										lcon1.setVisible(true);
										Thread.sleep(1000);
										
										ldoar1.setVisible(false);
										ldoar1.setIcon(rcs2);
										ldoar1.setVisible(true);
										Thread.sleep(1000);
										
										lda.setVisible(false);
										Thread.sleep(1000);
										lda.setVisible(true);
										Thread.sleep(1000);
										lda.setVisible(false);
										Thread.sleep(1000);
										lda.setVisible(true);
										Thread.sleep(1000);
										}
										if(mcloud.equalsIgnoreCase("CS3"))
										{
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											
											
											lbcs3.setVisible(false);
											lbcs3.setIcon(gcs3);
											lbcs3.setVisible(true);
											Thread.sleep(1000);
											
											lcl3.setVisible(false);
											Thread.sleep(1000);
											lcl3.setVisible(true);
											Thread.sleep(1000);
											lcl3.setVisible(false);
											Thread.sleep(1000);
											lcl3.setVisible(true);
											Thread.sleep(1000);
											
											lbcs3.setVisible(false);
											lbcs3.setIcon(rcs3);
											lbcs3.setVisible(true);
											Thread.sleep(1000);
											
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											lcon1.setVisible(false);
											Thread.sleep(1000);
											lcon1.setVisible(true);
											Thread.sleep(1000);
											
											ldoar1.setVisible(false);
											ldoar1.setIcon(rcs2);
											ldoar1.setVisible(true);
											Thread.sleep(1000);
											
											lda.setVisible(false);
											Thread.sleep(1000);
											lda.setVisible(true);
											Thread.sleep(1000);
											lda.setVisible(false);
											Thread.sleep(1000);
											lda.setVisible(true);
											Thread.sleep(1000);
										}
										
										DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
										
										dout.writeUTF("User not Found in Cloud "+mcloud);
										Thread.sleep(2000);
										refresh();
									}
								
								
							}
							else
							{
								
								
								if(ocloud.equalsIgnoreCase("CS1"))
								{
									lbcs1.setVisible(false);
									lbcs1.setIcon(rcs1);
									lbcs1.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
								}
								if(ocloud.equalsIgnoreCase("CS2"))
								{
									lbcs2.setVisible(false);
									lbcs2.setIcon(rcs2);
									lbcs2.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
								}
								if(ocloud.equalsIgnoreCase("CS3"))
								{
									lbcs3.setVisible(false);
									lbcs3.setIcon(rcs3);
									lbcs3.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
								}
								
								
								DataOutputStream dout=new DataOutputStream(regSocket.getOutputStream());
								
								dout.writeUTF("File not Found in Cloud "+ocloud);
								Thread.sleep(2000);
								refresh();
							}
					
					}
					
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}

}					
			if (this.port == 104) {}
			if (this.port == 103) {}
			if (this.port == 102) {}
			if(this.port==501)
			{
				try
				{
					ServerSocket sc = new ServerSocket(501);
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
						
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						Statement stmt = con.createStatement();
						
						
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							ldoar1.setVisible(false);
							ldoar1.setIcon(gcs2);
							ldoar1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lbcs1.setVisible(false);
							lbcs1.setIcon(gcs1);
							lbcs1.setVisible(true);
							Thread.sleep(1000);
							lcl1.setVisible(false);
							Thread.sleep(1000);
							lcl1.setVisible(true);
							Thread.sleep(1000);
							lcl1.setVisible(false);
							Thread.sleep(1000);
							lcl1.setVisible(true);
							Thread.sleep(1000);
						
							
							
							 ResultSet rs=stmt.executeQuery("select * from owner where name='"+owner+"' and cloudname='"+cloudname+"' ");
								if(rs.next()==true)
								{
									int vm1=Integer.parseInt(rs.getString("vm1"));
									int vm2=Integer.parseInt(rs.getString("vm2"));
									int vm3=Integer.parseInt(rs.getString("vm3"));
									
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
						
							if(v1==0&&v2==0&&v3==0)
							{
								
								lbcs1.setVisible(false);
								lbcs1.setIcon(rcs1);
								lbcs1.setVisible(true);
								Thread.sleep(1000);
								
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								
								ldoar1.setVisible(false);
								ldoar1.setIcon(rcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
								
								Thread.sleep(3000);
								refresh();
							}
							else
							{
								Socket sc1 = new Socket("localhost",401);
								 DataOutputStream dout = new DataOutputStream(sc1.getOutputStream());
								 
								 dout.writeUTF(content);
								 dout.writeUTF(filename);
								 dout.writeUTF(owner);
								 dout.writeUTF(sk);
								 dout.writeUTF(hash);
								 dout.writeUTF(cloudname);
							
								 DataInputStream din1 = new DataInputStream(sc1.getInputStream());
								 String msg = din1.readUTF();
								 if(msg.equalsIgnoreCase("success"))
								 {
							
							DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
							dout1.writeUTF("success");
							Thread.sleep(3000);
							refresh();

								 }
							}
							
							
							
						}
								else
								{
									lbcs1.setVisible(false);
									lbcs1.setIcon(rcs1);
									lbcs1.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									
									DataOutputStream dout = new DataOutputStream(s.getOutputStream());
									dout.writeUTF("block");
									
									Thread.sleep(3000);
									refresh();
								}
				
					}
				}
				
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(this.port==502)
			{
				try
				{
					ServerSocket sc = new ServerSocket(502);
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
						
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						Statement stmt = con.createStatement();
						
						
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							ldoar1.setVisible(false);
							ldoar1.setIcon(gcs2);
							ldoar1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lbcs2.setVisible(false);
							lbcs2.setIcon(gcs2);
							lbcs2.setVisible(true);
							Thread.sleep(1000);
							lcl2.setVisible(false);
							Thread.sleep(1000);
							lcl2.setVisible(true);
							Thread.sleep(1000);
							lcl2.setVisible(false);
							Thread.sleep(1000);
							lcl2.setVisible(true);
							Thread.sleep(1000);
						
							
							
							 ResultSet rs=stmt.executeQuery("select * from owner where name='"+owner+"' and cloudname='"+cloudname+"'");
								if(rs.next()==true)
								{
									int vm1=Integer.parseInt(rs.getString("vm1"));
									int vm2=Integer.parseInt(rs.getString("vm2"));
									int vm3=Integer.parseInt(rs.getString("vm3"));
									
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
						
							if(v1==0&&v2==0&&v3==0)
							{
								
								lbcs2.setVisible(false);
								lbcs2.setIcon(rcs2);
								lbcs2.setVisible(true);
								Thread.sleep(1000);
								
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								
								ldoar1.setVisible(false);
								ldoar1.setIcon(rcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
								
								Thread.sleep(3000);
								refresh();
							}
							else
							{
								Socket sc1 = new Socket("localhost",402);
								 DataOutputStream dout = new DataOutputStream(sc1.getOutputStream());
								 
								 dout.writeUTF(content);
								 dout.writeUTF(filename);
								 dout.writeUTF(owner);
								 dout.writeUTF(sk);
								 dout.writeUTF(hash);
								 dout.writeUTF(cloudname);
							
								 DataInputStream din1 = new DataInputStream(sc1.getInputStream());
								 String msg = din1.readUTF();
								 if(msg.equalsIgnoreCase("success"))
								 {
							
							DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
							dout1.writeUTF("success");
							Thread.sleep(3000);
							refresh();

								 }
							}
							
							
							
						}
								else
								{
									lbcs2.setVisible(false);
									lbcs2.setIcon(rcs2);
									lbcs2.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									
									DataOutputStream dout = new DataOutputStream(s.getOutputStream());
									dout.writeUTF("block");
									
									Thread.sleep(3000);
									refresh();
								}
				
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(this.port==503)
			{
				try
				{
					ServerSocket sc = new ServerSocket(503);
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
						
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						Statement stmt = con.createStatement();
						
						
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							lda.setVisible(false);
							Thread.sleep(1000);
							lda.setVisible(true);
							Thread.sleep(1000);
							ldoar1.setVisible(false);
							ldoar1.setIcon(gcs2);
							ldoar1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lcon1.setVisible(false);
							Thread.sleep(1000);
							lcon1.setVisible(true);
							Thread.sleep(1000);
							lbcs3.setVisible(false);
							lbcs3.setIcon(gcs3);
							lbcs3.setVisible(true);
							Thread.sleep(1000);
							lcl3.setVisible(false);
							Thread.sleep(1000);
							lcl3.setVisible(true);
							Thread.sleep(1000);
							lcl3.setVisible(false);
							Thread.sleep(1000);
							lcl3.setVisible(true);
							Thread.sleep(1000);
						
						
							
							 ResultSet rs=stmt.executeQuery("select * from owner where name='"+owner+"' and cloudname='"+cloudname+"'");
								if(rs.next()==true)
								{
									int vm1=Integer.parseInt(rs.getString("vm1"));
									int vm2=Integer.parseInt(rs.getString("vm2"));
									int vm3=Integer.parseInt(rs.getString("vm3"));
									
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
						
							if(v1==0&&v2==0&&v3==0)
							{
								
								lbcs3.setVisible(false);
								lbcs3.setIcon(rcs3);
								lbcs3.setVisible(true);
								Thread.sleep(1000);
								
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								lcon1.setVisible(false);
								Thread.sleep(1000);
								lcon1.setVisible(true);
								Thread.sleep(1000);
								
								ldoar1.setVisible(false);
								ldoar1.setIcon(rcs2);
								ldoar1.setVisible(true);
								Thread.sleep(1000);
								
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								lda.setVisible(false);
								Thread.sleep(1000);
								lda.setVisible(true);
								Thread.sleep(1000);
								
								DataOutputStream dout = new DataOutputStream(s.getOutputStream());
								dout.writeUTF("failure");
								
								Thread.sleep(3000);
								refresh();
							}
							else
							{
								Socket sc1 = new Socket("localhost",403);
								 DataOutputStream dout = new DataOutputStream(sc1.getOutputStream());
								 
								 dout.writeUTF(content);
								 dout.writeUTF(filename);
								 dout.writeUTF(owner);
								 dout.writeUTF(sk);
								 dout.writeUTF(hash);
								 dout.writeUTF(cloudname);
							
								 DataInputStream din1 = new DataInputStream(sc1.getInputStream());
								 String msg = din1.readUTF();
								 if(msg.equalsIgnoreCase("success"))
								 {
							
							DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
							dout1.writeUTF("success");
							Thread.sleep(3000);
							refresh();

								 }
							}
							
							
							
						}
								else
								{
									lbcs3.setVisible(false);
									lbcs3.setIcon(rcs3);
									lbcs3.setVisible(true);
									Thread.sleep(1000);
									
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									lcon1.setVisible(false);
									Thread.sleep(1000);
									lcon1.setVisible(true);
									Thread.sleep(1000);
									
									ldoar1.setVisible(false);
									ldoar1.setIcon(rcs2);
									ldoar1.setVisible(true);
									Thread.sleep(1000);
									
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									lda.setVisible(false);
									Thread.sleep(1000);
									lda.setVisible(true);
									Thread.sleep(1000);
									
									DataOutputStream dout = new DataOutputStream(s.getOutputStream());
									dout.writeUTF("block");
									
									Thread.sleep(3000);
									refresh();
								}
				
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void refresh()
	{
		
		try
		{
		
			
			lbcs1.setVisible(false);
			lbcs1.setIcon(bcs1);
			lbcs1.setVisible(true);
			
			lbcs2.setVisible(false);
			lbcs2.setIcon(bcs2);
			lbcs2.setVisible(true);
			
			lbcs3.setVisible(false);
			lbcs3.setIcon(bcs3);
			lbcs3.setVisible(true);
			
					
			ldoar1.setVisible(false);
			ldoar1.setIcon(bcs2);
			ldoar1.setVisible(true);
			
			
			
		}
	
	catch(Exception e1)
	{
		e1.printStackTrace();
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
			new HDFS_Server();
		}
	});
}
}