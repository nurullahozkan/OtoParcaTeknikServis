/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Personel;
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
public class PersonelDao {
    
    
     private Connector connector ;
     private Connection connection ;
     
     private FirmaDao firmaDao;

    public List<Personel> findAll() {
        List<Personel> personellist = new ArrayList<>();
        
        try{
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from personel");
            
            while(rs.next()){
                Personel tmp = new Personel();
                tmp.setTcno(rs.getLong("tcno"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setSoyadi(rs.getString("soyadi"));
                tmp.setAdres(rs.getString("adres"));
                
                tmp.setFirma(this.getFirmaDao().find(rs.getLong("firma_id")));
                
                personellist.add(tmp);
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return personellist;
    }

        public void create(Personel personel, Long selectedFirma) {
            try{
                
                Statement st = this.getConnection().createStatement();
                st.executeUpdate("insert into personel(tcno,firma_id,adi,soyadi,adres) "
                        + "values('"+personel.getTcno()+"',"+selectedFirma+",'"+personel.getAdi()+"','"+personel.getSoyadi()+"','"+personel.getAdres()+"') ");
                
                Long tcno = null;
                ResultSet gk = st.getGeneratedKeys();
                if(gk.next()){
                    tcno = gk.getLong(1);
                }
                
                
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public FirmaDao getFirmaDao() {
        if(this.firmaDao == null)
            this.firmaDao = new FirmaDao();
        return firmaDao;
    }
    
    public void update(Personel personel) {

        try{
           PreparedStatement pst = this.getConnection().prepareStatement("update personel set tcno = ?, adi=?, soyadi=?, adres=?  where firma_id=?");
            
            pst.setLong(1, personel.getTcno());
            pst.setString(2, personel.getAdi());
            pst.setString(3, personel.getSoyadi());
            pst.setString(4, personel.getAdres());
            pst.setLong(5, personel.getFirma().getFirma_id());

            pst.executeUpdate();    
            
        }    catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Personel personel) {
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("delete from personel where tcno=?");
            pst.setLong(1, personel.getTcno());
            pst.executeUpdate();
            
        }catch(SQLException ex){
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
