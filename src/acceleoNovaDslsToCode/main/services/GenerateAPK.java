package acceleoNovaDslsToCode.main.services;
import java.io.*;
import java.nio.file.Files;
public class GenerateAPK
{
	public static void genAPP()
	{
		try 
		{
			Runtime.getRuntime().exec("cmd /c cd E:\\an\\dest && gradlew assembleDebug");
			Thread.sleep(1000);
			Runtime.getRuntime().exec("cmd /c cd E:\\an\\dest && gradlew assembleRelease");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
