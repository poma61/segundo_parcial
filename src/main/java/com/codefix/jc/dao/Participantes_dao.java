
package com.codefix.jc.dao;
import com.codefix.jc.model.Participantes;

import java.util.List;


public interface Participantes_dao {
     public void  insert(Participantes participantes) throws Exception;
  public void update(Participantes participantes) throws Exception;   
  public  void delete(int id) throws Exception;
public Participantes  getById(int id) throws Exception;
public List<Participantes> select() throws Exception;
    
}