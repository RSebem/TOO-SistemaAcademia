
package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Pessoa {

    // atributos
    private LocalDate dataNascimento;
    private String nome;
    private String CPF;
    

    //construtores
    Pessoa(String n) {
        nome = n;
    }

    Pessoa() {

    }

    Pessoa(String nome, String CPF) {
        this.nome = nome;
        setCpf(CPF);
    }

    // métodos
    public String exibirDados() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String aux = "Dados da Pessoa cadastrada: \n";
        aux += "Nome: " + nome + "\n";
        if (CPF != null) {
            aux += "CPF: " + CPF + "\n";
        }
        if (dataNascimento != null) {
            aux += "Data de Nascimento: " + formato.format(dataNascimento);
        }
        
        return aux;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "").trim();
        if (cpf != null && cpf.length() == 11) {
            this.CPF = cpf;
        } else {
            System.out.println("CPF inválido.");
        }
    }

    public void setDataNascimento(LocalDate dtN) {
        dataNascimento = dtN;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
