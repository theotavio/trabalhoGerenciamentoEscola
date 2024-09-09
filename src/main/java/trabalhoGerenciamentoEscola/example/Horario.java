package trabalhoGerenciamentoEscola.example;
import java.util.HashMap;

public class Horario{
    // Atributos
    private int horaInicio;
    private int horaFim;
    private String diaDaSemana;
    private HashMap<Integer, String> diaSemana;

    // Construtor
    public Horario(int horaInicio, int horaFim, String diaDaSemana){
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.diaDaSemana = diaDaSemana;
        this.diaSemana = new HashMap<>();
        preencherMapDiaSemana();
    }

    // Getters e Setters
    public int getHoraInicio(){
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio){
        this.horaInicio = horaInicio;
    }

    public int getHoraFim(){
        return horaFim;
    }

    public void setHoraFim(int horaFim){
        this.horaFim = horaFim;
    }

    public String getDiaDaSemana(){
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana){
        this.diaDaSemana = diaDaSemana;
    }

    public HashMap<Integer, String> getDiaSemana(){
        return diaSemana;
    }

    // Metodo para preencher o Hash Map
    private void preencherMapDiaSemana(){
        diaSemana.put(1, "Domingo");
        diaSemana.put(2, "Segunda-feira");
        diaSemana.put(3, "Terça-feira");
        diaSemana.put(4, "Quarta-feira");
        diaSemana.put(5, "Quinta-feira");
        diaSemana.put(6, "Sexta-feira");
        diaSemana.put(7, "Sábado");
    }

    // Metodo para mostrar o tempo de aula em minutos
    public int TempoDeAulaMinutos(){
        return (horaFim - horaInicio) * 60;
    }

    // Metodo to String
    @Override
    public String toString() {
        return horaInicio + " - " + horaFim + " (" + diaDaSemana + ")" + "\nTempo de aula: " + TempoDeAulaMinutos();
    }
}