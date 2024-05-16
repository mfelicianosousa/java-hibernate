package br.com.mfsdevsystem.dao;

/**
 *
 * @author Marcelino
 */

import br.com.mfsdevsystem.model.Aluno;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GravaAlunoDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaAlunoDAO.class);
   
     public static void main(String[] args) {
        
        try
        { 
          
             Aluno aluno = new Aluno();
             
             aluno.setNome("Marieta Severo");
             aluno.setCidade("São Paulo");
             aluno.setTelefone("(11) 65968-3390");
             aluno.setCurso("Atriz");
             
             // Coleção de dados de telefone
             Set<String> telefones = new HashSet<String>();
             telefones.add("(11) 980100-1218");
             telefones.add("(11) 97622-8084");
             aluno.setTelefones(telefones);
             
             AlunoDAO alunoDAO = new AlunoDAO();
             alunoDAO.addAluno(aluno);
             
             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
    
}
