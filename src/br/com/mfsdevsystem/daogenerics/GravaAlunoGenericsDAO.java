package br.com.mfsdevsystem.daogenerics;

/**
 *
 * @author Marcelino
 */

import br.com.mfsdevsystem.dao.*;
import br.com.mfsdevsystem.model.Aluno;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GravaAlunoGenericsDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaAlunoGenericsDAO.class);
   
     public static void main(String[] args) {
        
        try
        { 
          
             Aluno aluno = new Aluno();
             
             aluno.setNome("Maria Silva add DAOGenerics");
             aluno.setCidade("Rio de Janeiro");
             aluno.setTelefone("(21) 9968-4030");
             aluno.setCurso("DAOGenerics");
             
             // Coleção de dados de telefone
             Set<String> telefones = new HashSet<String>();
             telefones.add("(21) 97100-1218");
             telefones.add("(21) 97622-3020");
             aluno.setTelefones(telefones);
             
             GenericsDAO genericsDAO = new GenericsDAO(aluno);
             genericsDAO.add();
             
             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
    
}
