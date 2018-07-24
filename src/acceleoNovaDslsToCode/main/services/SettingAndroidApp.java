package acceleoNovaDslsToCode.main.services;
import java.io.*;
import java.nio.file.Files;
import java.util.StringTokenizer;
public class SettingAndroidApp 
{
	static String[]goals;
	static int i=0;
	public static void setApp()
	{
		try
		{
			
			
			String cpy="xcopy /E /A ..\\acceleoNovaDslsToCode\\AndroidDev\\RHCS ..\\acceleoNovaDslsToCode\\an\\dest";
			Process p=Runtime.getRuntime().exec("cmd /c "+cpy);
			Thread.sleep(10000);
			
			String l="";
			i=0;
			goals=new String[50];
			BufferedReader br=new BufferedReader(new FileReader("../acceleoNovaDslsToCode/target/usergoal.txt"));
			l=br.readLine();
			while(l!=null)
			{
				StringTokenizer st=new StringTokenizer(l);
				while(st.hasMoreTokens())
				{
					String goalButton=st.nextToken().trim();
					goals[i]=goalButton;
					i++;
				}
				
				l=br.readLine();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			for(int j=0;j<i;j++)
			{
				Runtime.getRuntime().exec("cmd /c copy /y ..\\acceleoNovaDslsToCode\\GenerateAndroidApp\\gradle\\wrapper\\gradle-wrapper.properties ..\\acceleoNovaDslsToCode\\dest1\\gradle\\wrapper");
				Runtime.getRuntime().exec("cmd /c copy /y ..\\acceleoNovaDslsToCode\\GenerateAndroidApp\\build.gradle ..\\acceleoNovaDslsToCode\\dest1");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
