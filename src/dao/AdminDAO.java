package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;

public class AdminDAO {
    public boolean login(String username, String password){

        String sql = "select username from admin where username =? and password =?";
        boolean isValid = false;

        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                isValid = true;
            }else{
                isValid = false;
            }

            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return isValid;
    }
}
