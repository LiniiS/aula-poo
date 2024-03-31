package br.com.poo.estudo.caso1.pessoa;

//IMPORTAÇÃO DE PACOTES
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PessoaTeste {

    public static void main(String[] args) {

        //DECLARAÇÃO DE VARIÁVEL
        Pessoa pessoaOsvaldo = new Pessoa( "Osvaldo",
                                           "Renato Cardoso",
                                           "osvaldorenatocardoso@abbott.com",
                                           "Avenida Cláudio Osmar Silva",
                                           "(48) 3524-0705");

        //uso de classe já existente no Java
        System.out.println("Imprime os dados pessoais da pessoaOsvaldo: " + pessoaOsvaldo.getNome());
        System.out.println(pessoaOsvaldo.getDadosPessoaisFormatados());


        System.out.println("Inicializando a lista de contatos de " + pessoaOsvaldo.getNome());
        ArrayList<Pessoa> listaContatos = new ArrayList<>();
        pessoaOsvaldo.inicializaListaContatos(listaContatos);


//        System.out.println("Exibindo contatos na lista de contatos de " + pessoaOsvaldo.getNome());
//        for(Pessoa contato : listaContatos){
//            System.out.println(contato.getDadosPessoaisFormatados());
//        }

        System.out.println("Adicionando contato na lista de contatos de " + pessoaOsvaldo.getNome());
        Pessoa pessoaJosefa = new Pessoa(  "Josefa",
                                           "Rosa Aparício",
                                           "josefarosaaparicio@reisereis.com.br",
                                           "Avenida das Figueiras",
                                           "(66) 2916-7253");

        pessoaJosefa.adicionaPessoaAosContatos(pessoaJosefa, listaContatos);
        System.out.println("Exibindo contatos na lista de contatos de " + pessoaOsvaldo.getNome());
        for(Pessoa contato : listaContatos){
            System.out.println(contato.getDadosPessoaisFormatados());
        }

        System.out.println("Removendo contato na lista de contatos de " + pessoaOsvaldo.getNome());
        pessoaJosefa.removePessoaDosContatos(pessoaJosefa, listaContatos);

        System.out.println("Pesquisando contato na lista de contatos de " + pessoaOsvaldo.getNome());
        List<Pessoa> resultadoPesquisa = pessoaOsvaldo.pesquisaPorNome(pessoaJosefa.getNome(), listaContatos);
        for (Pessoa pessoa : resultadoPesquisa){
            System.out.println(pessoa.getDadosPessoaisFormatados());
        }

        List<Pessoa> resultadoPesquisa2 = pessoaOsvaldo.pesquisaPorNome("Nicolas", listaContatos);
        for (Pessoa pessoa : resultadoPesquisa2){
            System.out.println(pessoa.getDadosPessoaisFormatados());
        }


        System.out.println("Pesquisando contato na lista de contatos de " + pessoaOsvaldo.getNome());
        Predicate <Pessoa> atributo = p -> p.getEmail().equalsIgnoreCase("raimundo-peixoto84@poligerma.com.br");
        List<Pessoa> resultadoPesquisa3 = pessoaOsvaldo.pesquisaGenerica(atributo, listaContatos);
        for (Pessoa pessoa : resultadoPesquisa3){
            System.out.println(pessoa.getDadosPessoaisFormatados());
        }

        System.out.println("Exportanto os contatos de " + pessoaOsvaldo.getNome());
        Pessoa.exportarContatos(listaContatos, "ListaDeContatosDoOsvaldo");



    }
}