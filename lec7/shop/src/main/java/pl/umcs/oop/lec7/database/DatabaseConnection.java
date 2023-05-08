package pl.umcs.oop.lec7.database;

import java.sql.Connection;

public interface DatabaseConnection {
    Connection getConnection();
}
