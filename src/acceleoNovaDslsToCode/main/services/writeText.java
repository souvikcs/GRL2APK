package acceleoNovaDslsToCode.main.services;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
public class writeText
{
	public static BufferedReader br=null;
	public static void writeText1()
	{
		JFrame f=new JFrame("This is new Window");
		f.setSize(700,500); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); 
		//JLabel lbl=new JLabel("This is the test case");
		JTextField tf=new JTextField("This is the test case");
		try
		{
			br=new BufferedReader(new FileReader("contrast.txt"));
			String l=br.readLine().trim();
			String m=br.readLine().trim();
			
			if(l.equalsIgnoreCase("DTLB"))
			{
					//Color color;
		
		    		//Field field = Class.forName("java.awt.Color").getField("yellow");
		    		//color = (Color)field.get(null);
				//lbl.setForeground(Color.yellow);
				if(m.equalsIgnoreCase("ByMachine"))
				{
					tf.setForeground(Color.blue);
					tf.setBackground(Color.yellow);
				}
				else
				{
					String b=br.readLine().trim();
					Color color;
		
		    		Field field = Class.forName("java.awt.Color").getField(m);
		    		color = (Color)field.get(null);
		    		tf.setForeground(color);
		    		Field field1 = Class.forName("java.awt.Color").getField(b);
		    		color = (Color)field1.get(null);
		    		tf.setBackground(color);
				}
				
				//lbl.setBackground(Color.blue);
			}
			else
			{
				System.out.println(m);
				if(m.equalsIgnoreCase("ByMachine"))
				{
					tf.setForeground(Color.yellow);
					tf.setBackground(Color.blue);
				}
				else
				{
					Color color;
					String b=br.readLine().trim();
		    		Field field = Class.forName("java.awt.Color").getField(m);
		    		color = (Color)field.get(null);
		    		tf.setForeground(color);
		    		Field field1 = Class.forName("java.awt.Color").getField(b);
		    		color = (Color)field1.get(null);
		    		tf.setBackground(color);
				}
				
				
			}
			
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}


		f.add(tf);

		f.setVisible(true);
	}
}