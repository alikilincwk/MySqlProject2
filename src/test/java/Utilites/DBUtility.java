package Utilites;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    private static Connection connection;
    public static Statement statement;

    public static List<List<String>> getListData(String sorgu)
    {
        DBConnectionOpen();

        List<List<String>> tablo=new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(sorgu);
            ResultSetMetaData rsmd=rs.getMetaData();

            while (rs.next())
            {
                ArrayList<String> satir=new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    satir.add(rs.getString(i));

                tablo.add(satir);
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        DBConnectionClose();
        return tablo;
    }

    public static void DBConnectionOpen() {
        String url = "jdbc:mysql://demo.mersys.io:33906/employees";
        String username = "student";
        String password = "DEkzTd3#pzPm";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void DBConnectionClose() {
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void getListMethod(String query) {
        List<List<String>> table = DBUtility.getListData(query);
        for (List<String> row : table) {
            for (String cell : row)
                System.out.print(cell + "\t");

            System.out.println();
        }

    }






























}
