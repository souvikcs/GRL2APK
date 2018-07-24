package acceleoNovaDslsToCode.main.services;
import acceleoNovaDslsToCode.main.services.ParseFile;
import java.awt.FlowLayout;
import java.io.*;
import java.util.*;

import javax.swing.ButtonGroup;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.*;
public class SoftGoalProcess
{
	public static BufferedReader br=null;
	public static FileWriter fw=null;
	public static JLabel lbl=null;
	public static String decompositionType="";
	public static JRadioButton r=null;
	public static ButtonGroup bg,bg1;;
	public static JButton btnfin,btnnext;
	public static String selection,selection2;
	public static int status;
	public static String decom="";
	public static JPanel pane;
	public static void processSoftGoal(String file)
	{
		JFrame f=new JFrame();
		pane=new JPanel(); 
		f.setSize(700,500); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); 
		bg=new ButtonGroup();
		bg1=new ButtonGroup();
		btnfin=new JButton("Finish");
		btnnext=new JButton("Next");
		try
		{
			br=new BufferedReader(new FileReader(file));
			String l=br.readLine();
			while(l!=null)
			{
				StringTokenizer st=new StringTokenizer(l);
				while(st.hasMoreTokens())
				{
					String type=st.nextToken();
					String value=st.nextToken();
					if(type.equals("SoftGoal:"))
					{
						lbl=new JLabel(value);
						f.add(lbl);
					}
					if(type.equals("SoftGoal_Decomposition:"))
					{
						decompositionType=new String(value);
					}
					if(type.equals("Decomposition:"))
					{
						if(decompositionType.equalsIgnoreCase("or"))
						{
							r=new JRadioButton("Text in "+value);
							r.setActionCommand(value);
							f.add(r);
							bg.add(r);
						}
					}
					if(type.equals("Op_SGoal:"))
					{
						decompositionType="";
					}
				}

				l=br.readLine();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		f.add(btnnext);
		f.add(btnfin);
		f.add(pane);
			btnfin.addActionListener(new ActionListener(){  
			            public void actionPerformed(ActionEvent e)
			            {  
			                 if (e.getActionCommand().equals("Finish")) 
			                 {
			                 		try{
			                 				String fore="",back="";
			                 				PrintWriter pw=new PrintWriter(new FileWriter("contrast.txt"));
			                 				selection=bg.getSelection().getActionCommand();
			                 				selection2=bg1.getSelection().getActionCommand();
			                 				pw.println(bg.getSelection().getActionCommand());
			                 				if(selection2.equalsIgnoreCase("ByChoice"))
			                 				{
			                 						 fore=JOptionPane.showInputDialog(null,"Enter Text Color");  
			                 						 back=JOptionPane.showInputDialog(null,"Enter Background Color"); 
			                 						 pw.println(fore);
			                 						 pw.println(back);   
			                 				}
			                 				if(selection2.equalsIgnoreCase("ByMachine"))
			                 				{
			                 					pw.println(selection2);
			                 				}
			                 				
			                 				
			                 				pw.close();
			                 				new ParseFile().processFile();
			                 		}
			                 		catch(Exception ex)
			                 		{
			                 			System.out.println(ex.toString());
			                 			JOptionPane.showMessageDialog(null,"Please Click Next and Select");  
			                 		}
            						//System.out.println("Selected Radio Button: " + bg.getSelection().getActionCommand());

        					} 

			                    
			            }  
			            });

			btnnext.addActionListener(new ActionListener(){  
			            public void actionPerformed(ActionEvent e)
			            {  
			                 if(e.getActionCommand().equals("Next"))
        					{
        						selection=bg.getSelection().getActionCommand();
        						//selection2=bg1.getSelection().getActionCommand();
        						System.out.println(selection);
        						//JButton btn=new JButton("Hello");
        						//f.add(btn);
        						//f.revalidate();
        						//validate();
        						try
        						{
        							br=new BufferedReader(new FileReader(file));
									String l=br.readLine();	
									while(l!=null)
									{
										StringTokenizer st=new StringTokenizer(l);
										while(st.hasMoreTokens())
										{
											String type=st.nextToken();
											String value=st.nextToken();
											if(type.equals("Op_SGoal:"))
											{
												status=0;
												decom="";
												if(value.equals(selection))
												{
													status=1;
												}
											}
											if((type.equals("Op_SGoal_Decomposition:"))&&(status==1))
											{
												decom=value;
												f.remove(pane);
													f.revalidate();
													pane=new JPanel();
											}
											if((type.equals("Decomposition:"))&& (status==1))
											{

												if(decom.equalsIgnoreCase("or"))
												{

													r=new JRadioButton(value);
													r.setActionCommand(value);
													pane.add(r);
													bg1.add(r);
													f.add(pane);
													f.revalidate();
												}
											}
										}
										l=br.readLine();	
									}

        						}
        						catch(Exception ex)
        						{
        							System.out.println(ex.toString());
        						}
        					}  

			                    
			            }  
			            });


		f.setVisible(true);
	}
	

	
}
	

