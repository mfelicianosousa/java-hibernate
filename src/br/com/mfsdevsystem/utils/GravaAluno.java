package br.com.mfsdevsystem.utils;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GravaAluno {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaAluno.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Session sessao = HibernateUtil.getSession();
             Aluno aluno = new Aluno();
             
             // Generator autoIncrement()

             aluno.setNome("Antonio Silva Sa");
             aluno.setCidade("Cuiabá");
             aluno.setTelefone("(65) 98141-3390");
             aluno.setCurso("Maquinista");
             
             // Coleção de dados de telefone
             Set<String> telefones = new HashSet<String>();
             telefones.add("(65) 980100-1218");
             telefones.add("(65) 97622-8084");
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
