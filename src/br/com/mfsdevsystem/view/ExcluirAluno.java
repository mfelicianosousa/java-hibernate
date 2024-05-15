package br.com.mfsdevsystem.view;

/**
 *
 * @author Marcelino
 */
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
             Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
             SessionFactory fabrica = configuration.buildSessionFactory();
             Session sessao = fabrica.openSession();
             Aluno aluno = new Aluno();
        
             aluno.setId(3);
            
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
