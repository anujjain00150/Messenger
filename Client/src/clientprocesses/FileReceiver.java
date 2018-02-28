/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientprocesses;

import clientprocesses.Client;
import java.rmi.Naming;
import java.util.Scanner;
import interfaces.FsLocalInterface;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @authors { Sri chakra Goud Koppula Anuj Jain Niraj Agarwal }
 */
public class FileReceiver {

    Client c;
    String serverIP;
    FsLocalInterface fs;
    public String checkConnection(){
        try{
        return fs.handshake();
        }catch(RemoteException re){
            return "failure";
        }
        finally{
         
        }
    }
    public void init() {
        try {
            c = new Client();
            serverIP = "10.52.249.100";
            fs = (FsLocalInterface) Naming.lookup("rmi://" + serverIP + "/fserver");
        } catch (NotBoundException nbe) {
            nbe.printStackTrace();
        } catch (MalformedURLException ex) {
            Logger.getLogger(FileReceiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException re) {
            re.printStackTrace();
        }
    }

    
    
    public String getSelectedFileName() {
        try {
            ArrayList<String> listOfFiles = fs.listFiles();
            for (String i : listOfFiles) {
                System.out.println(i);
            }
            Scanner in = new Scanner(System.in);
            System.out.print("Enter file name: ");
            String selection = in.nextLine();
            in.close();
            System.out.println("Selected file: " + selection);
            fs.getFile(c, selection);
            return selection;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }
    
    
    public ArrayList<String> getServerFiles(){
        ArrayList serverFileList = null;
        try{
            serverFileList = fs.listFiles();
        }catch(RemoteException re){
            re.printStackTrace();
        }
        return serverFileList;
    }
    
    public ArrayList<String> getClientFiles(){
        ArrayList clientFileList = null;
        clientFileList = c.listFiles();
        return clientFileList;
    }

    public boolean downloadFile(String filename, int noOfParts) {
        try {
            fs.getFile(c, filename);
            return true;
        } catch (RemoteException re) {
            re.printStackTrace();
            return false;
        }
    }
}
