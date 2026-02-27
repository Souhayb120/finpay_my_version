package org.example;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
public class FactureService {
    private Scanner sc = new Scanner(System.in);
    public void addFacture(Connection conn) throws SQLException{
        System.out.println("Enter Prestataire ID : ");
        int idPrestataire = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Client ID : ");
        int idClient = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Facture montant : ");
        double montant = sc.nextInt();
        sc.nextLine();
        String factureStatus;
        PreparedStatement ps = conn.prepareStatement("INSERT INTO facture (status,date_facture,montant,id_client,id_prestataire) VALUES (?,?,?,?,?)");
        ps.setString(1,"non_Payee");
        ps.setDate(2,Date.valueOf(LocalDate.now()));
        ps.setDouble(3,montant);
        ps.setInt(4,idClient);
        ps.setInt(5,idPrestataire);
        ps.executeUpdate();

        System.out.println("Facture Added Successfully !! ");
    }
}
