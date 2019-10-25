/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Arac;
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
public class AracDao {

    private Connector connector;
    private Connection connection;

    private MusteriDao musteriDao;

    public List<Arac> findAll() {
        List<Arac> araclist = new ArrayList<>();

        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from arac");

            while (rs.next()) {
                Arac tmp = new Arac();
                tmp.setSasino(rs.getLong("sasino"));
                tmp.setPlaka(rs.getString("plaka"));
                tmp.setRenk(rs.getString("renk"));
                tmp.setMotorno(rs.getInt("motorno"));

                tmp.setMusteri(this.getMusteriDao().find(rs.getInt("musteri_id")));

                araclist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return araclist;
    }

    public Arac find(Long id) {

        Arac a = null;

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from arac where sasino=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                a = new Arac();
                a.setSasino(rs.getLong("sasino"));
                a.setPlaka(rs.getString("plaka"));
                a.setRenk(rs.getString("renk"));
                a.setMotorno(rs.getInt("motorno"));
                a.setMusteri(this.getMusteriDao().find(rs.getInt("musteri_id")));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return a;
    }

    public List<Arac> findall() {
        List<Arac> alist = new ArrayList<>();

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("select * from arac");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Arac tmp = new Arac();
                tmp.setSasino(rs.getLong("sasino"));
                tmp.setPlaka(rs.getString("plaka"));
                tmp.setRenk(rs.getString("renk"));
                tmp.setMotorno(rs.getInt("motorno"));
                tmp.setMusteri(this.getMusteriDao().find(rs.getInt("musteri_id")));

                alist.add(tmp);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return alist;
    }

    public void insert(Arac arac, Long selectedMusteri) {

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("insert into arac(sasino, musteri_id, plaka, renk, motorno) values(?, ?, ?, ?, ?)");

            pst.setLong(1, arac.getSasino());
            pst.setLong(2, selectedMusteri);
            pst.setString(3, arac.getPlaka());
            pst.setString(4, arac.getRenk());
            pst.setInt(5, arac.getMotorno());

            pst.executeUpdate();

            Long sasino = null;
            ResultSet GK = pst.getGeneratedKeys();
            if (GK.next()) {
                sasino = GK.getLong(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Arac arac) {

        try {
            //Musteri m = new Musteri();

            PreparedStatement pst = this.getConnection().prepareStatement("delete from usta_arac where sasino=?");
            pst.setLong(1, arac.getSasino());
            pst.executeUpdate();

            pst = this.getConnection().prepareStatement("delete from arac where sasino=?");
            pst.setLong(1, arac.getSasino());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Arac arac, Long selectedMusteri) {

        try {

            PreparedStatement pst = this.getConnection().prepareStatement("update arac set  sasino=?, musteri_id=?, plaka=?, renk=?, motorno=? where sasino=? ");
            pst.setLong(1, arac.getSasino());
            pst.setLong(2, selectedMusteri);
            pst.setString(3, arac.getPlaka());
            pst.setString(4, arac.getRenk());
            pst.setInt(5, arac.getMotorno());
            pst.setLong(6, arac.getSasino());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public MusteriDao getMusteriDao() {
        if (this.musteriDao == null) {
            this.musteriDao = new MusteriDao();
        }
        return musteriDao;
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
