package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService ops;

	public ContractService(OnlinePaymentService ops) {
		this.ops = ops;
	}

	public void processContract(Contract contract, Integer meses) {
		double valorMes = contract.getValorTotal() / meses;
		for (int i = 1; i <= meses; i++) {
			double taxaMes = valorMes + ops.interest(valorMes, i);
			double valorFinal = (taxaMes + ops.paymenteFee(taxaMes));
			Date dueDate = addMonths(contract.getData(), i);
			contract.getParcela().add(new Installment(dueDate, valorFinal));
		}
	}

	//somando um valor no mês e retornando mês+soma
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.MONTH, N);
		return calendar.getTime();
	}
}
