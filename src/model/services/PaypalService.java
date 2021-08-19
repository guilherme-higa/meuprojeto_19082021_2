package model.services;

public class PaypalService implements OnlinePaymentService {

	public static final double PAYMENT_FEE = 0.02;
	public static final double MONTHLY_INTEREST = 0.01;

	@Override
	public Double paymenteFee(Double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public Double interest(double amount, int meses) {
		return amount * meses * MONTHLY_INTEREST;
	}

}
