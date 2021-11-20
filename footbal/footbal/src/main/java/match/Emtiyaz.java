package match;

import jdbc.ConnectionDB;
import jdbc.MyJdbc;
import model.User;

import java.sql.*;


public class Emtiyaz {
    User p=new User();
    Statement statement;
    PreparedStatement ps=null;
    int em;

    {
        try {
            statement = ConnectionDB.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int SetPishbini(int t1,int t2,String username,int id) {
        p.setUsername(username);
        try {
            ps=ConnectionDB.getConnection().prepareStatement("INSERT INTO footbal.prediction (theamOne, TheamTwo, username, matchId) values (?,?,?,?)");
            ps.setInt(1,t1);
            ps.setInt(2,t2);
            ps.setString(3,String.valueOf(p.getUsername()));
            ps.setInt(4,id);
            ps.executeUpdate();
            System.out.println("pishbini sabt shod successfully \n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }


        public int SetEmtiyaz(String username) {
            ResultSet resultSet = null;

            try {
                resultSet = statement.executeQuery(" select ID,resultOne,resultTow,prediction.* from footbal.matchr,footbal.prediction where matchr.ID=prediction.matchId and prediction.username='"+username+"'");
                while (resultSet.next()) {
                    int resultone=(resultSet.getInt("resultOne"));
                    int resulttwo=(resultSet.getInt("resultTow"));
                    int pishbiniOne=(resultSet.getInt("theamOne"));
                    int pishbiniTwo=(resultSet.getInt("TheamTwo"));

                    if (resultone==pishbiniOne && resulttwo==pishbiniTwo){
                      em=3;
                        System.out.println("3 emtiyaz");
                    }
                    else if (resultone==pishbiniOne || resulttwo==pishbiniTwo){
                      em=1;
                        System.out.println("1 emtiyaz");
                    }
                    else {
                        em=0;
                        System.out.println("0 emtiyaz");
                    };
                }
             p.setEmtiyaz(em);
                String sql1="update footbal.user set user.emtiyaz="+em+" where user.username='"+username+"'";
                ps=ConnectionDB.getConnection().prepareStatement(sql1);
                ps.executeUpdate(sql1);

                 } catch (SQLException e) {
                System.out.println(" not exist \n");
                 e.printStackTrace();
                }
                System.out.println("done successfully  \n");
                return p.getEmtiyaz();
                 }
}
