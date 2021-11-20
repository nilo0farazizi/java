package jdbc;

import match.Match;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJdbc implements jdbc {


      User p=new User();
      Statement statement;
      PreparedStatement ps=null;
      String status=null;
     Match m=new Match();
     public static Integer resultone;
      public static Integer resulttwo;
    {
        try {
            statement = ConnectionDB.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void save(ArrayList Pl) {
        try {
            ps=ConnectionDB.getConnection().prepareStatement("INSERT INTO footbal.matchr (Id,TeamONE,TeamTWO,name,bargozari) values (?,?,?,?,0)");
            ps.setString(1,String.valueOf((Pl.get(0))));
            ps.setString(2,String.valueOf(Pl.get(1)));
            ps.setString(3,String.valueOf(Pl.get(2)));
            ps.setString(4,String.valueOf(Pl.get(3)));

            ps.executeUpdate();
            System.out.println("done successfully \n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void updateResult(Integer t1, Integer t2,String name) {
            try {
             m.setBargozari(true);
                String sql1="update footbal.matchr set resultOne="+t1+",resultTow="+t2+",bargozari="+m.getBargozari()+" where name='" + name + "'";
                ps=ConnectionDB.getConnection().prepareStatement(sql1);
                ps.execute(sql1);

            } catch (SQLException e) {
                System.out.println(" not exist \n");
                e.printStackTrace();
            }
            System.out.println("done successfully  \n");
    }



    @Override
    public List findAll(){
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from footbal.matchr");
            while (resultSet.next()) {
                System.out.println("ID:>>>>    " +resultSet.getInt(1) + "     " +
                        "Team one:>>>>>    " +  resultSet.getString(2) + "     " +
                        "Team two:>>>>    " +  resultSet.getString(3) + "     " +
                        "name mosabegh:>>>>    " +   resultSet.getString(4)+"   ");
             status= resultSet.getString(5);
            if(status.equals("1") )
            { System.out.println("bargozar shode ast");}else if(status.equals("0"))
            { System.out.println("bargozar naashode ast");}
           ;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  List.of(resultSet);

    }


    @Override
    public List findByResult(int id) {
        ResultSet resultSet2 = null;
        try {
            resultSet2 = statement.executeQuery("select bargozari,resultOne,resultTow from footbal.matchr where ID="+ id);
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1));
                     resultone=resultSet2.getInt(2);
                    resulttwo=resultSet2.getInt(3);
            if((resultSet2.getInt(1)==1)){
                    m.setBargozari(true);
                System.out.println(id +"== bargozar shode va natije sabt shode ast");

            }else if(resultSet2.getInt(1)==0 || resultone.equals(null) & resulttwo.equals(null)){
                    m.setBargozari(false);
                    System.out.println(id + "ghabele pish bini bargozar nashode");
            }
           }

        } catch (SQLException e) {
            System.out.println(" not exist \n");
            e.printStackTrace();
        }
        return List.of(resultone,resulttwo);

    }
}
