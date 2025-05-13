
package modelo;


public class Professor extends Pessoa {

    private String especializacao;

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String exibirDados() {
        String aux = super.exibirDados();
        aux += "\nEspecialização: "+especializacao;
        return aux;
    }
}
