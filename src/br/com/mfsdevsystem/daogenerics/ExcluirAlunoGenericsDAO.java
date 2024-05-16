package br.com.mfsdevsystem.daogenerics;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcluirAlunoGenericsDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(ExcluirAlunoGenericsDAO.class);
   
     public static void main(String[] args) {
        
        try
        {   
             Aluno aluno = new Aluno();
        
             aluno.setId(12);
             
             GenericsDAO genericsDAO = new GenericsDAO( aluno );
             
             genericsDAO.delete();
             
             JOptionPane.showMessageDialog(null,"Registro Excluido com sucesso!");
             
         } catch (Exception e) {
             logger.error("Erro deletar dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de deletar dado no banco de dados : "+e);
         } 
         
    }
    
}
