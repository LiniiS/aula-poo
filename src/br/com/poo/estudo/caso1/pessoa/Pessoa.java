//ESPECIFICAÇÃO DO PACOTE ONDE A CLASSE PESSOA SE ENCONTRA
package br.com.poo.estudo.caso1.pessoa;

//IMPORTAÇÃO DE PACOTES INTERESSANTES PARA O CONTEXTO
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// DECLARAÇÃO DE UMA CLASSE
public class Pessoa {

    // DECLARAÇÃO DE ATRIBUTOS
    private String nome;
    private String sobrenome;
    private String email;
    private String endereco;
    private String telefone;

    //DECLARAÇÃO DE MÉTODO CONSTRUTOR
    public Pessoa(String nome, String sobrenome, String email, String endereco, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //DECLARAÇÃO DE MÉTODOS AUXILIARES
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //DECLARAÇÃO DE MÉTODOS DA CLASSE OBJECT
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome) && Objects.equals(sobrenome, pessoa.sobrenome) && Objects.equals(email, pessoa.email) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(telefone, pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, email, endereco, telefone);
    }

    //DECLARAÇÃO DE MÉTODOS ESPECÍFICOS DE UMA PESSOA NO CONTEXTO DE UMA AGENDA DE CONTATOS
    public String getDadosPessoaisFormatados() {
        return "Pessoa {" +
                "\n\tnome='" + nome + '\'' +
                ",\n\tsobrenome='" + sobrenome + '\'' +
                ",\n\temail='" + email + '\'' +
                ",\n\tendereco='" + endereco + '\'' +
                ",\n\ttelefone='" + telefone + '\'' +
                "\n}";
    }

    //Comportamentos específicos de uma Pessoa em um contexto de agenda de contatos

    /**
     * Método que verifica se duas pessoas são a mesma pessoa com base
     * no nome, número de telefone e email
     *
     * @param outraPessoa
     * @return true ou false
     */
    public boolean verificaPessoa(Pessoa outraPessoa){
        return  this.nome.equals(outraPessoa.getNome()) &&
                this.telefone.equals(outraPessoa.getTelefone()) &&
                this.email.equals(outraPessoa.getEmail());
    }

    /**
     * Método que adiciona uma pessoa à lista de contatos, verificando se
     * o contato a ser adicionado já existe na lista
     * @param pessoa
     * @param contatos
     */
    public void adicionaPessoaAosContatos(Pessoa pessoa, ArrayList<Pessoa> contatos){
        if(!contatos.contains(pessoa)){
            contatos.add(pessoa);
            System.out.println(pessoa.getNome() + " adicionado(a) aos contatos!");
        }else{
            System.out.println("Pessoa com mesmos dados já existe na sua lista de contatos.");
        }
    }

    /**
     * Método que remove uma pessoa existente na lista de contatos
     * @param pessoa
     * @param contatos
     */
    public void removePessoaDosContatos(Pessoa pessoa, ArrayList<Pessoa> contatos){
        Optional<Pessoa> possivelRegistroDeContato = contatos.stream()
                .filter(p -> pessoa.getNome().equals(p.getNome()) && pessoa.getTelefone().equals(p.getTelefone()))
                .findFirst();

        if (possivelRegistroDeContato.isPresent()) {
            Pessoa registroEncontrado = possivelRegistroDeContato.get();
            contatos.remove(registroEncontrado);
            System.out.println(pessoa.getNome() + " removido(a) dos contatos!");
        } else {
            System.out.println("Pessoa com o nome " + pessoa.getNome() + " não encontrada na lsita de contatos!");
        }
    }

    public List<Pessoa> pesquisaPorNome(String nome, List<Pessoa> contatos) {
        List<Pessoa> resultadosDaPesquisa = contatos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());

        if (resultadosDaPesquisa.isEmpty()) {
            System.out.println("Nenhum contato encontrado com esse nome.");
        }

        return resultadosDaPesquisa;
    }



    /**
     * Pesquisa genérica para buscar um contato com base em um atributo da pessoa
     * @param atributo
     * @param contatos
     * @return
     */
    public List<Pessoa> pesquisaGenerica(Predicate<Pessoa> atributo, List<Pessoa> contatos){
        return contatos.stream()
                .filter(atributo)
                .collect(Collectors.toList());
    }


    public static void exportarContatos(List<Pessoa> contatos, String nomeDoArquivo) {
        try (FileWriter writer = new FileWriter(nomeDoArquivo)) {

            writer.append("Nome,Sobrenome,Email,Endereco,Telefone\n");

            for (Pessoa pessoa : contatos) {
                writer.append(String.join(",", pessoa.getNome(), pessoa.getSobrenome(), pessoa.getEmail(),
                        pessoa.getEndereco(), pessoa.getTelefone()));
                writer.append("\n");
            }

            System.out.println("Contatos foram exportados com sucesso!");
        } catch (IOException e) {
            System.err.println("Houve um erro ao exportar os contatos: " + e.getMessage());
        }
    }




    public  void inicializaListaContatos(ArrayList<Pessoa> contatos){
        contatos.add(PessoaFactory.criarPessoa("Larissa", "Alves", "larissa.vitoria.alves@imeio.com", "Travessa P-5", "(95) 99210-4692"));
        contatos.add(PessoaFactory.criarPessoa("Raimundo", "Peixoto", "raimundo-peixoto84@poligerma.com.br", "Rua Salvador Gurgel do Amaral", "(84) 2719-8734"));
        contatos.add(PessoaFactory.criarPessoa("Andreia", "Baptista", "andreia_baptista@magicday.com.br", "Alameda Waldemar José Viana", "(96) 2626-0827"));
        contatos.add(PessoaFactory.criarPessoa("Otávio", "Oliver", "otavio_alves@mirafactoring.com.br", "Rua S", "(69) 2558-8536"));
        contatos.add(PessoaFactory.criarPessoa("Leandro", "Bernardes", "leandrofabiobernardes@jglima.com.br", "Rua Álvaro Maia", "(95) 2547-0330"));
        contatos.add(PessoaFactory.criarPessoa("Nicolas", "Thales", "nicolas_thales_jesus@tafeta.com.br", "Rua Eugênia Cândido do Nascimento", "(43) 98368-3775"));

    }

}