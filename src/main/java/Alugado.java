public class Alugado {

    private String dataAlugado;
    private String dataDevolucao;
    private int codigo_jogo;

    public Alugado(String dataAlugado, String dataDevolucao,int codigo_jogo) {
        this.dataAlugado = dataAlugado;
        this.dataDevolucao = dataDevolucao;
        this.codigo_jogo = codigo_jogo;
    }

    public String getDataAlugado() {
        return dataAlugado;
    }

    public void setDataAlugado(String dataAlugado) {
        this.dataAlugado = dataAlugado;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getCodigo_jogo() {
        return codigo_jogo;
    }

    public void setCodigo_jogo(int codigo_jogo) {
        this.codigo_jogo = codigo_jogo;
    }
}
