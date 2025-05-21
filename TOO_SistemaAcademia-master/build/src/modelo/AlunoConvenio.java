/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.time.Period;


public class AlunoConvenio extends Aluno{
    private Convenio convenio;

    public AlunoConvenio(Convenio convenio) {
       this.convenio = convenio;
    }
    
    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    @Override
    public void setPlano(Plano plano) {
        super.plano = plano;
        verificaDesconto();
    }

    @Override
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
            
            if(convenio != null){
                valorMensalidade -= (convenio.getDesconto()/100)*plano.getValor();
            } 
            
            
        } else {
            System.out.println("Aluno não possui plano selecionado. Informe o plano do aluno");
        }

        
    }
    @Override
public String exibirDados() {
    String aux = super.exibirDados(); // Chama o método da classe Aluno
    
    if (convenio != null) {
        aux += "\nConvênio: " + convenio.getNome() + " - " + 
               convenio.getDesconto() + "%";
    }
    
    return aux;
}
    
    
    
}
