package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do contrato:");
		System.out.print("Código do contrato: ");
		Integer codigo = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		Date dataContrato = sdf.parse(sc.next());
		System.out.print("Valor total referente ao contrato: ");
		double valorTotal = sc.nextDouble();

		Contract contrato = new Contract(codigo, dataContrato, valorTotal);
		ContractService sc1 = new ContractService(new PaypalService());

		System.out.print("Entre com o de parcelas referente ao contrato: ");
		int parcela = sc.nextInt();
		sc1.processContract(contrato, parcela);
		System.out.println("Parcelas:");
		for (Installment x : contrato.getParcela()) {
			System.out.println(x);
		}
		sc.close();
	}

}
