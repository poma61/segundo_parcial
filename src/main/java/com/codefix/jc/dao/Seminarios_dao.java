package com.codefix.jc.dao;

import com.codefix.jc.model.Seminarios;
import java.util.List;

public interface Seminarios_dao {

    public void insert(Seminarios seminarios) throws Exception;

    public void update(Seminarios seminarios) throws Exception;

    public void delete(int id) throws Exception;

    public Seminarios getById(int id) throws Exception;

    public List<Seminarios> select() throws Exception;
}
