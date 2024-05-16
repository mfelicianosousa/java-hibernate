package br.com.mfsdevsystem.daogenerics;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import br.com.mfsdevsystem.model.Pessoa;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcluirPessoaGenericsDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(ExcluirPessoaGenericsDAO.class);
   
     public static void main(String[] args) {
        
        try
        {   
             Pessoa pessoa = new Pessoa();
        
             pessoa.setId(3l);
             
             GenericsDAO genericsDAO = new GenericsDAO( pessoa );
             
             genericsDAO.delete();
             
             JOptionPane.showMessageDialog(null,"Registro Excluido com sucesso!");
             
         } catch (Exception e) {
             logger.error("Erro deletar dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de deletar dado no banco de dados : "+e);
         } 
         
    }
    
}
