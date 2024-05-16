package br.com.mfsdevsystem.daogenerics;

import java.util.List;

/**
 *
 * @author Marcelino
 */
public interface IGenericsDAO {

    public void add();
    public void delete();
    public void update();
   // public Aluno getAluno(int id);
    public List getAll();
    
}