/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Aluno;
import modelo.AlunoConvenio;
import modelo.AvaliacaoFisica;
import modelo.Convenio;
import modelo.Pessoa;
import modelo.Plano;
import modelo.Professor;



public class TesteHeranca {
    public static void main(String[] args) {
        // Configuração inicial
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        
        // ====================== 1. Criação de Professor ======================
        Professor professor = new Professor();
        professor.setNome("Mariana Costa");
        professor.setCpf("111.222.333-44");
        professor.setEspecializacao("Musculação");
        
        System.out.println("=== PROFESSOR ===");
        System.out.println(professor.exibirDados());
        
        // ====================== 2. Criação de Planos ======================
        Plano planoBasico = new Plano();
        planoBasico.setNome("Básico");
        planoBasico.setDescricao("Acesso à musculação e aulas coletivas");
        planoBasico.setValor(150.0);
        
        Plano planoPremium = new Plano();
        planoPremium.setNome("Premium");
        planoPremium.setDescricao("Acesso ilimitado + personal trainer");
        planoPremium.setValor(250.0);
        
        // ====================== 3. Criação de Convênio ======================
        Convenio convenioUnimed = new Convenio();
        convenioUnimed.setNome("Unimed");
        convenioUnimed.setDesconto(10); // 10% de desconto
        
        // ====================== 4. Teste com Aluno Regular ======================
        Aluno alunoRegular = new Aluno();
        alunoRegular.setNome("João da Silva");
        alunoRegular.setCpf("555.444.333-22");
        alunoRegular.setDataNascimento(LocalDate.parse("20/05/1992", formatoData));
        alunoRegular.setMatricula("ALU2023001");
        alunoRegular.setDataMatricula(dataAtual.minusMonths(2)); // 2 meses de matrícula
        alunoRegular.setPlano(planoBasico);
        
        // Adicionando avaliação física
        AvaliacaoFisica avaliacaoRegular = new AvaliacaoFisica(alunoRegular);
        avaliacaoRegular.setPeso(75.5);
        avaliacaoRegular.setAltura(1.78);
        avaliacaoRegular.setProfessor(professor);
        alunoRegular.adicionarAvaliacao(avaliacaoRegular);
        
        System.out.println("\n=== ALUNO REGULAR ===");
        System.out.println(alunoRegular.exibirDados());
        System.out.println("\nDetalhes da Avaliação:");
        System.out.println(avaliacaoRegular.exibirDados());
        
        // ====================== 5. Teste com Aluno Conveniado ======================
        AlunoConvenio alunoConveniado = new AlunoConvenio(convenioUnimed);
        alunoConveniado.setNome("Maria Oliveira");
        alunoConveniado.setCpf("666.777.888-99");
        alunoConveniado.setDataNascimento(LocalDate.parse("15/10/1988", formatoData));
        alunoConveniado.setMatricula("CONV2023001");
        alunoConveniado.setDataMatricula(dataAtual.minusMonths(5)); // 5 meses de matrícula
        alunoConveniado.setPlano(planoPremium);
        
        // Adicionando avaliação física
        AvaliacaoFisica avaliacaoConveniado = new AvaliacaoFisica(alunoConveniado);
        avaliacaoConveniado.setPeso(62.0);
        avaliacaoConveniado.setAltura(1.65);
        avaliacaoConveniado.setProfessor(professor);
        alunoConveniado.adicionarAvaliacao(avaliacaoConveniado);
        
        System.out.println("\n=== ALUNO CONVENIADO ===");
        System.out.println(alunoConveniado.exibirDados());
        System.out.println("\nDetalhes da Avaliação:");
        System.out.println(avaliacaoConveniado.exibirDados());
    }
}