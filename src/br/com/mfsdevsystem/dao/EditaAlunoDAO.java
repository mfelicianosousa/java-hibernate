package br.com.mfsdevsystem.dao;
/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EditaAlunoDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(EditaAlunoDAO.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Aluno aluno = new Aluno();
        
             aluno.setId(6);
             aluno.setNome("Analu Santos Feliciano");
             aluno.setCidade("Cuiabá");
             aluno.setTelefone("(65) 99121-3191");
             aluno.setCurso("Inglês Nível I");
             
             AlunoDAO alunoDAO = new AlunoDAO();
             alunoDAO.updateAluno(aluno);

             
         } catch (Exception e) {
             logger.error("Erro alteração de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de alteração dados no banco de dados : "+e);
         } 
         
    }
    
}
