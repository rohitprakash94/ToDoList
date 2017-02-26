import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;


public class NewTask  implements ActionListener
{   
	// create Frame,label,scrollpane and btns
	
	JFrame frm=new JFrame("Add Your Task");
	JPanel pnl=new JPanel();
    JLabel Tlbl=new JLabel("Task");	
    JLabel Plbl=new JLabel("Priority");

	JButton btn=new JButton("SAVE");
	
	JTextArea ta=new JTextArea(10,30);
	JRadioButton rb1=new JRadioButton("High");
	JRadioButton rb2=new JRadioButton("Low");



	public void drow( )
	{   
		System.out.println("task "+TodayTask.dat);
		System.out.print("cn= "+AllTask.cn);
		btn.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);

		// add on grid
		frm.setLayout(new GridLayout(5,4));
		frm.add(Tlbl);
		frm.add(ta);
		frm.add(Plbl);
		frm.add(pnl);
		
		frm.add(btn); 
		 
		// ButtonGroup
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		pnl.add(rb1);
		pnl.add(rb2);
		
		//content of tab

		// properties of frame
		frm.setVisible(true);
		frm.setResizable(false);
		frm.setBounds(100,100,400,400);
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        NewTask nt = new NewTask();
        nt.drow();
	}



	String pri;
	public void actionPerformed(ActionEvent ae) 
	{ 
		try{
			if(ae.getActionCommand().equals("SAVE")){
				Statement st = AllTask.cn.createStatement();
				String task  =ta.getText();
				String date = TodayTask.dat;
				String str = "insert into day_task (task_date,task,priority) values('"+date+"','"+task+"','"+pri+"')";
				st.executeUpdate(str);
				TodayTask tt =new TodayTask();
				tt.draw();
			}
			else{
				pri=ae.getActionCommand();
			}
		
	     }
	   catch(Exception e){}
		
	 }
}