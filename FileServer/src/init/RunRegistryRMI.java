
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import fileserver.FileServer;
import java.net.Inet4Address;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * @authors { 
 * Sri chakra Goud Koppula
 * Anuj Jain
 * Niraj Agarwal
 * }
 */
public class RunRegistryRMI {

    public static void main(String[] args) {
        try {

            java.rmi.registry.LocateRegistry.createRegistry(1099);
            FileServer fs = new FileServer();
            System.out.println("IP: "+Inet4Address.getLocalHost().getHostAddress());
            Naming.rebind("rmi://"+Inet4Address.getLocalHost().getHostAddress()+"/fserver", fs);
            System.out.println("Server ready to send file.");

        } catch (RemoteException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
