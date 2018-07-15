package szn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KonekcijskaKlasa {
	String connectionUrl = "jdbc:sqlserver://NIKOLINAP;databaseName=SIMS;integratedSecurity=true;";
	 
    Connection con = null;  
    Statement stmt = null;  
    
    public KonekcijskaKlasa() throws ClassNotFoundException, SQLException{
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        con = DriverManager.getConnection(connectionUrl);  
        stmt = con.createStatement();  
    }
    
    public ArrayList<String> vratiSveKorisnike(){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT * FROM tblKorisnici;";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				System.out.println(rs.getString(1));
				mesta.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    public ArrayList<String> vratiSveNaplatneStanice(){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT * FROM tblNaplatnaStanica;";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				System.out.println(rs.getString(1));
				mesta.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    public String vratiIdNaplatneStanice(String id){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT * FROM tblNaplatnaStanica WHERE naziv = '" + id + "';";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				System.out.println(rs.getString(1));
				mesta.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta.get(0);
    }
    
    public ArrayList<String> vratiSveNaplatneStaniceIme(){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT * FROM tblNaplatnaStanica;";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				System.out.println(rs.getString(2));
				mesta.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    public ArrayList<String> vratiSveDeonice(){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT * FROM tblDeonice;";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				mesta.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    public ArrayList<String> vratiSvaMesta(){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT * FROM tblMesta;";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				mesta.add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    public ArrayList<String> vratiMestaDolaska(Korisnik k){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT m.naziv FROM tblKorisnici k "+
    	"JOIN KorisnikStanica ks ON k.korisnickoIme = ks.korisnickoIme "+
    	"JOIN tblDeonice d ON d.idStanice = ks.idStanice JOIN tblMesta m "+
    	"ON d.mestoDolaska = m.idMesta WHERE k.korisnickoIme = '" + k.getUsername() + "';";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				System.out.println(rs.getString(1));
				mesta.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    public ArrayList<String> vratiMestaDolaskaKontrolor(Korisnik k){
    	ArrayList<String> mesta = new ArrayList<String>();
    	ResultSet rs = null;  
    	String SQL = "SELECT naziv FROM tblKorisnici k JOIN KorisnikMesto km ON " + 
    	"k.korisnickoIme = km.korisnickoIme JOIN tblNaplatnoMesto nm ON nm.idMesta = km.idMesta "+
    	"JOIN tblDeonice d ON d.idStanice = nm.idStanice JOIN tblMesta m ON d.mestoDolaska = m.idMesta "+
    	"WHERE k.korisnickoIme = '" + k.getUsername() + "';";
    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				System.out.println(rs.getString(1));
				mesta.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return mesta;
    }
    
    
    public ArrayList<KvarModel> vratiKvarove(Korisnik k, String pocetna, String krajnja){
    	ArrayList<KvarModel> kvarovi = new ArrayList<KvarModel>();
    	ResultSet rs = null;  
    	String SQL = "SELECT kv.idKvara, kv.vremeKvara, kv.vrstaKvara, kv.idUredjaja"+
    	" FROM tblKorisnici k JOIN KorisnikStanica ks ON "+
    	"k.korisnickoIme = ks.korisnickoIme JOIN tblKvar kv ON "+
    	"kv.idStanice = ks.idStanice WHERE k.korisnickoIme = '" + k.getUsername() +
    	"' AND kv.vremeKvara BETWEEN '" + pocetna +"' AND '" + krajnja +"';";
    
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				KvarModel im = new KvarModel(Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getString(4)));
				kvarovi.add(im);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return kvarovi;
    }
    
    public ArrayList<KvarModel> vratiKvarove(Korisnik k){
    	ArrayList<KvarModel> kvarovi = new ArrayList<KvarModel>();
    	ResultSet rs = null;  
    	String SQL = "SELECT kv.idKvara, kv.vremeKvara, kv.vrstaKvara, kv.idUredjaja"+
    	" FROM tblKorisnici k JOIN KorisnikStanica ks ON k.korisnickoIme = ks.korisnickoIme JOIN tblKvar kv ON "+
    			"kv.idStanice = ks.idStanice WHERE k.korisnickoIme = '" + k.getUsername() + "';";
    
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				KvarModel im = new KvarModel(Integer.valueOf(rs.getString(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getString(4)));
				kvarovi.add(im);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return kvarovi;
    }
    
    public ArrayList<IzvestajModel> vratiIzvestajCena(Korisnik k, String id){
    	ArrayList<IzvestajModel> cene = new ArrayList<IzvestajModel>();
    	ResultSet rs = null;  
    	
    	String SQL = "SELECT ns.naziv, nm.idMesta, SUM(n.Cena) FROM tblNaplatnaStanica ns "+
    	"JOIN tblNaplatnoMesto nm ON nm.idStanice = ns.idStanice JOIN Naplata n ON "+
    			"n.idMesta = nm.idMesta WHERE ns.idStanice = " + id +" GROUP BY nm.idMesta, ns.naziv;";

    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				IzvestajModel im = new IzvestajModel(rs.getString(1), Integer.valueOf(rs.getString(2)), Double.parseDouble(rs.getString(3)));
				cene.add(im);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return cene;
    	
    }
    
    public ArrayList<IzvestajModel> vratiIzvestajCena(Korisnik k){
    	ArrayList<IzvestajModel> cene = new ArrayList<IzvestajModel>();
    	ResultSet rs = null;  
    	
    	String SQL = "SELECT ns.naziv, nm.idMesta, SUM(n.Cena) FROM tblKorisnici k "+
    	"JOIN KorisnikStanica ks ON k.korisnickoIme = ks.korisnickoIme "+
    	"JOIN tblNaplatnaStanica ns ON ks.idStanice = ns.idStanice JOIN tblNaplatnoMesto nm "+
    	"ON nm.idStanice = ns.idStanice JOIN Naplata n ON n.idMesta = nm.idMesta WHERE k.korisnickoIme = '" 
    	+ k.getUsername() + "' GROUP BY nm.idMesta, ns.naziv;";  

    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				IzvestajModel im = new IzvestajModel(rs.getString(1), Integer.valueOf(rs.getString(2)), Double.parseDouble(rs.getString(3)));
				cene.add(im);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return cene;
    	
    }
    
    public ArrayList<IzvestajModel> vratiIzvestajCena(Korisnik k, String pocetna, String krajnja){
    	ArrayList<IzvestajModel> cene = new ArrayList<IzvestajModel>();
    	ResultSet rs = null;  
    	
    	String SQL = "SELECT ns.naziv, nm.idMesta, SUM(n.Cena) "+
    	"FROM tblKorisnici k JOIN KorisnikStanica ks ON k.korisnickoIme = ks.korisnickoIme"+
    	" JOIN tblNaplatnaStanica ns ON ks.idStanice = ns.idStanice JOIN tblNaplatnoMesto nm "+
    	"ON nm.idStanice = ns.idStanice JOIN Naplata n ON n.idMesta = nm.idMesta WHERE k.korisnickoIme = '"
    	+ k.getUsername() + "'  AND n.datumNaplate BETWEEN '"+ pocetna +"' AND '" + krajnja+ "' GROUP BY nm.idMesta, ns.naziv;";  

    	System.out.println(SQL);
    	try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(SQL);
			while (rs.next()) { 
				IzvestajModel im = new IzvestajModel(rs.getString(1), Integer.valueOf(rs.getString(2)), Double.parseDouble(rs.getString(3)));
				cene.add(im);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    	
    	return cene;
    	
    }

}
