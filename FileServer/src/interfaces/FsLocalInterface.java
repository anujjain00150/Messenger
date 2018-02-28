/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @authors { 
 * Sri chakra Goud Koppula
 * Anuj Jain
 * Niraj Agarwal
 * }
 */
public interface FsLocalInterface extends Remote{
public String handshake() throws RemoteException;
    public ArrayList listFiles() throws RemoteException;
    public boolean getFile(FsRemoteInterface c, String fileName) throws RemoteException;
}
