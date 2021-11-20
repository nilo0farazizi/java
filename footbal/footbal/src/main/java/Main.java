import jdbc.ConnectionDB;
import model.MyScanner;

public class Main {

    public static void main(String[] args){
      ConnectionDB  jdbc= ConnectionDB.getInstance();
       new MyScanner();
    }
}
