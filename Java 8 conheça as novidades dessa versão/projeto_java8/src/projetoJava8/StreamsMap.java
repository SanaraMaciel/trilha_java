package projetoJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class StreamsMap {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAlunos));

		// esse method reference só da certo p/ métodos muito simples
//		cursos.forEach(System.out::println);

		// passando o campo que eu quero que imprima
//		cursos.forEach(c -> System.out.println(c.getNome()));

		// imprimir todos os cursos que possuem +100 alunos
		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));

		// imprimir quantos alunos tem os cursos que possuem +100 alunos
		cursos.stream().filter(c -> c.getAlunos() >= 100).map(c -> c.getAlunos())
				.forEach(total -> System.out.println(total));

//imprimir quantos alunos tem os cursos que possuem +100 alunos usando method reference
		cursos.stream().filter(c -> c.getAlunos() >= 100).map(Curso::getAlunos).forEach(System.out::println);

//		usando o mapToInt no caso de precisar declarar uma variável temporária
//		com esse e outros metodos relacionados ele permite que faça operações do tipo somar, subtrair etc
		IntStream inte = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos);

//		comparando os cursos pela qtd de alunos
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));

//		usando o método findFirst e findAny
		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() >= 100).findAny();

//		trabalhando com o optional
		Curso curso = optionalCurso.orElse(null);
		System.out.println(curso.getNome());
		optionalCurso.ifPresent(c -> System.out.println("se presente: " + c.getNome()));

//		utilizando tudo na msm linha métodos concatenados 
		cursos.stream().filter(c -> c.getAlunos() >= 100).findAny()
				.ifPresent(c -> System.out.println("concatenados : " + c.getNome()));

//		buscando e calculando a média de alunos no curso
		OptionalDouble average = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).average();

//		retornando o resultado de stream em uma lista (ordenado, filtrado etc)
		cursos = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());

//		já ordenando e fazendo a impressão da lista
		cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList())
				.forEach(c -> System.out.println(c.getNome()));

//		usando map para gerar map a partir de um stream
		Map<String, Integer> mapa = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(
				Collectors.toMap(c -> c.getNome() , c -> c.getAlunos()));
		System.out.println(mapa);
		
//		mesmo método de mapa só que concatenado junto foreach
		cursos.stream().filter(c -> c.getAlunos() >= 100).collect(
				Collectors.toMap(c -> c.getNome() , c -> c.getAlunos()))
		.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		
	}
	
	
}
