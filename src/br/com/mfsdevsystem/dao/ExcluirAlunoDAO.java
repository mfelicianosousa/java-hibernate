package br.com.mfsdevsystem.dao;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcluirAlunoDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(ExcluirAlunoDAO.class);
   
     public static void main(String[] args) {
        
        try
        {   
             Aluno aluno = new Aluno();
        
             aluno.setId(9);
             
             AlunoDAO alunoDAO = new AlunoDAO();
             
             alunoDAO.deleteAluno(aluno);
             JOptionPane.showMessageDialog(null,"Aluno Excluido com sucesso!");
             
         } catch (Exception e) {
             logger.error("Erro deletar dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de deletar dados no banco de dados : "+e);
         } 
         
    }
    
}
