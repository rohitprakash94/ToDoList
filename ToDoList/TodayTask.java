import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import jsava.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;


public class TodayTask extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel menupnl;
	JTable tab;
	JScrollPane scrpnl;
	JButton New,Delete,Edit,Update,Back;
	public static String dat;
	
	
	public void draw() throws SQLException
	{
		// add panels on frame
		menupnl = new JPanel();
		tab = new JTable(10,4);
		scrpnl = new JScrollPane(tab);
		this.getContentPane().add(BorderLayout.NORTH,menupnl);
		menupnl.setBackground(Color.blue);
		MatteBorder bod = new  MatteBorder(5,5,5,5,Color.red);
		menupnl.setBorder(bod);
		
		// set property of table 
		tab.setBackground(Color.white);
		tab.setEnabled(false);
		
		// create button  and add on menu bar
		New = new JButton("New");
		menupnl.add(New);
		New.setBounds(20,100,25,25);
		New.setPreferredSize(new Dimension(100,50) );
		New.addActionListener(this);
		
		Delete = new JButton("Delete");
		menupnl.add(Delete);
		Delete.setBounds(20,300,25,25);
		Delete.setPreferredSize(new Dimension(100,50) );
		Delete.addActionListener(this);
		
		Edit = new JButton("Edit");
		menupnl.add(Edit);
		Edit.setBounds(20,500,25,25);
		Edit.setPreferredSize(new Dimension(100,50) );
		Edit.addActionListener(this);
		
		Update = new JButton("Update");
		menupnl.add(Update);
		Update.setBounds(20,700,25,25);
		Update.setPreferredSize(new Dimension(100,50) );
		Update.addActionListener(this);
		
		// back button
		Back = new JButton("Back");
		menupnl.add(Back);
		Back.setBounds(5,5,25,25);
		Back.setPreferredSize(new Dimension(100,50) );
		Back.addActionListener(this);
		
		// set property of frame
		this.setBackground(Color.white);
		this.setResizable(false);
		this.setTitle("MY To Do List");
		this.setBounds(0,0,1000,700);
		this.setVisible(true);
		// fetch data 
		String str="select task,priority,status from day_task where task_date = '"+dat+"'";
		Statement st = AllTask.cn.createStatement();
		ResultSet rs = st.executeQuery(str);
		String row[][];
		row = new String[50][3];
		int i=0;
		while(rs.next())
		{
			row[i][0]=rs.getString(1);
			row[i][1]=rs.getString(2);
			row[i++][2]=rs.getString(3);
		}
		String column[]={"task","priority","status"};
		tab = new JTable(row,column);
		scrpnl = new JScrollPane(tab);
		this.getContentPane().add(BorderLayout.CENTER,scrpnl);

	}
		
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("New"))
		{
			NewTask nt = new NewTask();
			nt.drow();
		}
		if(ae.getActionCommand().equals("Delete"))
		{
			DeleteTask dts = new DeleteTask();
			try {
				dts.draw();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ae.getActionCommand().equals("Edit"))
		{
			EditTask et = new EditTask();
			try {
				et.draw();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ae.getActionCommand().equals("Update"))
		{
			UpdateTask ut = new UpdateTask();
			try {
				ut.draw();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ae.getActionCommand().equals("Back"))
		{
			AllTask at = new AllTask();
			try {
				at.draw();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
