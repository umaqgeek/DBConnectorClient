/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author umarmukhtar
 */
public class TestMain {
    
    public static void main(String[] args) {
        
        System.out.println("Connecting ...");
        MainClient mc = new MainClient("192.168.1.5");
        System.out.println("Connected. Sending query ...");
        boolean status = mc.setQuery("CREATE TABLE ATEST(COLA VARCHAR2(10), COLB VARCHAR2(10));", null);
        System.out.println("Query sent.");
        System.out.println("status:"+status);
    }
}
