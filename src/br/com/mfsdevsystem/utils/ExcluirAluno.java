package br.com.mfsdevsystem.utils;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.view.*;
import br.com.mfsdevsystem.model.Aluno;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcluirAluno {
   
     private static final Logger logger = LoggerFactory.getLogger(ExcluirAluno.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Session sessao = HibernateUtil.getSession();
             Aluno aluno = new Aluno();
        
             aluno.setId(8);
            
             Transaction transaction = sessao.beginTransaction();
             sessao.delete( aluno );
             transaction.commit();
             sessao.close();

             
         } catch (Exception e) {
             logger.error("Erro alteração de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de alteração dados no banco de dados : "+e);
         } 
         
    }
    
}
