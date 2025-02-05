package projetoJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Alura online");
		palavras.add("editora casa do código");
		palavras.add("caelum");

		// lambda para o sort
//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

// metodo default abstrato comparing que recebe uma lambda para fazer a comparação
		palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length));

		Comparator<String> comparador = Comparator.comparing(s -> s.length());

		// equivale ao campo lambda abaixo s -> s.length()
		Function<String, Integer> funcao = s -> s.length();
		Function<String, Integer> funcaoL = String::length;
		
		palavras.sort(comparador);
		System.out.println(palavras);

	}

}
