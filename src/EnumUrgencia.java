public enum EnumUrgencia 
{
    IMEDIATO(1, "Imediato"),
    MUITO_URGENTE(2, "Muito Urgente"),
    URGENTE(3, "Urgente"),
    POUCO_URGENTE(4, "Pouco Urgente"),
    NAO_URGENTE(5, "Não Urgente");

    private final int valor;
    private final String descricao;

    EnumUrgencia(int valor, String descricao) 
    {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getValor() 
    {
        return valor;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public static EnumUrgencia fromInt(int valor) 
    {
        for (EnumUrgencia urgencia : EnumUrgencia.values()) 
        {
            if (urgencia.getValor() == valor) 
            {
                return urgencia;
            }
        }
        throw new IllegalArgumentException("Valor de urgência inválido: " + valor);
    }
}
