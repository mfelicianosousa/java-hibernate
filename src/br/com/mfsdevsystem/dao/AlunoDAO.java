package br.com.mfsdevsystem.dao;

import br.com.mfsdevsystem.model.Aluno;
import br.com.mfsdevsystem.Utils.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcelino
 */


public class AlunoDAO implements IAlunoDAO {

    private final Session session;
    private Transaction transaction = null;
    
    public AlunoDAO(){
       this.session = HibernateUtil.getSession();
    }
    
    @Override
    public void addAluno(Aluno aluno) {
      try{
         transaction = session.beginTransaction();
         session.save(aluno);
         transaction.commit();
      } catch (HibernateException ex){
          JOptionPane.showMessageDialog(null, "Erro na inserção de Aluno ("+ex+")");
          transaction.rollback();
      }
    }

    @Override
    public void deleteAluno(Aluno aluno) {
        try {
            transaction = session.beginTransaction();
            session.delete( aluno );
            transaction.commit();
        } catch (HibernateException ex){
          JOptionPane.showMessageDialog(null, "Erro na exclusão de Aluno ("+ex+")");
          transaction.rollback();
      }
    }

    @Override
    public void updateAluno(Aluno aluno) {
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(aluno);
            transaction.commit();
        } catch (HibernateException ex){
          JOptionPane.showMessageDialog(null, "Erro na alteração de Aluno ("+ex+")");
          transaction.rollback();
      }
  
    }

    @Override
    public List<Aluno> getAllAlunos() {
      
        transaction = session.beginTransaction();
        List listAlunos = session.createQuery("from Aluno order by nome").list();
        // transaction.
        return listAlunos;
    }
    
}
