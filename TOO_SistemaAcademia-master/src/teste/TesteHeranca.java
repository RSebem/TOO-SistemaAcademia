package teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Aluno;
import modelo.AvaliacaoFisica;
import modelo.Plano;
import modelo.Professor;

public class TesteHeranca {
    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Criar plano
        Plano p1 = new Plano("Premium", "Acesso total", 150.00);
        Plano p2 = new Plano("Básico", "Acesso limitado", 100.00);
        
        // Criar professor
        Professor prof = new Professor();
        prof.setNome("Juka");
        prof.setCpf("123.123.123-67");
        prof.setEspecializacao("Musculação");
        
        // Aluno com direito a desconto (matriculado há mais de 3 meses)
        Aluno a1 = new Aluno();
        a1.setNome("Carlos");
        a1.setMatricula("001");
        a1.setDataMatricula(LocalDate.parse("02/01/2025", formato));
        a1.setPlano(p1);
        
        // Avaliação física para o aluno 1
        AvaliacaoFisica av1 = new AvaliacaoFisica(a1);
        av1.setProfessor(prof);
        av1.setPeso(75.5);
        av1.setAltura(1.78);
        a1.adicionarAvaliacao(av1);
        
        // Aluno sem direito a desconto (matriculado recentemente)
        Aluno a2 = new Aluno();
        a2.setNome("Ana");
        a2.setMatricula("002");
        a2.setDataMatricula(LocalDate.parse("07/05/2025", formato));
        a2.setPlano(p2);
        
        // Exibir dados
        System.out.println("=== ALUNO COM DESCONTO ===");
        System.out.println(a1.exibirDados());
        System.out.println("\n=== ALUNO SEM DESCONTO ===");
        System.out.println(a2.exibirDados());
        
        // Verificar desconto manualmente após algum tempo
        System.out.println("\n=== VERIFICANDO DESCONTO MANUALMENTE ===");
        a2.verificaDesconto();
        System.out.println(a2.exibirDados());
    }
}