package jdbc;


import java.util.ArrayList;
import java.util.List;

public interface jdbc<T> {
     void save(ArrayList<T> P);
     void updateResult(Integer t1,Integer t2,String id);
      List<T> findAll();
    T findByResult(int name);

}
