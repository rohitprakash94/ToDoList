import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class DeleteTask extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnl;
	JScrollPane scrpnl;
	JTable tab;
	public void draw() throws SQLException
	{
		//fatch data in table
		String str="select task,priority,status from day_task where task_date = '"+TodayTask.dat+"'";
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
		
		pnl = new JPanel();
		this.getContentPane().add(BorderLayout.NORTH,pnl);
		pnl.setBackground(Color.BLUE);
		
		// set property of frame
		this.setBackground(Color.white);
		this.setResizable(false);
		this.setTitle("MY To Do List");
		this.setBounds(0,0,1000,700);
		this.setVisible(true);
		
		// selection of row
				final ListSelectionModel model= tab.getSelectionModel();
				model.addListSelectionListener(new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent arg0) {
						if(! model.isSelectionEmpty()){
							int row = model.getMinSelectionIndex();
							ExchangeData.tasked = (String) tab.getValueAt(row,0);
							ExchangeData.priorited = (String) tab.getValueAt(row,1);
							ExchangeData.statused = (String) tab.getValueAt(row,2);
							
							if(ExchangeData.tasked != null){
							
									//JOptionPane.showMessageDialog(null, "selected row"+row+" "+TodayTask.dat);
									DeleteForm df = new DeleteForm();
									try {
										df.draw();
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							}
						}
						
					}
				});
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
