import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilaAtendimento {
    private List<Paciente> filaMuitoUrgente;
    private List<Paciente> filaUrgente;
    private List<Paciente> filaPoucoUrgente;
    private List<Paciente> filaNaoUrgente;
    private List<Paciente> filaAtendidos;

    public FilaAtendimento() {
        this.filaMuitoUrgente = new ArrayList<>();
        this.filaUrgente = new ArrayList<>();
        this.filaPoucoUrgente = new ArrayList<>();
        this.filaNaoUrgente = new ArrayList<>();
        this.filaAtendidos = new ArrayList<>();
    }

    public void adicionarPaciente(Paciente paciente) 
    {
        switch (paciente.getUrgencia()) 
        {
            case IMEDIATO:
                filaAtendidos.add(paciente);
                System.out.println("Paciente atendido imediatamente.");
                break;
            case MUITO_URGENTE:
                filaMuitoUrgente.add(paciente);
                System.out.println("Paciente muito urgente adicionado a fila de atendimento.");
                break;
            case URGENTE:
                filaUrgente.add(paciente);
                System.out.println("Paciente urgente adicionado a fila de atendimento.");
                break;
            case POUCO_URGENTE:
                filaPoucoUrgente.add(paciente);
                System.out.println("Paciente pouco urgente adicionado a fila de atendimento.");
                break;
            case NAO_URGENTE:
                filaNaoUrgente.add(paciente);
                System.out.println("Paciente não urgente adicionado a fila de atendimento.");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public Paciente consultarPaciente(String cpf) {
        // Primeiro, verifica na fila muito urgente
        for (Paciente p : filaMuitoUrgente) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        // Em seguida, verifica na fila urgente
        for (Paciente p : filaUrgente) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        // Depois, verifica na fila pouco urgente
        for (Paciente p : filaPoucoUrgente) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        // Por fim, verifica na fila não urgente
        for (Paciente p : filaNaoUrgente) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        // Se não encontrado nas filas de espera, verifica na lista de atendidos
        for (Paciente p : filaAtendidos) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }

        System.out.println("CPF não encontrado.");
        return null; // Retorna null se paciente com CPF não for encontrado
    }

    public void atenderProximo() {
        if (!filaMuitoUrgente.isEmpty()) {
            Paciente pacienteAtendido = filaMuitoUrgente.remove(0);
            filaAtendidos.add(pacienteAtendido);
            System.out.println("Atendendo Muito Urgente: " + pacienteAtendido.toStringNome());
            reorganizarFila(filaMuitoUrgente);
        } else if (!filaUrgente.isEmpty()) {
            Paciente pacienteAtendido = filaUrgente.remove(0);
            filaAtendidos.add(pacienteAtendido);
            System.out.println("Atendendo Urgente: " + pacienteAtendido.toStringNome());
            reorganizarFila(filaUrgente);
        } else if (!filaPoucoUrgente.isEmpty()) {
            Paciente pacienteAtendido = filaPoucoUrgente.remove(0);
            filaAtendidos.add(pacienteAtendido);
            System.out.println("Atendendo Pouco Urgente: " + pacienteAtendido.toStringNome());
            reorganizarFila(filaPoucoUrgente);
        } else if (!filaNaoUrgente.isEmpty()) {
            Paciente pacienteAtendido = filaNaoUrgente.remove(0);
            filaAtendidos.add(pacienteAtendido);
            System.out.println("Atendendo Não Urgente: " + pacienteAtendido.toStringNome());
            reorganizarFila(filaNaoUrgente);
        } else {
            System.out.println("Nenhum paciente para atender.");
        }
    }

    private void reorganizarFila(List<Paciente> fila) {
        if (!fila.isEmpty()) {
            // Rotaciona a lista para que o próximo paciente se torne o primeiro
            Collections.rotate(fila, -1);
        }
    }

    public void mostrarFila() {
        System.out.println("===== Fila de Atendimento =====");
        mostrarFilaPorTipo(filaMuitoUrgente, "Muito Urgente");
        mostrarFilaPorTipo(filaUrgente, "Urgente");
        mostrarFilaPorTipo(filaPoucoUrgente, "Pouco Urgente");
        mostrarFilaPorTipo(filaNaoUrgente, "Não Urgente");
        System.out.println("===============================");
    }

    private void mostrarFilaPorTipo(List<Paciente> fila, String tipo) {
        if (!fila.isEmpty()) 
        {
            for (Paciente paciente : fila) 
            {
                System.out.println(paciente.toStringNome());
            }
        }
    }

    public void mostrarFilaAtendidos() {
        System.out.println("Pacientes Atendidos:");
        for (Paciente p : filaAtendidos) {
            System.out.println(p.toStringNome());
        }
    }
}
