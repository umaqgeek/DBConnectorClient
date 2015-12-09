/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.DBConn;
import models.RMIConn;
import oms.rmi.server.Message;

/**
 *
 * @author umarmukhtar
 */
public class MainClient {
    
    public MainClient(String host) {
        DBConn.setHost(host);
        RMIConn.startRMI(host, DBConn.getPort_rmi());
    }
    
    public boolean setQuery(String query, String data[]) {
        boolean status = false;
        try {
            status = RMIConn.getImpl().setQuery(query, data);
        } catch (Exception e) {
        }
        return status;
    }
    
    public ArrayList<ArrayList<String>> getQuery(String query, String data[]) {
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        try {
            output = RMIConn.getImpl().getQuery(query, data);
        } catch (Exception e) {
        }
        return output;
    }
}
