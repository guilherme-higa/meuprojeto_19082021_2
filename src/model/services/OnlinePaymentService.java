package model.services;

public interface OnlinePaymentService {

	Double paymenteFee(Double amount);

	Double interest(double amount, int meses);

}
