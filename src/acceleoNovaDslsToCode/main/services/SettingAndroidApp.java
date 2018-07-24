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
			
			//String cpy="xcopy /E /A E:\\an\\RHCS E:\\an\\dest";
			String cpy="xcopy /E /A E:\\AndroidDev\\RHCS E:\\an\\dest";
			Process p=Runtime.getRuntime().exec("cmd /c "+cpy);
			Thread.sleep(10000);
			//Process p=Runtime.getRuntime().exec("cmd /c \"start cd souvikdir && mkdir newdir\"");
			//Runtime.getRuntime().exec("cmd /c cd test2 && mkdir test4");
			//p=Runtime.getRuntime().exec("cmd /c cd mkdir newdir");
			//new Thread(new SyncPipe(p.getErrorStream(),System.err)).start();
			//new Thread(new SyncPipe(p.getInputStream(),System.out)).start();
			//File source=new File("E:\\workzone\\JavaPrograms\\GenerateAndroidApp\\gradle\\wrapper\\gradle-wrapper.properties");
			//File dest=new File("E:\\workzone\\JavaPrograms\\SkypeTest\\gradle\\wrapper\\gradle-wrapper.properties");
			//Files.copy(source.toPath(), dest.toPath());
			//FileUtils.copyFile(source, dest);
			//Runtime.getRuntime().exec("cmd /c copy /y E:\\workzone\\JavaPrograms\\GenerateAndroidApp\\gradle\\wrapper\\gradle-wrapper.properties E:\\workzone\\JavaPrograms\\SkypeDemo\\gradle\\wrapper");
			//Runtime.getRuntime().exec("cmd /c copy /y E:\\workzone\\JavaPrograms\\GenerateAndroidApp\\build.gradle E:\\workzone\\JavaPrograms\\SkypeDemo");
			//Runtime.getRuntime().exec("cmd /c cd E:\\an\\dest1 && gradlew assembleDebug");
			//Thread.sleep(10000);
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
			System.out.println("Here I am");
		}
		try
		{
			for(int j=0;j<i;j++)
			{
				Runtime.getRuntime().exec("cmd /c copy /y E:\\workzone\\JavaPrograms\\GenerateAndroidApp\\gradle\\wrapper\\gradle-wrapper.properties E:\\workzone\\JavaPrograms\\SkypeDemo1\\dest1\\gradle\\wrapper");
				Runtime.getRuntime().exec("cmd /c copy /y E:\\workzone\\JavaPrograms\\GenerateAndroidApp\\build.gradle E:\\workzone\\JavaPrograms\\SkypeDemo1\\dest1");
			}
		}
		catch(Exception e)
		{
			
		}
	}
}
