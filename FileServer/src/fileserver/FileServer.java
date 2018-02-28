package fileserver;
import interfaces.FsLocalInterface;
import interfaces.FsRemoteInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
 
/**
 * @authors { 
 * Sri chakra Goud Koppula
 * Anuj Jain
 * Niraj Agarwal
 * }
 */ 

public class FileServer extends UnicastRemoteObject implements FsLocalInterface {
	
	private String file="";
        private String filesDirectory = "downloads/";
	public FileServer() throws RemoteException {
		super();
	}
        
	public String handshake() throws RemoteException{
		return "success";
	}
	
        public ArrayList listFiles(){
            File rootDirectory = new File(filesDirectory);
            File [] allFiles = rootDirectory.listFiles();
            ArrayList<String> listOfNames = new ArrayList<String>();
            for(File i:allFiles){
                listOfNames.add(i.getName());
            }
            return listOfNames;
        }
        
	public boolean getFile(FsRemoteInterface c, String fileName) throws RemoteException{
		
		 try{
			 File f1=new File(filesDirectory+fileName);			 
			 FileInputStream in=new FileInputStream(f1);			 				 
			 byte [] mydata=new byte[1024*1024];						
			 int mylen=in.read(mydata);
			 while(mylen>0){
				 c.sendAndSaveFile(f1.getName(), mydata, mylen);	 
				 mylen=in.read(mydata);				 
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 
		 }
		
		return true;
	}	
}