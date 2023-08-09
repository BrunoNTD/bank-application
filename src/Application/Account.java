package Application;

import Utilities.Utils;

public class Account {
    private int accountsAmount = 0;
    private int accountIndex;
    private Client client;
    private Double withdraw = 0.0;

    public Account(Client client) {
        this.accountIndex = accountsAmount;
        this.client = client;
        accountsAmount += 1;
    }

    public int getAccountIndex() {
        return accountIndex;
    }

    public void setAccountIndex(int accountIndex) {
        this.accountIndex = accountIndex;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Double withdraw) {
        this.withdraw = withdraw;
    }

    public String toString() {
        return "\nIndex Account: [ " + this.getAccountIndex() + " ]" +
                "\nNome: [ " + this.getClient().getName() + " ]" +
                "\nCPF: [ " + this.getClient().getCpf() + " ]" +
                "\nEmail: [ " + this.getClient().getEmail() + " ]\n" +
                "\nSaldo: [ " + Utils.doubleToString(this.getWithdraw()) + " ]" +
                "\n";
    }

    public void requestDeposit(Double amount) {
        if (amount > 0) {
            setWithdraw(getWithdraw() + amount);
            System.out.println("Você efetuou o depósito de " + Utils.doubleToString((amount)) + " em sua conta.");
        } else {
            System.out.println("Não foi possivel concluir o depósito.");
            return;
        }
    }

    public void requestWithdraw(Double amount) {
        if (!(amount > 0)) {
            System.out.println("Não foi possivel concluir o saque.");
            return;
        }

        if (amount > getWithdraw()) {
            System.out.print("Você não possui esse valor em sua conta.");
            return;
        }

        setWithdraw(getWithdraw() - amount);
        System.out.println("Você sacou " + Utils.doubleToString((amount)) + " de sua conta.");
    }

    public void requestTransfer (Account account, Double amount) {
        if (amount > 0 && this.getWithdraw() >= amount) {
            account.withdraw = account.withdraw + amount;
            System.out.println("Você transferiu " + Utils.doubleToString((amount)) + " para a conta " + account.getAccountIndex());
        }
    }
}
