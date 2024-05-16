package br.com.mfsdevsystem.daogenerics;

/**
 *
 * @author Marcelino
 */

import br.com.mfsdevsystem.model.Endereco;
import br.com.mfsdevsystem.model.Pessoa;
import java.time.LocalDate;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GravaPessoaGenericsDAO {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaPessoaGenericsDAO.class);
   
     public static void main(String[] args) {
        
        try
        { 
          
             Pessoa pessoa = new Pessoa();
             Endereco endereco = new Endereco();
             
             pessoa.setNome("Pedro Feliciano da Silva");
             pessoa.setCpf("01214567890");
             pessoa.setEmail("pedro.silva@gmail.com");
             pessoa.setSexo('M');
             pessoa.setTelefone("(65) 98240-3191");
            // LocalDate data = LocalDate.of(1980,07,15);
            // pessoa.setDataNascimento( data );
             pessoa.setTelefone("(65) 98070-2022");
             
             endereco.setCep("78088120");
             endereco.setLogradouro("Rua duzentos e hum");
             endereco.setNumero("6");
             endereco.setComplemento("Quadra 3 Setor II");
             endereco.setCidade("Cuiabá");
             endereco.setBairro("Tijucal");
             endereco.setEstado("MT");
             
             pessoa.setEndereco(endereco);
             
             GenericsDAO genericsDAO = new GenericsDAO(pessoa);
             genericsDAO.add();
             
             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
    
}
