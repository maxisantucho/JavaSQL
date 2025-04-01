package clases;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        ControllerConnection controller = new ControllerConnection();
        String URL = controller.URL;
        Properties props = controller.props;

        try (Connection c = controller.getConnection(URL, props)) {



        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }

}