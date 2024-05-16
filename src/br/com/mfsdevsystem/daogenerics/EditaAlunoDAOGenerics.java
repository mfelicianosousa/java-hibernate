package br.com.mfsdevsystem.daogenerics;
/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EditaAlunoDAOGenerics {
   
     private static final Logger logger = LoggerFactory.getLogger(EditaAlunoDAOGenerics.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Aluno aluno = new Aluno();
        
             aluno.setId(6);
             aluno.setNome("Analu Santos");
             aluno.setCidade("Cuiabá");
             aluno.setTelefone("(65) 99121-3191");
             aluno.setCurso("Update Generics");
             
             GenericsDAO generics = new GenericsDAO( aluno );
             generics.update();

             
         } catch (Exception e) {
             logger.error("Erro alteração de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de alteração dados no banco de dados : "+e);
         } 
         
    }
    
}
