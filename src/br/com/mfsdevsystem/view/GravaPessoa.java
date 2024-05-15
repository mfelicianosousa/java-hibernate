package br.com.mfsdevsystem.view;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.view.GravaAluno;
import br.com.mfsdevsystem.model.Aluno;
import br.com.mfsdevsystem.model.Endereco;
import br.com.mfsdevsystem.model.Pessoa;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GravaPessoa {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaAluno.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
             SessionFactory fabrica = configuration.buildSessionFactory();
             Session sessao = fabrica.openSession();
             Pessoa pessoa = new Pessoa();
             Endereco endereco = new Endereco();
             
             // Generator autoIncrement()
             // pessoa.setId(3);
             pessoa.setNome("Marcelino Feliciano de Sousa");
             pessoa.setCpf("07756074874");
             pessoa.setEmail("marcelino@gmail.com");
             pessoa.setSexo('M');
             pessoa.setTelefone("(65) 98141-3390");
             LocalDate data = LocalDate.of(1967,10,30);
             pessoa.setDataNascimento( data );
             pessoa.setTelefone("(65) 98141-3390");
             
             endereco.setCep("78088120");
             endereco.setLogradouro("Rua duzentos e hum");
             endereco.setNumero("6");
             endereco.setComplemento("Quadra 3 Setor II");
             endereco.setCidade("Cuiabá");
             endereco.setBairro("Tijucal");
             endereco.setEstado("MT");
             
             pessoa.setEndereco(endereco);
             
            // Gravar o registro pessoa
             Transaction transaction = sessao.beginTransaction();
             sessao.saveOrUpdate(pessoa);
             transaction.commit();
             sessao.close();

             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
    
}
