/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Firma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author nurullah
 */
public class FirmaDao {
    
     private Connector connector ;
     private Connection connection ;
     
    public List<Firma> findall(){
        
        List<Firma> flist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from firma");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Firma tmp = new Firma();
                tmp.setFirma_id(rs.getLong("firma_id"));
                tmp.setAdi(rs.getString("adi"));
                
                flist.add(tmp);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return flist;
    }

    public Firma find(Long id) {
        
        Firma f = null;
        

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from firma where firma_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
         rs.next() ;
             
          f = new Firma();
          f.setFirma_id(rs.getLong("firma_id"));
          f.setAdi(rs.getString("adi"));
          
         

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return f;
    }
    
    
    public List<Firma> findAll() {
        List<Firma> firmalist = new ArrayList<>();
        
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from firma");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Firma tmp = new Firma(rs.getLong("firma_id"), rs.getString("adi"));
                firmalist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return firmalist;
    }

    
    
    public void insert(Firma firma) {
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into firma (adi) values('" + firma.getAdi() + "')");
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Firma firma) {
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from firma where firma_id = "+firma.getFirma_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Firma firma) {
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update firma set adi='"+firma.getAdi()+"' where firma_id= "+firma.getFirma_id());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
         public Connector getConnector() {
        if(this.connector == null)
            this.connector = new Connector();
        return connector;
    }

    public Connection getConnection() {
        if(this.connection == null)
            this.connection = this.getConnector().connect();
        return connection;
    }
   
    }

