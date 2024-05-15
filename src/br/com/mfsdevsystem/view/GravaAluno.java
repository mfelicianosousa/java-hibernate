package br.com.mfsdevsystem.view;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GravaAluno {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaAluno.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
             SessionFactory fabrica = configuration.buildSessionFactory();
             Session sessao = fabrica.openSession();
             Aluno aluno = new Aluno();
             
             // Generator autoIncrement()
             // aluno.setId(3);
             aluno.setNome("Aluno2 Set Hash");
             aluno.setCidade("Cuiabá");
             aluno.setTelefone("(65) 98141-3390");
             aluno.setCurso("Tratorista");
             
             // Coleção de dados de telefone
             Set<String> telefones = new HashSet<String>();
             telefones.add("(65) 98114-9484");
             telefones.add("(65) 99621-9094");
           //  telefones.add("(65) 9655-9484");
             aluno.setTelefones(telefones);
             
             Transaction transaction = sessao.beginTransaction();
             sessao.saveOrUpdate(aluno);
             transaction.commit();
             sessao.close();

             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
    
}
