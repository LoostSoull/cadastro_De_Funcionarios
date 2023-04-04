package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//o level esta em um enumm,aceitando somente os valores JUNIOR,MID_LEVEL,SENIOR;
	
		
		System.out.print("Enter department's name: ");
		String departamentName = sc.next();
		System.out.println("Enter worker data");
		System.out.print("name: ");
		String workerName  = sc.next();
		System.out.print("level: ");
		String workerLevel  = sc.next();
		System.out.print("Salary: ");
		double baseSalary  = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new  Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		//For criado para cadastrar os contratos,cada contrato vai receber o dia,mes e ano,
		//convertido pelo SimpleDateFormat , ele cria um padrao para data e utilizado em conjunto com a variavel date, informando que tudo
		//que for recebido pelo sc.next vai ser convertido em seu formato
		for(int i = 0 ; i <n ; i++) {
			System.out.println("Enter contract #1 data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		//apos finalizar todos os parametros da lista, instanciamos uma nova lista, depois com o metodo addContract, adicionamos esse contrato ao trabalhador
		
		//aqui vai ser digitado um mes e ano
		//usuario digita o mes e o ano, criamos duas variaveis,uma para mes e uma para o ano
		//com o metodo Integer.parseInt() , transformamos o que foi digitado na forma de string em um inteiro, passando a variavel como parametro
		//com o substring, consigo "cortar" o que preciso, para month corto do indice 0 a 2 , assim obtenho os dois digitos do mes
		//faco o mesmo com year
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + " : " + String.format("%.2f", worker.income(month, year)));
	
		sc.close();
	}

}
