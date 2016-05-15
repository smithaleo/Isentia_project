package Project1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class News_articles {

public static void main(String[] args) throws SQLException, IOException {
String database_url = "mongodb://<username>:<password>@aws-us-east-1-portal.17.dblayer.com:10227/admin";
String username = "smitha";
String password = "hckkrc12123";
Connection connection = null;
Statement statement = null;
ResultSet result = null;

//Registering the Database Driver
try {
Class.forName("mongodb.jdbc.MongoDriver");
} catch (ClassNotFoundException e) {
System.out.println("ERROR: Unable to load SQLServer JDBC Driver");
e.printStackTrace();
return;
}
System.out.println("MongoDB JDBC Driver has been registered...");

System.out.println("Trying to get a connection to the database...");

//Creating the database connection
try {
connection = DriverManager.getConnection(database_url, username, password);
} catch (SQLException e) {
System.out.println("ERROR: Unable to establish a connection with the database!");
e.printStackTrace();
return;
}

if (connection != null) {
DatabaseMetaData metadata = connection.getMetaData();
System.out.println("Connection to the database has been established...");
System.out.println("JDBC Driver Name : " + metadata.getDriverName());
System.out.println("JDBC Driver Version : " + metadata.getDriverVersion());
} else {
System.out.println("ERROR: Unable to make a database connection!");
}


//Creating the JDBC statement
System.out.println("Trying to get news articles in news_articles...");
try {
statement = connection.createStatement();
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

System.out.println("enter the article_name you want to search");
String keyword = reader.readLine();

String sql = "select * from articles where article_name = +keyword";
result = statement.executeQuery(sql);

//Iterating through the ResultSet
while (result.next()) {
String article_name = result.getString("article_name");
String author = result.getString("article_author");
String article_url = result.getString("art_url");



System.out.printf("Article: %s, %s %s n", article_name, author, article_url);
}
} catch (SQLException e) {
System.out.println(e.getMessage());
} finally {
	//Closing the Connection
System.out.println("Closing all open resources...");
if (result != null) result.close();
if (statement != null) statement.close();
if (connection != null) connection.close();
}
}
}
