package DAO;


import Data.Distance;
import Data.User;
import Data.compet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dao {
    public static final String URL = "jdbc:mysql://localhost:3306/db_first";
    public static String USERNAME = null;
    public static String PASSWORD = null;
    public List<User> Users = new ArrayList();
    public List<compet> Competition = new ArrayList();
    public List<Distance> Distances = new ArrayList();
    private Connection connection;
    private Statement st;

    public Dao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public List<User> getUsers() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM users";
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("surname"),
                        rs.getInt("age"), rs.getInt("passNumb"), rs.getInt("passSeries")));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Users;
    }

    public void deleteUser(int id) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "DELETE from users where id =" + id;
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public User getUserById(int id) {
        String q = "select id,name,surname,email,age,passSeries,passNumb from users where id=" + id;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("surname"),
                        rs.getInt("age"), rs.getInt("passNumb"), rs.getInt("passSeries"));
                return user;
            }
            rs.close();
        } catch (SQLException e) {
        }
        return null;
    }

    public void addUser(User u) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "insert into users (name,surname,email,age,passSeries,passNumb) values " + u.toString() + ";";
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void updateUser(User u) {
        String q = "Update users set name ='" + u.getName() + "',surname='" + u.getSurname() + "',email='" + u.getEmail() +
                "',age=" + u.getAge() + ",passSeries='" + u.getpassSeries() + "',passNumb='" + u.getpassNumb() + "' where id=" + u.getId();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
            st.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public List<compet> getCompetition() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM competition";
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Competition.add(new compet(rs.getInt("id"), rs.getString("name"), rs.getString("city"), rs.getString("ref")));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Competition;
    }

    public List<Distance> getDistances() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM distance";
        try {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Distances.add(new Distance(rs.getInt("id"), rs.getString("style"), rs.getInt("distance"), rs.getInt("distwater")));
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return Distances;
    }

    public void deleteDistance(int id) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "DELETE from distance where id =" + id;
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Distance getDistanceById(int id) {
        String q = "select id,distance,style,distwater from distance where id=" + id;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                Distance distance = new Distance(rs.getInt("id"), rs.getString("style"), rs.getInt("distance"), rs.getInt("distwater"));
                return distance;
            }
            rs.close();
        } catch (SQLException e) {
        }
        return null;
    }

    public void addDistance(Distance u) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "insert into distance (style, distance, distwater) values " + u.toString() + ";";
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void updateDistance(Distance u) {
        String q = "Update distance set style ='" + u.getStyle() + "',distance='" + u.getDistance() + "',distwater='" + u.getDistwater() + "' where id=" + u.getId();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
            st.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void deleteCompetition(int id) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "DELETE from competition where id =" + id;
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public compet getCompetitionById(int id) {
        String q = "select id,name,city,ref from competition where id=" + id;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                compet comp = new compet(rs.getInt("id"), rs.getString("name"), rs.getString("city"), rs.getString("ref"));
                return comp;
            }
            rs.close();
        } catch (SQLException e) {
        }
        return null;
    }

    public void addCompetition(compet u) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String q = "insert into competition (name, city, ref) values " + u.toString() + ";";
        try {
            st.executeUpdate(q);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void updateCompetition(compet u) {
        String q = "Update competition set name ='" + u.getName() + "',city='" + u.getCity() + "',ref='" + u.getRef() + "' where id=" + u.getId();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = connection.createStatement();
            st.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
}