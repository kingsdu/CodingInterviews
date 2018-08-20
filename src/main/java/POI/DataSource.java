package POI;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource ourInstance = new DataSource();

    public static DataSource getInstance() {
        return ourInstance;
    }

    private DataSource() {
    }


    public List<News> getDataByJDBC() throws ClassNotFoundException, SQLException {
        String URL="jdbc:sqlserver://192.168.0.103:1433;databaseName=GasInformation";
        String USER="sa";
        String PASSWORD="123456";

        List<News> newsList = new ArrayList<News>();
        News news = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);

        PreparedStatement pst = conn.prepareStatement("select top 10 * from Kcgl order by pubTime desc ");

        ResultSet resultSet = pst.executeQuery();


        while (resultSet.next()){
            news = new News();
            news.setTitle(resultSet.getString("title"));
            news.setPubTime(resultSet.getString("pubTime"));
            news.setSiteSource(resultSet.getString("siteSource"));
            news.setContent(resultSet.getString("content"));
            newsList.add(news);
        }
        return newsList;
    }
}
