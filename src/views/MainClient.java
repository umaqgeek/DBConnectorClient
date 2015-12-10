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
    
    private String host;
    
    public MainClient(String host) {
        this.host = host;
        DBConn.setHost(host);
        RMIConn.startRMI(host, DBConn.getPort_rmi());
    }
    
    public boolean setQuery(String query, String data[]) {
        boolean status = false;
        try {
            if (RMIConn.getImpl() == null) {
                new MainClient(this.host);
            }
            status = RMIConn.getImpl().setQuery(query, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public ArrayList<ArrayList<String>> getQuery(String query, String data[]) {
        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
        try {
            if (RMIConn.getImpl() == null) {
                new MainClient(this.host);
            }
            output = RMIConn.getImpl().getQuery(query, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
