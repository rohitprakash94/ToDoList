import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;



public class UpdateForm  implements ActionListener{
     

	public void draw( )
	{   
		// create Frame
		
		JFrame frm=new JFrame("Update  Status");
        JLabel lbl=new JLabel("   Status   ");
		JRadioButton rb1=new JRadioButton("Completed");
		JRadioButton rb2=new JRadioButton("Not Completed");
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		
		// add on frame
		frm.getContentPane().add(BorderLayout.NORTH,lbl);
		frm.getContentPane().add(BorderLayout.CENTER,rb1);
		frm.getContentPane().add(BorderLayout.SOUTH,rb2);
		
		// ButtonGroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);

		// properties of frame
		frm.setVisible(true);
		frm.setResizable(false);
		frm.setBounds(100,100,200,100);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			Statement st = AllTask.cn.createStatement();
			String query = "update  day_task set status ="+"'"+ae.getActionCommand()+"'"+" where task_date ="+"'"+TodayTask.dat+"'" +  " and task = " + "'"+ ExchangeData.tasked+"'" + " and priority = "+"'"+ExchangeData.priorited+"'"+ "and status = "+"'"+ExchangeData.statused+"'";
			st.executeUpdate(query);
			TodayTask tt = new TodayTask();
			tt.draw();
			//System.out.println(query);
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}

}