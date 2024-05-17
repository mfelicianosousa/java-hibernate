package br.com.mfsdevsystem.utils;

/**
 *
 * @author Marcelino
 */
import br.com.mfsdevsystem.model.Aluno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListarAluno {
   
     private static final Logger logger = LoggerFactory.getLogger(ListarAluno.class);
   
     public static void main(String[] args) {
        
        try
        { 
            /*
             Configuration configuration = new Configuration()
                     .setProperty("hibernate.connection.driver_class","org.postgresql.Driver")
                     .setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5433/javaHibernate?autorecconect=true")
                     .setProperty("hibernate.connection.username","postgres")
                     .setProperty("hibernate.connection.password","DBAdmPostgres")
                     .setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect")
                     .setProperty("hibernate.show_sql","true")
                     .setProperty("hibernate.format_sql","false")
                     .setProperty("hibernate.pool_size","10")
                     .setProperty("hibernate.hbm2ddl.auto","update")
                     .setProperty("hibernate.bytecode.use_reflection_optimizer","false")
                     .configure("hibernate.cfg.xml");
             */
             //SessionFactory fabrica = configuration.buildSessionFactory();
             
             //Session sessao = fabrica.openSession();
            
            Session sessao = HibernateUtil.getSession();
             
             Aluno obj_aluno = (Aluno) sessao.get(Aluno.class, 7);
             String dados_aluno = obj_aluno.getNome();
             
             // Carregando os dados do telefone
             Set<String> telefones = obj_aluno.getTelefones();
             int total_fones_aluno = telefones.size();
             
             Iterator it_telefones = telefones.iterator();
             String telefones_aluno = "";
             for (int i=0; i < total_fones_aluno; i++){
                 telefones_aluno = telefones_aluno+"\n Fone ["+(i+1)+"] "+it_telefones.next();
             }
             JOptionPane.showMessageDialog(null, "Nova forma de pegar dados: \n"
                       +"Nome Aluno: "+dados_aluno+"\n\n"+
                       "Telefones : "+total_fones_aluno+"\n"+
                       telefones_aluno);
             
             // percorrer a lista
             
             
             List<Aluno> lista_Alunos = new ArrayList();
        
             lista_Alunos = sessao.createQuery("from Aluno order by nome").list();      
         
             int tamanho_lista = lista_Alunos.size();
             String dados = "";
             for (int i=0; i < tamanho_lista; i++){
                 Aluno aluno = lista_Alunos.get(i);
                 dados = dados + '\n'+aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso();
                 System.out.println(aluno.getId()+" - "+aluno.getNome()+" - "+aluno.getCidade()+" - "+aluno.getCurso());
             }
             
             JOptionPane.showMessageDialog(null, dados);
             
             sessao.close();

             
         } catch (Exception e) {
             logger.error("Erro na listagem dos dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro de listagem de dados no banco de dados : "+e);
         } 
         
    }
    
}
