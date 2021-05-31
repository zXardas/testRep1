

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS  weather (id INTEGER PRIMARY KEY AUTOINCREMENT, \n city TEXT NOT NULL, \n date_time TEXT NOT NULL, \n weather_text TEXT NOT NULL, \n temperature REAL NOT NULL  );";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
    String getAll ="SELECT * FROM weather";
    private Connection connection;
    private Statement statement;

    public void setConnection (Connection connection) {this.connection=connection;}
    public Connection getConnection () {return this.connection;}

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
        try {
            createTableIfNotExists();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private Connection getConnectionn() throws SQLException {
        //Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        setConnection(DriverManager.getConnection("jdbc:sqlite:" + filename));
        return connection;
    }


    private void createTableIfNotExists() throws SQLException {
        try (Connection connection = getConnectionn()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {

        try (
                Connection connection = getConnectionn();

        PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());

            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            getConnectionn().close();

        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws SQLException {
        List<WeatherData> weatherData= new ArrayList<WeatherData>();
     try(Connection conn = getConnectionn())
     {
        Statement stmt= conn.createStatement();
        ResultSet rs = stmt.executeQuery(getAll);

        while (rs.next()){
            weatherData.add(new WeatherData(rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    } finally {
         getConnectionn().close();
     }
        return weatherData;
    }
}
