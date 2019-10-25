/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tamir;
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
public class TamirDao {
    
     private Connector connector ;
     private Connection connection ;
     
     private ParcaDao parcaDao;
     
     
     public List<Tamir> findAll(){
         
     List<Tamir> tamirlist = new ArrayList<>();
     
     try{
         
         PreparedStatement pst = this.getConnection().prepareStatement("select * from tamir");
         ResultSet rs = pst.executeQuery();
         
         while(rs.next()){
             Tamir tmp = new Tamir();
             tmp.setTamir_id(rs.getLong("tamir_id"));
             tmp.setTbi_ucret(rs.getInt("tbi_ucret"));
             
             tmp.setParca(this.getParcaDao().find(rs.getLong("parca_id")));
             
             
             tamirlist.add(tmp);
         }
         
     }catch(SQLException ex){
         System.out.println(ex.getMessage());
     }
     
     return tamirlist;
     }

     
     public Tamir find(Long id) {
    
        Tamir t = null;
   
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from tamir where tamir_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

          while(rs.next()){
              
          t = new Tamir();
          t.setTamir_id(rs.getLong("tamir_id"));
          t.setTbi_ucret(rs.getInt("tbi_ucret"));
          
          t.setParca(this.getParcaDao().find(rs.getLong("parca_id")));
          }
          
          
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return t;
    } 
     
     
      public List<Tamir> findall(){
        List<Tamir> tlist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from tamir");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Tamir tmp = new Tamir();
                tmp.setTamir_id(rs.getLong("tamir_id"));
                tmp.setTbi_ucret(rs.getInt("tbi_ucret"));
                tmp.setParca(this.getParcaDao().find(rs.getLong("parca_id")));
                
                
                tlist.add(tmp);
                
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return tlist;
    }
      
         public void insert(Tamir tamir, Long selectedParca) {
    
          try{
              
                  
            PreparedStatement pst = this.getConnection().prepareStatement("insert into tamir(parca_id, tbi_ucret)"
                    + "values (?, ?)" );
            pst.setLong(1, selectedParca);
            pst.setInt(2, tamir.getTbi_ucret());
            
            pst.executeUpdate();
              
          }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    public ParcaDao getParcaDao() {
        if(this.parcaDao == null)
            this.parcaDao = new ParcaDao();
        return parcaDao;
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

    public void update(Tamir tamir, Long selectedParca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Tamir tamir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
