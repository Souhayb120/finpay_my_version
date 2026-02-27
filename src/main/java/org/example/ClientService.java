package org.example;
import java.sql.*;
import java.util.Scanner;

public class ClientService {
    private Scanner sc = new Scanner(System.in);

    public void addClient(Connection conn) throws SQLException {
        System.out.println("Enter ur name : ");
        String name = sc.nextLine();
        String sql = "INSERT INTO client (nom) values (?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,name);
        ps.executeUpdate();
        System.out.println("Client added Successfully !! ");
    }

    public void updateClient(Connection conn) throws SQLException {
        System.out.println("Enter Client ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Update Name");
        System.out.println("-> new name value : ");
        String updatedName = sc.nextLine();
        String sql = "UPDATE client SET nom=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,updatedName);
        ps.setInt(2,id);
        ps.executeUpdate();
        System.out.println("Client Updated Successfully !! ");
    }


    public void deleteClient(Connection conn) throws SQLException{
        System.out.println("Enter Client ID : ");
        int clientId = sc.nextInt();
        sc.nextLine();
        String sql = "DELETE FROM client WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,clientId);
        ps.executeUpdate();
        System.out.println("Client Deleted Succeffully");
    }

public void displayClients(Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM client");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println("ID : " +  rs.getInt("id"));
            System.out.println("Nom : " +  rs.getString("nom"));
            System.out.println("*********************");
        }
        rs.close();
        ps.close();

}

public void searchClientById(Connection conn) throws SQLException{
    System.out.println("Enter Client ID : ");
    int clientId = sc.nextInt();
    String sql = "SELECT * FROM client WHERE id=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1,clientId);
    ResultSet rs = ps.executeQuery();
    if(rs.next()){
        System.out.println("ID : " + rs.getInt("id") + " Name : " + rs.getString("nom"));
    }else{
        System.out.println("Client Not Found !!");
    }

}




}
