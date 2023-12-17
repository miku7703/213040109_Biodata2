/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Kaho
 */
public class MySqlConnection {
    // URL, username, dan password database
    private final static String DB_URL = "jdbc:mysql://localhost:3307/biodata";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";

    // Singleton instance untuk MySqlConnection
    private static MySqlConnection instance;

    // Metode untuk mendapatkan instance MySqlConnection (Singleton)
    public static MySqlConnection getInstance() {
        if (instance == null) {
            instance = new MySqlConnection();
        }
        return instance;
    }

    // Mendapatkan koneksi ke database
    public Connection getConnection() {
        Connection connection = null;
        try {
            // Mendaftarkan driver JDBC untuk MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Membuat koneksi ke database menggunakan URL, username, dan password yang ditentukan
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            // Menangkap dan mencetak stack trace jika terjadi kesalahan
            e.printStackTrace();
            
        }
        return connection;
    }
}
