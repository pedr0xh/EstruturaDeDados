package ArvoreEx;

public class Atleta implements Comparable<Atleta> {
	
	private String nome;
	private String apelido;
	private String posicao;
	private double altura;
	
	public Atleta(String posicao,String apelido,String nome,double altura) {
		this.altura = altura;
		this.apelido = apelido;
		this.nome = nome;
		this.posicao = posicao;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public String getApelido() {
		return apelido;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPosicao() {
		return posicao;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	@Override
	public int compareTo(Atleta o) {
    if (this.altura < o.altura) {
        return -1;
    } else if (this.altura > o.altura) {
        return 1;
    } else {
        return 0; 
    }
}

	
	@Override
	public String toString() {
		return "Atleta: "+nome+" Apelido "+apelido+" na posicao "+posicao+" de altura "+altura;
	}
	
}
