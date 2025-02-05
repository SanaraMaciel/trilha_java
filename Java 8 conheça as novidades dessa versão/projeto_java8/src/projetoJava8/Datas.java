package projetoJava8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Datas {

	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);

		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);

//		descobrindo a diferença de anos entre hoje e as olimpiadas do rio 
		int anos = olimpiadasRio.getYear() - hoje.getYear();
		System.out.println(anos);

//		fazendo calculo com Period
		Period periodo = Period.between(hoje, olimpiadasRio);
		System.out.println("formato original: " + periodo);
		System.out.println("formato dias: " + periodo.getDays());

//		somar 4 anos ao valor de olimpiadas
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);

//		formatadores de datas 
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valor = proximasOlimpiadas.format(formatador);
		System.out.println(valor);

//		formatador com horas
		DateTimeFormatter formatadorHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

//		usando localDatetime
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorHoras));

//		classe que faz a busca/associação do mês e do ano desejado 
		YearMonth mes = YearMonth.of(anos, Month.JULY);

//		representa somente a hora
		LocalTime hora = LocalTime.of(15, 30);
		System.out.println(hora);

//		diminuindo datas
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

//		aumentando datas
		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));

//		outras formas de declarar um localdate
		LocalDate data = LocalDate.of(2099, 1, 25);
		LocalDate datae = LocalDate.of(2099, Month.JANUARY, 25);

//		criando um período de entre 2 datas
		LocalDate agoraPeriodo = LocalDate.now();
		LocalDate dataFutura = LocalDate.of(2099, Month.JANUARY, 25);
		Period periodoEntre = Period.between(agoraPeriodo, dataFutura);
		System.out.println("periodo intervalo Anos: " + periodoEntre.getYears() + " Meses: " + periodoEntre.getMonths()
				+ " Dias: " + periodoEntre.getDays());

		LocalTime currentTime = LocalTime.now(); // saída 09:05:03.244
		System.out.println(currentTime);
		LocalDate today = LocalDate.now(); // saída 2014-12-10
		System.out.println(today);
		LocalDateTime now = LocalDateTime.now(); // saída 2014-12-10-09-05-03.244
		System.out.println(now);

//		usando o Zone para declarar datas

		LocalTime time = LocalTime.now(ZoneId.of("America/Chicago"));
		LocalDate date = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));

//		representando qualquer natal
		MonthDay someChristmas = MonthDay.of(Month.DECEMBER, 25);
		System.out.println("Natal: " + someChristmas);

//		cria um momento exato no tempo com o método of:
		LocalDateTime someDate = LocalDateTime.of(2017, Month.JANUARY, 25, 13, 45);
		System.out.println("Exato: " + someDate);

		/**
		 * get: obtém o valor de algo is: verifica se algo é verdadeiro 
		 * with: lembra um ::setter::, mas retorna um novo objeto com o valor alterado
		 * plus: soma alguma  unidade ao objeto, retorna um novo objeto com o valor alterado 
		 * minus: subtrai alguma unidade do objeto, retorna um novo objeto com o valor alterado 
		 * to: converte um objeto de um tipo para outro
		 * at: combina um objeto com outro
		 */

//		Interfaces TemporalField e ChronoField
		LocalDateTime now2 = LocalDateTime.of(2014, 12, 15, 13, 0); // 15
		System.out.println(now2.get(ChronoField.DAY_OF_MONTH)); // 349 
		System.out.println(now2.get(ChronoField.DAY_OF_YEAR)); // 13    
		System.out.println(now2.get(ChronoField.HOUR_OF_DAY)); // 0  
		System.out.println(now2.get(ChronoField.MINUTE_OF_HOUR));// 2014
		System.out.println(now2.get(ChronoField.YEAR)); // 1 (MONDAY)        
		System.out.println(now2.get(ChronoField.DAY_OF_WEEK)); // 12
		System.out.println(now2.get(ChronoField.MONTH_OF_YEAR)); 

//		comparando datas com isAfter isBefore
		MonthDay day1 = MonthDay.of(1, 1); // 01/jan
		MonthDay day2 = MonthDay.of(1, 2); // 02/jan

		System.out.println(day1.isAfter(day2)); // false
		System.out.println(day1.isBefore(day2)); // true

//		métodos para indicar se alguma porção da data é suportada pelo objeto ChronoField e ChronoUnit :

		LocalDate aprilFools = LocalDate.of(2015, 4, 1);
		LocalDate foolsDay = LocalDate.of(2015, 4, 1);
		
// são equals? // true
		System.out.println(aprilFools.isEqual(foolsDay)); 
		
// este objeto suporta dias? // true
		System.out.println(aprilFools.isSupported(ChronoField.DAY_OF_MONTH)); 
		
// este objeto suporta horas? // false
		System.out.println(aprilFools.isSupported(ChronoField.HOUR_OF_DAY)); 
		
// posso fazer operações com dias? //true
		System.out.println(aprilFools.isSupported(ChronoUnit.DAYS));
		
// posso fazer operações com horas? //false
		System.out.println(aprilFools.isSupported(ChronoUnit.HOURS));

	

//		LocalDate d = LocalDate.of(2013, 9, 7);
//		// UnsupportedTemporalTypeException
//		// LocalDate não suporta horas!
//		d = d.plus(3, ChronoUnit.HOURS);
//		System.out.println(d);

		
//		Duration caso queira trabalhar com intervalo de horas.

	}

}
