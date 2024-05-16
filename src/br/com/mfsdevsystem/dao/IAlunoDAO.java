package br.com.mfsdevsystem.dao;

import br.com.mfsdevsystem.model.Aluno;
import java.util.List;

/**
 *
 * @author Marcelino
 */
public interface IAlunoDAO {
    
    public void addAluno(Aluno aluno);
    public void deleteAluno(Aluno aluno);
    public void updateAluno(Aluno aluno);
   // public Aluno getAluno(int id);
    public List getAllAlunos();
    
}