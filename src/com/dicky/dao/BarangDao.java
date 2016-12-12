/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dicky.dao;

import com.dicky.db.KoneksiDB;
import com.dicky.entity.Barang;
import com.dicky.service.BarangService;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dicky-java
 */
public class BarangDao implements BarangService{

    private Connection koneksi;

    public BarangDao() {
        koneksi=KoneksiDB.getKoneksi();
    }
    
    
    
    @Override
    public void simpan(Barang b) {
        PreparedStatement statement=null;
        String sql = "insert into barang (idbarang, nama, harga) values (?,?,?)";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setString(1, b.getIdbarang());
            statement.setString(2, b.getNama());
            statement.setBigDecimal(3, b.getHarga());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
