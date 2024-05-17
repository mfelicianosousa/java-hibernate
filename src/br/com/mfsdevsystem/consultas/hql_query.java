/**
 *
 * @author Marcelino
 *
 */
package br.com.mfsdevsystem.consultas;

import br.com.mfsdevsystem.utils.HibernateUtil;
import br.com.mfsdevsystem.model.Aluno;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class hql_query {

    private static final Logger logger = LoggerFactory.getLogger(hql_query.class);

    public static void main(String[] args) {
        try {

            Session sessao = HibernateUtil.getSession();

            Query query = sessao.createQuery("from Aluno order by nome");
            List<Aluno> list_alunos = query.list();

            int tamanho_lista = list_alunos.size();
            String dados = "";
            for (int i = 0; i < tamanho_lista; i++) {

                Aluno aluno = list_alunos.get(i);

                dados = dados + '\n' + aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCidade() + " - " + aluno.getCurso();
                System.out.println(aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getCidade() + " - " + aluno.getCurso());
            }

            JOptionPane.showMessageDialog(null, dados);

            sessao.close();

        } catch (Exception e) {
            logger.error("Erro na listagem dos dado no banco de dados: " + e);
            JOptionPane.showMessageDialog(null, "Erro de listagem de dados no banco de dados : " + e);
        }
    }
}
