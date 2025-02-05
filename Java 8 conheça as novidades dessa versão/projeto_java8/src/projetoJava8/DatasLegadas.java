package projetoJava8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DatasLegadas {

	public static void main(String[] args) {

//		converte uma java.util.Date em LocalDateTime usando a Timezone padrão do sistema:
		Date d = new Date();
		Instant i = d.toInstant();
		LocalDateTime ldt1 = LocalDateTime.ofInstant(i, ZoneId.systemDefault());
		System.out.println(ldt1);

//		converte um em LocalDateTime usando a Timezone padrão do sistema:
		Calendar c = Calendar.getInstance();
		Instant ins = c.toInstant();
		LocalDateTime ldt2 = LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
		System.out.println(ldt2);

		/**
		 * Repare que para fazer a conversão usamos como intermediário a classe Instant,
		 * que representa o número de milissegundos desde 01/01/1970. Também podemos
		 * usar essa classe para fazer o caminho de volta:
		 */

		Date d2 = new Date();
		Instant ins2 = d.toInstant();
		LocalDateTime ldt3 = LocalDateTime.ofInstant(ins2, ZoneId.systemDefault());
		System.out.println(ldt3);

		Instant instant = ldt1.toInstant(ZoneOffset.UTC);
		Date date = Date.from(instant);
		System.out.println(date);

//		Duration é a classe de mais baixo nível, usada para manipular objetos do tipo Instant. 
//		O exemplo a seguir soma 10 segundos ao instante atual:
//		Duration só tem a opção de getSeconds; não existem métodos do tipo getDays etc.

		Instant now = Instant.now(); // agora
		Duration tenSeconds = Duration.ofSeconds(10); // 10 segundos
		Instant t = now.plus(tenSeconds); // agora mais 10 segundos
		System.out.println(now);
		System.out.println(tenSeconds);
		System.out.println(t);

//		pegar o intervalo em segundos entre dois instantes:
		Instant t1 = Instant.EPOCH; // 01/01/1970 00:00:00
		Instant t2 = Instant.now();
		long secondsSinceEpoch = Duration.between(t1, t2).getSeconds();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(secondsSinceEpoch);

//		classe ChronoUnit é uma das classes mais versáteis, pois permite ver a 
//		diferença entre duas datas em várias unidades de tempo:
		LocalDate birthday = LocalDate.of(1983, 7, 22);
		LocalDate base = LocalDate.of(2014, 12, 25);

// 31 anos no total
		System.out.println(ChronoUnit.YEARS.between(birthday, base));
// 377 meses no total
		System.out.println(ChronoUnit.MONTHS.between(birthday, base));
// 11479 dias no total
		System.out.println(ChronoUnit.DAYS.between(birthday, base));

//		Period pode ser usada para fazer cálculos de intervalos, quebrando as unidades 
//		de tempo do maior para o menor. Vamos tentar calcular a idade de uma pessoa:

		LocalDate birthdayB = LocalDate.of(1983, 7, 22);
		LocalDate baseB = LocalDate.of(2014, 12, 25);

		Period lifeTime = Period.between(birthdayB, baseB);

		System.out.println(lifeTime.getYears()); // 31 anos
		System.out.println(lifeTime.getMonths()); // 5 meses
		System.out.println(lifeTime.getDays()); // 3 dias

		
//		calcula a diferença em dias entre dois LocalDate
		System.out.println(ChronoUnit.DAYS.between(birthdayB, baseB));
		
	}

}
