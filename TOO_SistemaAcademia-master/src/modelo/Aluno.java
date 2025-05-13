package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private LocalDate dataMatricula;
    private Plano plano;
    private double valorMensalidade;
    private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

    // Método para verificar desconto
    public void verificaDesconto() {
        if (dataMatricula != null && plano != null) {
            Period periodo = Period.between(dataMatricula, LocalDate.now());
            if (periodo.toTotalMonths() >= 3) {
                valorMensalidade = plano.getValor() * 0.9; // 10% de desconto
            } else {
                valorMensalidade = plano.getValor();
            }
        }
    }

    // Setter do plano que já verifica desconto
    public void setPlano(Plano plano) {
        this.plano = plano;
        this.verificaDesconto();
    }

    // Setter da data de matrícula que pode afetar o desconto
    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
        if (plano != null) {
            this.verificaDesconto();
        }
    }

    // Getters
    public Plano getPlano() {
        return plano;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    // Métodos existentes (mantidos)
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

    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        aux += "\nMatricula: " + matricula;
        if (plano != null) {
            aux += "\nPlano: " + plano.getNome();
            aux += "\nValor Mensalidade: R$ " + String.format("%.2f", valorMensalidade);
            if (valorMensalidade < plano.getValor()) {
                aux += " (com desconto de 10%)";
            }
        }
        aux += "\nAvaliações Físicas Realizadas: " + avaliacoes.size() + "\n";
        return aux;
    }

    // Outros getters e setters existentes
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}