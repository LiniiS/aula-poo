package br.com.poo.estudo.caso6.polimorfismo;

public class FuncionarioHorista extends Funcionario{

    private double salarioPorHora;
    private double horasTrabalhadas;

    public FuncionarioHorista(String nome, String sobrenome, String cpf,
                              double salarioPorHora, double horasTrabalhadas) {
        super(nome, sobrenome, cpf);

        if(salarioPorHora < 0.0)
            throw new IllegalArgumentException("Valor do salarioPorHora inválido.");

        if((horasTrabalhadas < 0.0) || (horasTrabalhadas > 168.0))
            throw new IllegalArgumentException("Valor do salarioPorHora inválido.");

        this.salarioPorHora = salarioPorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        if(salarioPorHora < 0.0)
            throw new IllegalArgumentException("Valor do salarioPorHora inválido.");

        this.salarioPorHora = salarioPorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        if((horasTrabalhadas < 0.0) || (horasTrabalhadas > 168.0))
            throw new IllegalArgumentException("Valor do salarioPorHora inválido.");

        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double faturamento() {
        if (getHorasTrabalhadas() <= 40) //regra de hora extra - 40h = 1 semana 8horas/dia
            return getHorasTrabalhadas() * getSalarioPorHora();
        else
            //regra para calcular hora extra
            return 40 * getSalarioPorHora() + (getHorasTrabalhadas() - 40) * getSalarioPorHora() * 1.5;
    }

       @Override
       public String toString(){
         return String.format("Funcionário horista: %s%n%s: $%,.2f; %s: %,.2f",
            super.toString(), "Valor do Salário por Hora: ", getSalarioPorHora(),
           "Horas Trabalhadas", getHorasTrabalhadas());
        }
}
