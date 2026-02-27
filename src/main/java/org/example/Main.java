package org.example;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
ClientService clientService = new ClientService();
FactureService factureService = new FactureService();
PaimentService paimentService = new PaimentService();
PrestataireService prestataireService = new PrestataireService();
        Connection conn = DBconnection.getConnection();
        //clientService.addClient(conn);
        //clientService.updateClient(conn);
        //clientService.deleteClient(conn);
        //clientService.displayClients(conn);
        //clientService.searchClientById(conn);
        //prestataireService.addPrestataire(conn);
        //prestataireService.updatePrestataire(conn);
        //prestataireService.deletePrestataire(conn);
        //prestataireService.displayPrestataire(conn);
        //prestataireService.findPrestataireById(conn);
        //factureService.addFacture(conn);
        paimentService.addPaiment(conn);
    }
}