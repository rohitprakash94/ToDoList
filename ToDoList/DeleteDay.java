import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DeleteDay extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JPanel menu;
	JScrollPane body;
	JTable tab;
	JLabel date;
	
	public void draw() throws Exception
	{
		// add menu on frame
		menu = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH,menu);
		// add button on panel 
		date = new JLabel();
		menu.add(date);
		
		//set date 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dte = new Date();
		String str1 = (String)dateFormat.format(dte);
		date.setText(str1);
			
		//fatch data in table
		String str="select * from day";
		Statement st = AllTask.cn.createStatement();
		ResultSet rs = st.executeQuery(str);
		String row[][];
		row = new String[50][1];
		int i=0;
		while(rs.next())
		{
			row[i++][0]=rs.getString(1);
		}
		String column[]={"date"};
		tab = new JTable(row,column);
		
	//	tab.getRowSelectionAllowed();
		body = new JScrollPane(tab);
		this.getContentPane().add(BorderLayout.CENTER,body);
		
		// set frame properties
		this.setTitle("MY To Do List ");
		this.setBounds(0,0,500,400);
		this.setVisible(true);
		this.setResizable(false);
		
		// selection of row
		final ListSelectionModel model= tab.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent arg0) {
				if(! model.isSelectionEmpty()){
					int row = model.getMinSelectionIndex();
					TodayTask.dat=  (String) tab.getValueAt(row,0);
					if( TodayTask.dat != null){
						
						DeleteDayForm at = new DeleteDayForm();
						try {
							at.draw();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AllTask at = new AllTask();
		at.draw();
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("+")){
			NewDay nw =new NewDay();
			nw.draw();
		}
		else{
			
		}
	}
	
}
