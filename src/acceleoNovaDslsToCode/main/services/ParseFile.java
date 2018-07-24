package acceleoNovaDslsToCode.main.services;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.lang.reflect.Field;
import javax.swing.*;
public class ParseFile{
	public static String[]goals;
	public static int i;
	public static String sentence="";
	public static String disp="";
	public static String stmt="";
	public static String col="";
	public static JLabel lbl=null;
	public static JTextField tf;
	public static void processFile()
	{
		goals=new String[50];
		i=0;
		JFrame f=new JFrame();
		 //lbl=new JLabel("Sample Text");
		tf=new JTextField("Sample Text");
		f.setSize(700,500); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); 
		
		try
		{
			String l="";
			BufferedReader br=new BufferedReader(new FileReader("../acceleoNovaDslsToCode/target/usergoal.txt"));
			l=br.readLine();
			while(l!=null)
			{
				StringTokenizer st=new StringTokenizer(l);
				while(st.hasMoreTokens())
				{
					
					String goalButton=st.nextToken().trim();
					JButton jb=new JButton(goalButton);
					System.out.println(goalButton);
					goals[i]=goalButton;
					f.add(jb);
					jb.addActionListener(new ActionListener(){  
			            public void actionPerformed(ActionEvent e){  
			                    String s=e.getActionCommand();
			                    if(s.equals(goals[0]))
			                    	PrintSentence();
			                    if(s.equals(goals[1]))
			                    {
			                    	EnterSentence();
			                    }
			                    if(s.equals(goals[2]))
			                    {
			                    	ChooseDisplay();
			                    }
			                    if(s.contentEquals(goals[3]))
			                    {
			                    	CalculateLength();
			                    }
			                    
			            }  
			            });
					i++;
				}
				
				l=br.readLine();
			}
			
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		f.add(tf);
		f.setVisible(true);	
	}
public static void EnterSentence()
{
	/*try {
		BufferedReader br2=new BufferedReader(new FileReader("../acceleoRIsk/tar/userdependency.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	sentence=JOptionPane.showInputDialog("Enter a Sentence");
}
public static void PrintSentence()
{
	try {
		BufferedReader br2=new BufferedReader(new FileReader("../acceleoNovaDslsToCode/target/userdependency.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JOptionPane.showMessageDialog(null, "print sentence");
	if(sentence.equals(""))
	{
		JOptionPane.showMessageDialog(null, "please enter a sentence first");
		
	}
	else if(disp.equalsIgnoreCase("console"))
	{
		try {
		JOptionPane.showMessageDialog(null, sentence);
		//BufferedReader b=new BufferedReader(new FileReader("../acceleoNovaDslsToCode/target/softgoal.txt"));
		//col=b.readLine().trim();
		//System.out.println(col);
		tf.setText(sentence);
		/*if(col.equalsIgnoreCase("red"))
		lbl.setForeground(Color.red);
		if(col.equalsIgnoreCase("blue"))
			lbl.setForeground(Color.blue);
		if(col.equalsIgnoreCase("YELLOW"))
			lbl.setForeground(Color.yellow);*/
		writeText1();
		}catch(Exception e) {}
		
	}
	else if(disp.equalsIgnoreCase("file"))
	{
		JOptionPane.showMessageDialog(null, "The sentence "+sentence+" will be written in file");
		try
		{
			tf.setText(sentence);
			writeText1();
			FileWriter fw=new FileWriter("../acceleoNovaDslsToCode/target/printsentence.txt");
			fw.write(sentence);
			fw.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Please specify writing mode (Choose Display)");
		
	}
}
public static void ChooseDisplay()
{
	try {
		BufferedReader br2=new BufferedReader(new FileReader("../acceleoNovaDslsToCode/target/userdependency.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	disp=JOptionPane.showInputDialog("Choose Display option file or console");
}
public static void CalculateLength()
{
	String src="";
	String dest="";
	try {
		BufferedReader br2=new BufferedReader(new FileReader("../acceleoNovaDslsToCode/target/userdependency.txt"));
		String l=br2.readLine();
		while(l!=null)
		{
			StringTokenizer st=new StringTokenizer(l);
			while(st.hasMoreTokens())
			{
				 src=st.nextToken();
				 dest=st.nextToken();
				dest=st.nextToken();
				for(int j=0;j<i;j++)
				{
					if(dest.equals(goals[j]))
					{
						if(sentence.equals(""))
						{
							JOptionPane.showMessageDialog(null, "Please Enter a sentence first");
						}
						else
							JOptionPane.showMessageDialog(null, "Length of sentence is "+sentence.length());
					}
				}
				System.out.println("Dest "+dest);
			}
			 l=br2.readLine();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static void writeText1()
{
	BufferedReader br=null;
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
		
	
	br.close();
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
	}


	
}
}