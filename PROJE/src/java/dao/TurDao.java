/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tur;
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
public class TurDao {
    
     private Connector connector ;
     private Connection connection ;
     

    public List<Tur> findAll() {
        
        List<Tur> turlist = new ArrayList<>();
        
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from tur");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Tur tmp = new Tur();
                tmp.setTur_id(rs.getLong("tur_id"));
                tmp.setAdi(rs.getString("adi"));
                turlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return turlist;
    }
    
      
    public List<Tur> findall(){
        
        List<Tur> tlist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from tur");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Tur tmp = new Tur();
                tmp.setTur_id(rs.getLong("tur_id"));
                tmp.setAdi(rs.getString("adi"));
                
                tlist.add(tmp);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return tlist;
    }
     
    public Tur find(Long id) {
        
        Tur t = null;
        

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from tur where tur_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
          rs.next();
          t = new Tur();
          t.setTur_id(rs.getLong("tur_id"));
          t.setAdi(rs.getString("adi"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return t;
    }

    public void insert(Tur tur) {
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into tur (adi) values(?)");
            pst.setString(1, tur.getAdi());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Tur tur) {
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from tur where tur_id =? ");
            pst.setLong(1, tur.getTur_id());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Tur tur) {
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update tur set adi=? where tur_id=? ");
            pst.setString(1, tur.getAdi());
            pst.setLong(2, tur.getTur_id());
            
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

