/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientprocesses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import interfaces.FsRemoteInterface;
import java.io.IOException;
 
/**
 * @authors { 
 * Sri chakra Goud Koppula
 * Anuj Jain
 * Niraj Agarwal
 * }
 */

public class Client  extends UnicastRemoteObject implements FsRemoteInterface {
	
	private static final long serialVersionUID = 1L;
	public String name;
        public String downloadDirectory = "downloads/";
	public  Client() throws RemoteException {
	}
    
        @Override
	public boolean sendAndSaveFile(String filename, byte[] data, int len) throws RemoteException{
        try{
        	File f=new File(downloadDirectory+filename);
        	f.createNewFile();
        	FileOutputStream out=new FileOutputStream(f,true);
        	out.write(data,0,len);
        	out.flush();
        	out.close();
        }catch(IOException e){
        	e.printStackTrace();
        }
		return true;
	}
        
        public ArrayList<String> listFiles(){
            File rootDirectory = new File(downloadDirectory);
            File [] allFiles = rootDirectory.listFiles();
            ArrayList<String> listOfNames = new ArrayList<String>();
            for(File i:allFiles){
                listOfNames.add(i.getName());
            }
            return listOfNames;
        }
} 

