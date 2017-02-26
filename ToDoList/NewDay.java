import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class NewDay extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JButton bt = new JButton("ADD");
	JLabel jl = new JLabel();
	JTextField jtf = new JTextField();
	AllTask at =new AllTask();
	Connection cn = null;
	public void draw()
	{
		try
		{
			
			System.out.println("cn= "+AllTask.cn);
		}
		catch(Exception e)
		{
			
		}
		jl.setText("Date");
		bt.addActionListener(this);
		// set property of frame
		this.setBackground(Color.white);
		this.setResizable(false);
		this.setTitle("Add new ");
		this.setBounds(0,0,300,200);
		this.setVisible(true);
		this.setLayout(new GridLayout(3,1));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		// add component on frame
		this.add(jl);
		this.add(jtf);
		this.add(bt);
	}
	public static void main(String[] args) {
			NewDay nd = new NewDay();
			nd.draw();
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("ADD"))
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dte = new Date();
			String str1 = (String)dateFormat.format(dte);
			String date=jtf.getText();
			TodayTask.dat=date;
			if(str1.compareTo(TodayTask.dat) <= 0 ){
				try{
					Statement st = AllTask.cn.createStatement();
					String str = "insert into day values('"+date+"')";
					st.executeUpdate(str);
					TodayTask tt = new TodayTask();
					tt.draw();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						jtf.setText(null);
					}
			}
			else
			{
				jtf.setText("invalid Date ! \n please enter once again");
			}
		}
	}

}
