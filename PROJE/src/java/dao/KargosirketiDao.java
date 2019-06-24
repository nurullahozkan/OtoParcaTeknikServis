/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Kargosirketi;
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
public class KargosirketiDao {
    
     private Connector connector ;
     private Connection connection ;
    
    public List<Kargosirketi> findAll() {
        List<Kargosirketi> kargosirketilist = new ArrayList<>();
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from kargosirketi");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Kargosirketi tmp = new Kargosirketi();
                tmp.setSirket_id(rs.getLong("sirket_id"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setTelno(rs.getString("telno"));
                
                kargosirketilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return kargosirketilist;

    }
    
    public List<Kargosirketi> findall(){
        List<Kargosirketi> klist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from kargosirketi");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Kargosirketi tmp = new Kargosirketi();
                tmp.setSirket_id(rs.getLong("sirket_id"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setTelno(rs.getString("telno"));
                
                klist.add(tmp);
                
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return klist;
    }
    
    public Kargosirketi find(Long id) {
        
        Kargosirketi k = null;
        

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from kargosirketi where sirket_id=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            
          rs.next();
          k = new Kargosirketi();
          k.setSirket_id(rs.getLong("sirket_id"));
          k.setAdi(rs.getString("adi"));
          k.setTelno(rs.getString("telno"));
          
          findAll();
          
          

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return k;
    }
    
    
    public void insert(Kargosirketi kargosirketi) {
         
         
           try {
               
               PreparedStatement pst = this.getConnection().prepareStatement("insert into kargosirketi(adi, telno) values(?,?)");
               
               pst.setString(1, kargosirketi.getAdi());
               pst.setString(2, kargosirketi.getTelno());
               
          
               
               ResultSet rs = pst.executeQuery();

               /* 
               Statement st = this.getConnection().createStatement();
               st.executeUpdate("insert into usta(tcno, firma_id, adi, soyadi, adres, tecrube, usta_maas)"
                       + " values('"+ usta.getTcno() +"',"+ selectedFirma+",'"+ usta.getAdi() +"'"
                               + ",'"+ usta.getSoyadi() +"','"+ usta.getAdres() +"','"+ usta.getTecrube() +"','"+ usta.getUsta_maas()+"')");
              */
               /*
               Long tcno = null;
               ResultSet GK = pst.getGeneratedKeys();
               if(GK.next()){
                   tcno = GK.getLong(1);
               }

*/
               
               
           }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public void update(Kargosirketi kargosirketi) {

            try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("update kargosirketi set adi=?, telno=?  where sirket_id=?");
            
            pst.setString(1, kargosirketi.getAdi());
            pst.setString(2, kargosirketi.getTelno());
            pst.setLong(3, kargosirketi.getSirket_id());

            pst.executeUpdate();
            
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
     
      public void delete(Kargosirketi kargosirketi) {
          
          try{
              
            PreparedStatement pst = this.getConnection().prepareStatement("delete from kargosirketi where sirket_id=?");
            pst.setLong(1, kargosirketi.getSirket_id());
            pst.executeUpdate();
            
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
        
            
        
