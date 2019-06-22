/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Arac;
import entity.Musteri;
import entity.UstaArac;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author nurullah
 */
public class MusteriDao {
    
    
     private Connector connector ;
     private Connection connection ;
     
     private Arac arac;
     private UstaArac ustaarac;
     
     private AracDao aracDao;
     private UstaAracDao ustaAracDao;
     
     public List<Musteri> findall(){
         List<Musteri> mlist = new ArrayList<>();
         
         try{
             
             PreparedStatement pst = this.getConnection().prepareStatement("select * from musteri");
             ResultSet rs = pst.executeQuery();
             
             while(rs.next()){
                 Musteri tmp = new Musteri();
                 tmp.setMusteri_id(rs.getLong("musteri_id"));
                 tmp.setAdi(rs.getString("adi"));
                 tmp.setSoyadi(rs.getString("soyadi"));
                 tmp.setTelno(rs.getString("telno"));
                 tmp.setEmail(rs.getString("email"));
                 
                 mlist.add(tmp);
             }
             
             
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
         return mlist;
     }
     
    public Musteri find(int id) {
    
        Musteri m = null;
   
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from musteri where musteri_id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

          rs.next();
          m = new Musteri();
          m.setMusteri_id(rs.getLong("musteri_id"));
          m.setAdi(rs.getString("adi"));
          m.setSoyadi(rs.getString("soyadi"));
          m.setTelno(rs.getString("telno"));
          m.setEmail(rs.getString("email"));
          

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return m;
    }

    public List<Musteri> findAll(int page, int pageSize) {
        List<Musteri> musterilist = new ArrayList<>();
        int start = (page-1)*(pageSize);
        
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("select * from musteri limit " +pageSize+ " offset " +start+ "");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Musteri tmp = new Musteri();
                tmp.setMusteri_id(rs.getLong("musteri_id"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setSoyadi(rs.getString("soyadi"));
                tmp.setTelno(rs.getString("telno"));
                tmp.setEmail(rs.getString("email"));
                
                musterilist.add(tmp);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return musterilist;
    }
    public int count() {
        int count = 0;
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("select count(musteri_id) as toplam from musteri");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("toplam");
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return count;
    }
    
       public void insert(Musteri musteri) {
        
           try {
               
               PreparedStatement pst = this.getConnection().prepareStatement("insert into musteri(adi, soyadi, telno, email) values(?, ?, ?, ?)");
               pst.setString(1, musteri.getAdi());
               pst.setString(2, musteri.getSoyadi());
               pst.setString(3, musteri.getTelno());
               pst.setString(4, musteri.getEmail());
               
               pst.executeUpdate();
               
               /*
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into musteri (adi,soyadi,telno,email) values('"
                    + musteri.getAdi() + "','" + musteri.getSoyadi() + "','" + musteri.getTelno()
                    + "','" + musteri.getEmail() + "')");
             */
               
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
           public void update(Musteri musteri) {

            try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("update musteri set adi=?, soyadi=?, telno=?, email=?  where musteri_id=?");
            
            pst.setString(1, musteri.getAdi());
            pst.setString(2, musteri.getSoyadi());
            pst.setString(3, musteri.getTelno());
            pst.setString(4, musteri.getEmail());
            pst.setLong(5, musteri.getMusteri_id());

            pst.executeUpdate();
            
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Musteri musteri) {
        
        try{
            /*
            PreparedStatement pst = this.getConnection().prepareStatement("delete from usta_arac as us USING arac as a where a.musteri_id=?");
            pst.setLong(1, musteri.getMusteri_id());
            pst.executeUpdate();*/
            
            PreparedStatement pst = this.getConnection().prepareStatement("delete from usta_arac as us USING arac as a where us.sasino=?");
            pst.setLong(1, musteri.getMusteri_id());
            pst.executeUpdate();
            
            pst = this.getConnection().prepareStatement("delete from arac where musteri_id=?");
            pst.setLong(1, musteri.getMusteri_id());
            pst.executeUpdate();
            
            pst = this.getConnection().prepareStatement("delete from musteri where musteri_id=?");
            pst.setLong(1, musteri.getMusteri_id());
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

    public Arac getArac() {
        if(this.arac == null)
            this.arac = new Arac();
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public UstaArac getUstaarac() {
        if(this.ustaarac == null)
            this.ustaarac = new UstaArac();
        return ustaarac;
    }

    public void setUstaarac(UstaArac ustaarac) {
        this.ustaarac = ustaarac;
    }

    public AracDao getAracDao() {
        if(this.aracDao == null);
        this.aracDao = new AracDao();
        return aracDao;
    }

    public void setAracDao(AracDao aracDao) {
        this.aracDao = aracDao;
    }

    public UstaAracDao getUstaAracDao() {
        if(this.ustaAracDao == null)
            this.ustaAracDao = new UstaAracDao();
        return ustaAracDao;
    }

    public void setUstaAracDao(UstaAracDao ustaAracDao) {
        this.ustaAracDao = ustaAracDao;
    }
    

}
