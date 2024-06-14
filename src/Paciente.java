import java.util.Scanner;

public class Paciente 
{
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String sintomas;
    private EnumUrgencia urgencia;

    public Paciente(String nome, String cpf, String telefone, String endereco, String sintomas, EnumUrgencia urgencia) 
    {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sintomas = sintomas;
        this.urgencia = urgencia;
    }

    // Getters
    public String getNome() 
    {
        return nome;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public String getTelefone() 
    {
        return telefone;
    }

    public String getEndereco() 
    {
        return endereco;
    }

    public String getSintomas() 
    {
        return sintomas;
    }

    public EnumUrgencia getUrgencia() 
    {
        return urgencia;
    }

    // Setters
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }

    public void setSintomas(String sintomas) 
    {
        this.sintomas = sintomas;
    }

    public void setUrgencia(EnumUrgencia urgencia) 
    {
        this.urgencia = urgencia;
    }

    // Método para registrar um novo paciente
    public static Paciente registrarPaciente(Scanner scanner) 
    {
        System.out.println("Digite o nome do Paciente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o CPF do Paciente:");
        String cpf = scanner.nextLine();

        System.out.println("Digite o telefone do Paciente:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o endereço do Paciente:");
        String endereco = scanner.nextLine();

        System.out.println("Digite os sintomas do Paciente:");
        String sintomas = scanner.nextLine();

        System.out.println("Digite a urgência do Paciente (1 para Atendimento imediato, 2 para Muito Urgente, 3 para Urgente, 4 para Pouco Urgente ou 5 para Não Urgente):");
        int urgenciaInt = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        EnumUrgencia urgencia;
        try {
            urgencia = EnumUrgencia.fromInt(urgenciaInt);
        } catch (IllegalArgumentException e) {
            System.out.println("Urgência inválida. Definindo como Não Urgente.");
            urgencia = EnumUrgencia.NAO_URGENTE;
        }

        return new Paciente(nome, cpf, telefone, endereco, sintomas, urgencia);
    }

    @Override
    public String toString() 
    {
        return "Dados do Paciente" +
                "\nNome:'" + nome + '\'' +
                "\nCPF:'" + cpf + '\'' +
                "\nTelefone:'" + telefone + '\'' +
                "\nEndereco:'" + endereco + '\'' +
                "\nSintomas:'" + sintomas + '\'' +
                "\nUrgência: " + urgencia.getDescricao();
    }

    public String toStringNome() 
    {
        return nome;
    }
}
