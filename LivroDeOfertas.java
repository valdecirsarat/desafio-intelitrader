
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class LivroDeOfertas {
	
	Integer posicao;
	Double valor;
	Double quantidade;
	
	LivroDeOfertas[] livros;
	
	public LivroDeOfertas() {}
	
	public LivroDeOfertas(Integer posicao, Double valor, Double quantidade) {
		this.posicao = posicao;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	
	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public LivroDeOfertas[] getLivros() {
		return livros;
	}

	public void setLivros(LivroDeOfertas[] livros) {
		this.livros = livros;
	}
	

	@Override
	public String toString() {
		return "posicao=" + posicao + ", valor=" + valor + ", quantidade=" + quantidade + "";
	}
	
	
	public void create(int posicao,LivroDeOfertas livro) {
		
	        this.livros[posicao -1]= livro;
	
	}
	
	public void update(int posicao, double valor , double quantidade) {
		LivroDeOfertas livro = livros[posicao-1];
		livro.setQuantidade(quantidade);
		livro.setValor(valor);
	}

	public void delete(int posicao) {
		this.livros[posicao - 1]= null;
		
	}
//--------------------------------------------------------


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		LivroDeOfertas livroDeOfertas = new LivroDeOfertas();

		try {
			System.out.println("Notificacao: ");		
			int notificacao = sc.nextInt();
			livroDeOfertas.livros = new LivroDeOfertas[notificacao];
			
			for(int i = 1; i <= notificacao ; i++) {				
					String entrada = sc.next();
					String[] auxliar = entrada.split(",");
					int posicao = Integer.parseInt(auxliar[0]);
					int acao =Integer.parseInt(auxliar[1]);
					double valor = Double.parseDouble(auxliar[2]);
					double quantidade = Double.parseDouble(auxliar[3]);
					
					switch (acao) {
					//inserido um novo
						case 0: {
							LivroDeOfertas novo = new LivroDeOfertas(posicao, valor, quantidade);
							livroDeOfertas.create(posicao,novo);
							break;
							}
					// update
						case 1:{
							//System.out.println("update");
							livroDeOfertas.update(posicao,valor, quantidade);
							break;
							}
					//delete
						case 2:{
							//System.out.println("delete");
							livroDeOfertas.delete(posicao);
							break;
						}
					}
									
			}
			sc.close();
			
			for (LivroDeOfertas livro : livroDeOfertas.getLivros()) {
				if(livro != null) {
					System.out.println(livro);
				}
				  
			}
			
		}catch (InputMismatchException e) {
			//verificando o erro que ocasionava na utlização do scanner
			System.out.print(e.getMessage());
		}
		
				
		
	}

}
