package br.com.mfsdevsystem.dao;

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


public class ListarAluno {
   
     private static final Logger logger = LoggerFactory.getLogger(ListarAluno.class);
   
     public static void main(String[] args) {
        
        try
        { 
            AlunoDAO alunoDAO = new AlunoDAO();
            List listAluno = new ArrayList();
            
            listAluno = alunoDAO.getAllAlunos();
            
            int size = listAluno.size();
            String dados = "";
            
            for (int i=0; i < size; i++){
                 Aluno aluno = (Aluno) listAluno.get(i);
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
