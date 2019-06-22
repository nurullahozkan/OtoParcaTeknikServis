/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Siparis;
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
public class SiparisDao {
    
     private Connector connector ;
     private Connection connection ;
     
     private KargosirketiDao kargosirketiDao;
    
    public List<Siparis> findAll() {
        List<Siparis> siparislist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from siparis");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Siparis tmp = new Siparis();
                tmp.setSiparis_id(rs.getLong("siparis_id"));
                tmp.setAdet(rs.getInt("adet"));
                tmp.setSipari_tarihi(rs.getString("siparis_tarihi"));
                
                tmp.setKargosirketi(this.getKargosirketiDao().find(rs.getLong("sirket_id")));
                
                siparislist.add(tmp);
                
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
        return siparislist;
    }
    
      
    public List<Siparis> findall(){
        
        List<Siparis> slist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from siparis");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Siparis tmp = new Siparis();
                tmp.setSiparis_id(rs.getLong("siparis_id"));
                tmp.setAdet(rs.getInt("adet"));
                tmp.setSipari_tarihi(rs.getString("siparis_tarihi"));
                tmp.setKargosirketi(this.getKargosirketiDao().find(rs.getLong("sirket_id")));
                
                slist.add(tmp);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return slist;
    }
        
    public Siparis find(Long id) {
        
        Siparis s = null;
        

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from siparis where siparis_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
          rs.next();
          s = new Siparis();
          s.setSiparis_id(rs.getLong("siparis_id"));
          s.setAdet(rs.getInt("adet"));
          s.setSipari_tarihi(rs.getString("siparis_tarihi"));
          s.setKargosirketi(this.getKargosirketiDao().find(rs.getLong("sirket_id")));
                    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return s;
    }

    
    public void insert(Siparis siparis, Long selectedSirket) {
 
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("insert into siparis(sirket_id, adet, siparis_tarihi) values(?,?,?) ");
            pst.setLong(1, selectedSirket);
            pst.setInt(2, siparis.getAdet());
            pst.setString(3, siparis.getSipari_tarihi());
            
            ResultSet rs = pst.executeQuery();
            
              Long siparis_id = null;
               ResultSet GK = pst.getGeneratedKeys();
               if(GK.next()){
                   siparis_id = GK.getLong(1);
               }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
    
    public void update(Siparis siparis, Long selectedSirket) {
         
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("update siparis set sirket_id=?, adet=?, siparis_tarihi=? where siparis_id=?");
            
            pst.setLong(1, selectedSirket);
            pst.setInt(2, siparis.getAdet());
            pst.setString(3, siparis.getSipari_tarihi());
            pst.setLong(4, siparis.getSiparis_id());

            pst.executeUpdate();
            
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
    
    public void delete(Siparis siparis) {
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("delete from tamir where parca_id=?");
            pst.setLong(1, siparis.getSiparis_id());
            
            pst.executeUpdate();
            
            pst = this.getConnection().prepareStatement("delete from parca where siparis_id=?");
            pst.setLong(1, siparis.getSiparis_id());
            
            pst.executeUpdate();
            
            pst = this.getConnection().prepareStatement("delete from siparis where siparis_id=?");
            pst.setLong(1, siparis.getSiparis_id());
            
            pst.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    public KargosirketiDao getKargosirketiDao() {
        if(this.kargosirketiDao == null)
            this.kargosirketiDao = new KargosirketiDao();
        return kargosirketiDao;
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
