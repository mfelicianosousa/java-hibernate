package br.com.mfsdevsystem.daogenerics;
/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import br.com.mfsdevsystem.model.Endereco;
import br.com.mfsdevsystem.model.Pessoa;
import java.time.LocalDate;
import javax.swing.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class EditaPessoaDAOGenerics {
   
     private static final Logger logger = LoggerFactory.getLogger(EditaPessoaDAOGenerics.class);
   
     public static void main(String[] args) {
        
        try
        { 
            Pessoa pessoa = new Pessoa();
            Endereco endereco = new Endereco();

            // Generator autoIncrement()
            pessoa.setId(1L);
            pessoa.setNome("Marcelino Feliciano de Sousa");
            pessoa.setCpf("07756074874");
            pessoa.setEmail("marcelino.feliciano@hotmail.com");
            pessoa.setSexo('M');
            pessoa.setTelefone("(65) 98141-3390");
            LocalDate data = LocalDate.of(1967,10,30);
            pessoa.setDataNascimento( data );
            pessoa.setTelefone("(65) 98141-3390");

            endereco.setCep("78088120");
            endereco.setLogradouro("Rua duzentos e hum");
            endereco.setNumero("6");
            endereco.setComplemento("Setor II, Quadra 3");
            endereco.setCidade("Cuiabá");
            endereco.setBairro("Tijucal");
            endereco.setEstado("MT");

            pessoa.setEndereco(endereco);


            GenericsDAO generics = new GenericsDAO( pessoa );
            generics.update();

             
         } catch (Exception e) {
             logger.error("Erro alteração de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de alteração dados no banco de dados : "+e);
         } 
         
    }
    
}
