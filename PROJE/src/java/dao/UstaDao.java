/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Usta;
import entity.UstaArac;
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
public class UstaDao {

    private Connector connector;
    private Connection connection;
    
    private FirmaDao firmaDao;
    
    public List<Usta> findall(){
        List<Usta> ulist = new ArrayList<>();
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("select * from usta");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                Usta tmp = new Usta();
                tmp.setTcno(rs.getLong("tcno"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setSoyadi(rs.getString("soyadi"));
                tmp.setTecrube(rs.getInt("tecrube"));
                tmp.setUsta_maas(rs.getInt("usta_maas"));
                tmp.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));
                
                ulist.add(tmp);
                
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ulist;
    }
      
      


    public List<Usta> findAll() {

        List<Usta> ustalist = new ArrayList<>();

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("select * from usta");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usta tmp = new Usta();
                tmp.setTcno(rs.getLong("tcno"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setSoyadi(rs.getString("soyadi"));
                tmp.setAdres(rs.getString("adres"));
                tmp.setTecrube(rs.getInt("tecrube"));
                tmp.setUsta_maas(rs.getInt("usta_maas"));

                tmp.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));

                ustalist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ustalist;

    }
    public Usta find(Long id) {
    
        Usta u = null;
   
        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from usta where tcno=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

          while(rs.next()){
              
          u = new Usta();
          u.setTcno(rs.getLong("tcno"));
          u.setAdi(rs.getString("adi"));
          u.setSoyadi(rs.getString("soyadi"));
          u.setAdres(rs.getString("adres"));
          u.setTecrube(rs.getInt("tecrube"));
          u.setUsta_maas(rs.getInt("usta_maas"));
          u.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));
          }
          
          

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;
    }
    
    
       public void insert(Usta usta, Long selectedFirma) {
           
           try {
               
               PreparedStatement pst = this.getConnection().prepareStatement("insert into usta(tcno, firma_id, adi, soyadi, adres, tecrube, usta_maas) values(?,?,?,?,? ,?,?)");
               
               pst.setLong(1, usta.getTcno());
               pst.setLong(2, selectedFirma);
               pst.setString(3, usta.getAdi());
               pst.setString(4, usta.getSoyadi());
               pst.setString(5, usta.getAdres());
               pst.setInt(6, usta.getTecrube());
               pst.setInt(7, usta.getUsta_maas());
               
               pst.executeUpdate();

               /* 
               Statement st = this.getConnection().createStatement();
               st.executeUpdate("insert into usta(tcno, firma_id, adi, soyadi, adres, tecrube, usta_maas)"
                       + " values('"+ usta.getTcno() +"',"+ selectedFirma+",'"+ usta.getAdi() +"'"
                               + ",'"+ usta.getSoyadi() +"','"+ usta.getAdres() +"','"+ usta.getTecrube() +"','"+ usta.getUsta_maas()+"')");
              */
               Long tcno = null;
               ResultSet GK = pst.getGeneratedKeys();
               if(GK.next()){
                   tcno = GK.getLong(1);
               }
               
               
           }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
   
       public void update(Usta usta, Long selectedFirma) {
         
             
           try {
               
               PreparedStatement pst = this.getConnection().prepareStatement("update usta set"
                       + " tcno=?, firma_id=?, adi=?, soyadi=?, adres=?"
                       + ", tecrube=?, usta_maas=? where tcno =?");
               
               pst.setLong(1, usta.getTcno());
               pst.setLong(2, selectedFirma);
               pst.setString(3, usta.getAdi());
               pst.setString(4, usta.getSoyadi());
               pst.setString(5, usta.getAdres());
               pst.setInt(6, usta.getTecrube());
               pst.setInt(7, usta.getUsta_maas());
               pst.setLong(8, usta.getTcno());
               
               pst.executeUpdate();

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
       
    public void delete(Usta usta) {
        try{
            PreparedStatement pst = this.getConnection().prepareStatement("delete from usta_arac where tcno=?");
            pst.setLong(1, usta.getTcno());
            pst.executeUpdate();
            
            pst = this.getConnection().prepareStatement("delete from usta where tcno=?");
            pst.setLong(1, usta.getTcno());
            pst.executeUpdate();
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    
      public FirmaDao getFirmaDao() {
        if(this.firmaDao == null)
            this.firmaDao = new FirmaDao();
        return firmaDao;
    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }

    public UstaArac create(UstaArac ustaarac, Long selectedUsta, Long selectedArac, Long selectedTamir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    

 


}
