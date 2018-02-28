/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @authors { 
 * Sri chakra Goud Koppula
 * Anuj Jain
 * Niraj Agarwal
 * }
 */
public interface FsRemoteInterface extends Remote {
    public boolean sendAndSaveFile(String filename, byte[] data, int len) throws RemoteException;	
}
