package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {

		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {

		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {

		contracts.remove(contract);
	}

	// criado a variavel cal do tipo calendar recebendo getInstance, informa que o
	// dia e horario do sistema
	// calendar vai conter a data do meu sistema
	// cal.setTime(c.getDate()) , informo que meu calendario vai receber a data da
	// variavel `c` do meu for each, por sua vez tem data cadastrada na lista
	// crio uma variavel para o ano e pego com get o ano dessa data instanciada e
	// repito com o mes
	// variavel sum criada recebendo o valor do salario base
	// dentro do if , se o mes e ano digitado for igual a de um ou mais contratos, o
	// salario base vai ser somado a esses valores, sum ser alterada
	public double income(int month, int year) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);

			if (year == c_year && month == c_month) {
				sum += c.totalValue();

				
			}
			
		}
		return sum;
	}

}
