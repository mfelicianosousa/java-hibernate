package br.com.mfsdevsystem.daogenerics;

/**
 *
 * @author Marcelino
 */


import br.com.mfsdevsystem.model.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListarAlunoDAOGenerics {
   
     private static final Logger logger = LoggerFactory.getLogger(ListarAlunoDAOGenerics.class);
   
     public static void main(String[] args) {
        
        try
        { 
            Aluno aluno = new Aluno();
            GenericsDAO generics = new GenericsDAO(aluno);
            List listAluno = new ArrayList();
            
            listAluno = generics.getAll();
            
            int size = listAluno.size();
            String dados = "";
            
            for (int i=0; i < size; i++){
                 aluno = (Aluno) listAluno.get(i);
                 dados = dados + '\n'+aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso();
                // System.out.println(aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso());
             }
             
             JOptionPane.showMessageDialog(null, dados);
             
             
         } catch (Exception e) {
             logger.error("Erro na listagem dos dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de listagem de dados no banco de dados : "+e);
         } 
         
    }
    
}
