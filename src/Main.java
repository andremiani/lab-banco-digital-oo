import java.util.Scanner;
import lib.CPF;

public class Main {

	public static void main(String[] args) {

		try (Scanner ler = new Scanner(System.in)) {

			String cpf;
			String nomeCliente;
			Double valorDeposito;
			Double valorPoupanca;

			System.out.printf("Informe um CPF: ");
			cpf = ler.next();

			if (CPF.isCPF(cpf)) {
				ler.nextLine();

				System.out.printf("Informe o nome do cliente: ");
				nomeCliente = ler.nextLine();

				Cliente cliente = new Cliente();
				cliente.setCpf(cpf);
				cliente.setNome(nomeCliente);

				Conta cc = new ContaCorrente(cliente);
				Conta poupanca = new ContaPoupanca(cliente);

				System.out.printf("Informe valor do depósito: ");
				valorDeposito = ler.nextDouble();

				cc.depositar(valorDeposito);

				System.out.printf("Informe valor a ser transferido para a conta-poupança: ");
				valorPoupanca = ler.nextDouble();

				cc.transferir(valorPoupanca, poupanca);

				cc.imprimirExtrato();
				poupanca.imprimirExtrato();

			} else {
				System.out.printf("Erro, CPF invalido !!!\n");
			}
		}
	}

}
