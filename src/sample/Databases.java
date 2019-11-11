package sample;

import java.sql.*;

public class Databases {

    private static String url = "jdbc:sqlite:sqlite.db";
    private static Connection conn = null;

    public static void connect() {
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createtables() {

        String table1 = "CREATE TABLE IF NOT EXISTS orderTable( " + "ordernumber INT PRIMARY KEY, customer VARCHAR(45), cost INT, saleprice INT, status VARCHAR(45), delivery VARCHAR(45))";
        String table2 = "CREATE TABLE IF NOT EXISTS invoicingTable( " + "invoicenumber INT PRIMARY KEY, ordernumber INT, saleprice INT, status VARCHAR(45))";
        String table3 = "CREATE TABLE IF NOT EXISTS payablesTable( " + "apnumber INT PRIMARY KEY, company VARCHAR(45), item VARCHAR(250), cost INT, status VARCHAR(45))";


        try{
            Connection connection = DriverManager.getConnection(url);
            Statement stmt = connection.createStatement();
            stmt.execute(table1);
            stmt.execute(table2);
            stmt.execute(table3);
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertorder(int ordernumber, String customer, double cost, double saleprice, String status, String delivery) {
        String url = "jdbc:sqlite:sqlite.db";
        String record = "INSERT INTO orderTable(ordernumber, customer, cost, saleprice, status, delivery) VALUES(?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement pstmt = connection.prepareStatement(record);
            pstmt.setInt(1, ordernumber);
            pstmt.setString(2, customer);
            pstmt.setDouble(3, cost);
            pstmt.setDouble(4, saleprice);
            pstmt.setString(5, status);
            pstmt.setString(6, delivery);
            pstmt.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertinvoicing(int invoicenumber, int ordernumber, double salesprice, String status) {
        String url = "jdbc:sqlite:sqlite.db";
        String record = "INSERT INTO invoicingTable(int invoicenumber, int ordernumber, double salesprice, String status) VALUES(?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement pstmt = connection.prepareStatement(record);
            pstmt.setInt(1, invoicenumber);
            pstmt.setInt(2, ordernumber);
            pstmt.setDouble(3, salesprice);
            pstmt.setString(4, status);
            pstmt.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertpayables(int apnumber, String company, String item, double cost, String status) {
        String url = "jdbc:sqlite:sqlite.db";
        String record = "INSERT INTO payablesTable(int apnumber, String company, String item, double cost, String status) VALUES(?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement pstmt = connection.prepareStatement(record);
            pstmt.setInt(1, apnumber);
            pstmt.setString(2, company);
            pstmt.setString(3, item);
            pstmt.setDouble(4, cost);
            pstmt.setString(5, status);
            pstmt.executeUpdate();
            connection.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectAll() {
        String sql = "SELECT * FROM orderTable";

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                System.out.println(rs.getInt("ordernumber") + "\t" + rs.getString("customer") + "\t" + rs.getDouble("cost") + "\t" + rs.getDouble("saleprice") + "\t" + rs.getString("status") + "\t" + rs.getString("delivery"));
            }
            connection.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getordernumber() {
        int ordernumber = 0;
        try {
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT ordernumber FROM orderTable ORDER BY ordernumber DESC LIMIT 1";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ordernumber = rs.getInt("ordernumber") + 1;
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ordernumber;
    }

    public static void searchordernumber(int inputnum) {
        try {
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT * FROM orderTable WHERE ordernumber= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, inputnum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("id=" + id);
                //Now edit the line

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

