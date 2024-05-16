package br.com.mfsdevsystem.daogenerics;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListarPessoaDAOGenerics {
   
     private static final Logger logger = LoggerFactory.getLogger(ListarPessoaDAOGenerics.class);
   
     public static void main(String[] args) {
        
        try
        { 
            Pessoa pessoa = new Pessoa();
            GenericsDAO generics = new GenericsDAO(pessoa);
            List listPessoa = new ArrayList();
            
            listPessoa = generics.getAll();
            
            int size = listPessoa.size();
            String dados = "";
            
            for (int i=0; i < size; i++){
                 pessoa = (Pessoa) listPessoa.get(i);
                 dados = dados + '\n'+pessoa.getId()+" - "+pessoa.getNome()+" - "+pessoa.getEndereco().getCidade()+" - "+pessoa.getEndereco().getEstado();
                // System.out.println(aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso());
             }
             
             JOptionPane.showMessageDialog(null, dados);
             
             
         } catch (Exception e) {
             logger.error("Erro na listagem dos dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de listagem de dados no banco de dados : "+e);
         } 
         
    }
    
}
