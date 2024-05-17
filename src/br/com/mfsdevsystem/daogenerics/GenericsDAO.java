package br.com.mfsdevsystem.daogenerics;

import br.com.mfsdevsystem.utils.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcelino
 */


public class GenericsDAO<T> implements IGenericsDAO{

    private final T entity;
    private final Session session;
    private Transaction transaction = null;
    
    public GenericsDAO(T entity){
       this.session = HibernateUtil.getSession();
       this.entity = entity;
    }
    
    @Override
    public void add(){  
       try{
          transaction = session.beginTransaction();
          session.save( entity );
          transaction.commit();
       } catch (HibernateException ex){
          JOptionPane.showMessageDialog(null, "Erro na inserção ("+ex+")");
          transaction.rollback();
       }
    }

    

    @Override
    public void delete() {
      try{
          transaction = session.beginTransaction();
          session.delete( entity );
          transaction.commit();
       } catch (HibernateException ex){
          JOptionPane.showMessageDialog(null, "Erro na exclusão ("+ex+")");
          transaction.rollback();
       }
    
    }

    @Override
    public void update() {
       try {
          transaction = session.beginTransaction();
          session.saveOrUpdate( entity );
          transaction.commit();
       } catch (HibernateException ex){
                JOptionPane.showMessageDialog(null, "Erro de atualização ("+ex+")");
               transaction.rollback();
       }
    }

    @Override
    public List getAll() {
      
        List list = session.createQuery("from "+entity.getClass().getName()).list();
        
        return list;
    
    }

    
}
