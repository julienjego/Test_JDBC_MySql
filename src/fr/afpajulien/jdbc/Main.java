package fr.afpajulien.jdbc;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/immobilier";
        String username = "root";
        String pw = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection con = DriverManager.getConnection(url,username,pw);
            System.out.println("Connexion OK");
            Statement stm = con.createStatement();

            //stm.execute("insert into appart(nbrepieces,immeuble_noimm) values (4, '00003')");
            //stm.execute("update appart set prix=650,surface=65 where noappart=8");

            ResultSet resultSet = stm.executeQuery("select * from appart");

            while(resultSet.next()) {
                System.out.println("Appart " + resultSet.getInt("noappart") + " | Prix : " + resultSet.getInt("prix"));
            }

            stm.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
