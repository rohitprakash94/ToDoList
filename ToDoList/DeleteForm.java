import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class DeleteForm  implements ActionListener{
     
	 JLabel lbl;
	 JFrame frm;
	 JButton btn1,btn2;
	 JPanel pnl;
	public void draw( )
	{   
		// create Frame
		
		frm=new JFrame("Delete your Task");
        lbl=new JLabel("Are you sure ?");
        btn1 = new JButton("yes");
        btn1.addActionListener(this);
        btn2 = new JButton("no");
        btn2.addActionListener(this);
        pnl = new JPanel();
        pnl.add(btn2);
        pnl.add(btn1);

		
		// add on frame
		frm.getContentPane().add(BorderLayout.NORTH,lbl);
		frm.getContentPane().add(BorderLayout.CENTER,pnl);

		// properties of frame
		frm.setVisible(true);
		frm.setResizable(false);
		frm.setBounds(100,100,200,100);
		//frm.dispose();
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("yes")){
			try {
				Statement st = AllTask.cn.createStatement();
				String query = "delete from day_task where task_date ="+"'"+TodayTask.dat+"'" +  " and task = " + "'"+ ExchangeData.tasked+"'" + " and priority = "+"'"+ExchangeData.priorited+"'"+ "and status = "+"'"+ExchangeData.statused+"'";
				st.executeUpdate(query);
				TodayTask tt = new TodayTask();
				tt.draw();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
		
		}
		
	}

}