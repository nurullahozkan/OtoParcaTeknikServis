/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class UstaAracDao {

    private Connector connector;
    private Connection connection;

    private AracDao aracDao;
    private TamirDao tamirDao;
    private UstaDao ustaDao;

    public List<UstaArac> findAll() {
        List<UstaArac> ustaaraclist = new ArrayList<>();

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from usta_arac");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                UstaArac tmp = new UstaArac();
                tmp.setUsta_arac_id(rs.getLong("usta_arac_id"));
                tmp.setUsta(this.getUstaDao().find(rs.getLong("tcno")));
                tmp.setArac(this.getAracDao().find(rs.getLong("sasino")));
                tmp.setTamir(this.getTamirDao().find(rs.getLong("tamir_id")));
                tmp.setTarih(rs.getString("tarih"));
                
                ustaaraclist.add(tmp);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return ustaaraclist;
    }
    
    public void insert(UstaArac ustaarac, Long selectedUsta, Long selectedArac, Long selectedTamir) {
        
        try{
            
            PreparedStatement pst = this.getConnection().prepareStatement("insert into usta_arac(tcno, sasino, tamir_id, tarih)"
                    + "values (?, ?, ?, ?)" );
            pst.setLong(1, selectedUsta);
            pst.setLong(2, selectedArac);
            pst.setLong(3, selectedTamir);
            pst.setString(4, ustaarac.getTarih());
            
            pst.executeUpdate();
           
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
     public void delete(UstaArac ustaarac) {
         
         try{
             
             PreparedStatement pst = this.getConnection().prepareStatement("delete from usta_arac where usta_arac_id =?");
             pst.setLong(1, ustaarac.getUsta_arac_id());
             pst.executeUpdate();
             
         }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public AracDao getAracDao() {
        if (this.aracDao == null) {
            this.aracDao = new AracDao();
        }
        return aracDao;
    }

    public TamirDao getTamirDao() {
        if (this.tamirDao == null) {
            this.tamirDao = new TamirDao();
        }
        return tamirDao;
    }

    public UstaDao getUstaDao() {
        if (this.ustaDao == null) {
            this.ustaDao = new UstaDao();
        }
        return ustaDao;
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

   

}
