/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;


public class Aluno extends Pessoa {

    protected String matricula;
    protected List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
    protected Plano plano;
    protected double valorMensalidade;
    protected LocalDate dataMatricula;

    public void adicionarAvaliacao(AvaliacaoFisica avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public String mostrarAvaliacoes() {
        String aux = "Histórico de Avaliações: \n";
        for (AvaliacaoFisica cadaAvaliacao : avaliacoes) {
            aux += "->> " + cadaAvaliacao + "\n";
        }
        return aux;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
public String exibirDados() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String aux = super.exibirDados();
    aux += "\nMatricula: " + matricula;
    
    if (dataMatricula != null) {
        aux += "\nData de Matrícula: " + formato.format(dataMatricula);
    }
    
    aux += "\nAvaliações Físicas Realizadas: " + avaliacoes.size();
    
    if (plano != null) {
        // Formata o valor para R$ XX,XX
        String valorFormatado = String.format("R$ %.2f", valorMensalidade);
        aux += "\nPlano: " + plano.getNome() + " - " + valorFormatado;
    }
    
    return aux;
}

    public List<AvaliacaoFisica> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoFisica> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
        verificaDesconto();

    }

    public void verificaDesconto() {
        int anos = Period.between(dataMatricula, LocalDate.now())
                .getYears();
        int meses = Period.between(dataMatricula, LocalDate.now())
                .getMonths();
        
        meses += (anos*12);

        if (plano != null) {
            valorMensalidade = plano.getValor();

            if (meses >= 3) {
                valorMensalidade -= (valorMensalidade * 0.1);
            } else {

                System.out.println("Aluno não possui tempo para desconto");
            }
        } else {
            System.out.println("Aluno não possui plano selecionado. Informe o plano do aluno");
        }

    }

}
