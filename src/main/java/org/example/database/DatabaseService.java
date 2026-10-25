package org.example.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseService {
    private Connection connection;

    public DatabaseService() {
        try {
            this.connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/paises?user=root&password=admin");

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

    public List<Map<String, Object>> select(String sql, Object... params) throws SQLException {
        List<Map<String,Object>> result = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = statement.executeQuery()) {
                ResultSetMetaData meta = rs.getMetaData();

                while (rs.next()) {
                    Map<String,Object> row = new HashMap<>();
                    for (int i = 1; i<=meta.getColumnCount(); i++) {
                        row.put(meta.getColumnName(i), rs.getObject(i));
                    }
                    result.add(row);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

        return result;
    }
}
