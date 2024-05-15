package br.com.mfsdevsystem.model;

/**
 *
 * @author Marcelino
 */
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Aluno implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String cidade;
    private String telefone;
    private String curso;
    private Set<String> telefones = new HashSet<String>();
    
    public Aluno(){
        
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the telefones
     */
    public Set<String> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }
    
    
}
