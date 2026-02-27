package org.example;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;
public class PaimentService {
    private Scanner sc = new Scanner(System.in);
    public double calcComission(double montant){
        return montant * 0.02;
    }
//    public String getStatus(double montant){
//        if()
//    }

    public double getMontant(Connection conn,int idFacture) throws SQLException{
        //get Total MOntant
        PreparedStatement getMontant = conn.prepareStatement("SELECT montant FROM facture WHERE id=?");
        getMontant.setInt(1,idFacture);
        ResultSet rs = getMontant.executeQuery();
        double f = 0.0;
        if(rs.next()){
            f = rs.getDouble("montant");
        }
        return  f;
    }
    public void addPaiment(Connection conn) throws SQLException{
        System.out.println("Enter Facture ID : ");
        int idFacture= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Client ID : ");
        int idClient = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Paiement montant : ");
        double montant = sc.nextInt();
        sc.nextLine();
        String status = "";

        //Add new Paiement
        PreparedStatement ps = conn.prepareStatement("INSERT INTO paiement (montant,comission,date_paiement,id_client,id_facture) VALUES (?,?,?,?,?)");
        ps.setDouble(1,montant);
        ps.setDouble(2,calcComission(montant));
        ps.setDate(3,Date.valueOf(LocalDate.now()));
        ps.setInt(4,idClient);
        ps.setInt(5,idFacture);
        ps.executeUpdate();


         double montantFacture = getMontant(conn,idFacture);
         if(montant < montantFacture){
             status = "Partiel";
         }else if(montant >= montantFacture){
             status = "Payee";
         }else{
             status = "non_Payee";
         }
        // update Facture
        PreparedStatement updateFacture = conn.prepareStatement("UPDATE facture SET status = ? WHERE id=?");
        updateFacture.setString(1,status);
        updateFacture.setInt(2,idFacture);
        updateFacture.executeUpdate();
        System.out.println("Paiement Added Successfully !! ");
    }

}
