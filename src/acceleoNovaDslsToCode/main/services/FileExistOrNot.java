package acceleoNovaDslsToCode.main.services;

import java.io.File;
import java.nio.file.Paths;

import org.eclipse.core.runtime.Path;



public class FileExistOrNot {
	
		public boolean existsFile(String filepath) {
		   
		    File f = new File(filepath);
		    return f.exists();
		}
		
	
}
