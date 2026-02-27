package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class PrestataireService {
    public  Scanner sc = new Scanner(System.in);



    public void addPrestataire(Connection conn)throws SQLException{
        System.out.println("Enter Prestataire Name : ");
        String name =  sc.nextLine();
        System.out.println("Enter Prestataire Adress : ");
        String adress =  sc.nextLine();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO prestataire (nom , adress) VALUES (?,?)");
        ps.setString(1,name);
        ps.setString(2,adress);
        ps.executeUpdate();
        System.out.println("Prestataire added Successfully !!");
    }


    public void updatePrestataire(Connection conn) throws SQLException{
        System.out.println("Enter Prestataire ID : ");
        int prestataireId = sc.nextInt();
        sc.nextLine();
        PreparedStatement ps = conn.prepareStatement("Select * From prestataire WHERE id=?");
        ps.setInt(1,prestataireId);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            System.out.println("Prestataire ID Found");
            System.out.println("Enter new Name");
            String newName = sc.nextLine();
            System.out.println("Enter new Adress");
            String newAdress = sc.nextLine();
            PreparedStatement ps2 = conn.prepareStatement("UPDATE prestataire Set nom = ? , adress = ?  WHERE id=?");
            ps2.setString(1,newName);
            ps2.setString(2,newAdress);
            ps2.setInt(3,prestataireId);
            ps2.executeUpdate();
            System.out.println("Prestataire updated Successfully !! ");
        }else{
            System.out.println("ID prestataire Not Found !!");
        }
    }

    public void deletePrestataire(Connection conn) throws SQLException{
        System.out.println("Enter Prestataire ID : ");
        int prestataireId = sc.nextInt();
        PreparedStatement ps = conn.prepareStatement("DELETE from prestataire WHERE id = ?");
        ps.setInt(1,prestataireId);
        ps.executeUpdate();
        System.out.println("Prestataire Deleted Successfully !! ");
    }

    public void displayPrestataire(Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM prestataire");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id : " + rs.getString(1));
            System.out.println("Nom : " + rs.getString(2));
            System.out.println("Adress : " + rs.getString(3));
            System.out.println("*********************");
        }
    }


    public void findPrestataireById(Connection conn)throws SQLException{
        System.out.println("Enter Prestataire ID : ");
        int prestataireId = sc.nextInt();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM prestataire WHERE id = ?");
        ps.setInt(1,prestataireId);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            System.out.println("id : " + rs.getString(1));
            System.out.println("Nom : " + rs.getString(2));
            System.out.println("Adress : " + rs.getString(3));
            System.out.println("*********************");
        }else{
            System.out.println("prestataire NOT found !");
        }
    }

}
