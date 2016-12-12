/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dicky.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dicky-java
 */
public class KoneksiDB {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if(koneksi==null){
            try {
                String url = "jdbc:mysql://localhost:3306/currency";
                String usr = "root";
                String pwd = "root"; //disini password samakan dengan password mysql anda
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url, usr, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return koneksi;
    }
    
}
