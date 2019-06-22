/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Depo;
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
public class DepoDao {
    
    
     private Connector connector ;
     private Connection connection ;
     

    public List<Depo> findAll() {
        List<Depo> depolist = new ArrayList<>();
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from depo");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Depo tmp = new Depo();
                tmp.setDepo_id(rs.getLong("depo_id"));
                tmp.setAdres(rs.getString("adres"));

                depolist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return depolist;

    }
    
      
    public List<Depo> findall(){
        
        List<Depo> dlist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from depo");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Depo tmp = new Depo();
                tmp.setDepo_id(rs.getLong("depo_id"));
                tmp.setAdres(rs.getString("adres"));
                
                dlist.add(tmp);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return dlist;
    }
    
    public Depo find(Long id) {
        
        Depo d = null;
        

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from depo where depo_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
          rs.next();
          d = new Depo();
          d.setDepo_id(rs.getLong("depo_id"));
          d.setAdres(rs.getString("adres"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return d;
    }
    
    
    public void insert(Depo depo) {
    
        
           try {
               
               PreparedStatement pst = this.getConnection().prepareStatement("insert into depo(depo_id, adres) values(?,?)");
               
               pst.setLong(1, depo.getDepo_id());
               pst.setString(2, depo.getAdres());
               
               
               ResultSet rs = pst.executeQuery();
               
               
           }catch (SQLException ex) {
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
