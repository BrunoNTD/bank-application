package Application;

import Utilities.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Account> bankAccounts;

    public static void main(String[] args) {
        bankAccounts = new ArrayList<Account>();
        bankOperations();
    }

    public static void bankOperations() {
        // @ Menu's
        System.out.println("\n----------------------------------------------------------------");
        System.out.println("---------------- Bem vindo(a) ao CorteezBank -------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("*****     Selecione uma operação que deseja realizar       *****");
        System.out.println("----------------------------------------------------------------");
        System.out.println("|     Opção 1 - Criar Conta     |");
        System.out.println("|     Opção 2 - Depositar       |");
        System.out.println("|     Opção 3 - Sacar           |");
        System.out.println("|     Opção 4 - Transferir      |");
        System.out.println("|     Opção 5 - Listar          |");
        System.out.println("|     Opção 6 - Sair            |");

        // @ Operation's
        int outOperation = input.nextInt();
        switch (outOperation) {
            case 1:
                createAccount ();
                break;
            case 2:
                requestDeposit ();
                break;
            case 3:
                requestWithdraw ();
                break;
            case 4:
                requestTransfer ();
                break;
            case 5:
                listAccounts ();
                break;
            case 6:
                System.out.println("Você deslogou de sua conta, obrigado por utilizar a CorteezBank.");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                bankOperations();
                break;
        }
    }

    public static void createAccount() {
        // @ Information's
        System.out.println("\nInforme seu nome completo.");
        String name = input.next();

        System.out.println("\nInforme seu CPF.");
        String CPF = input.next();

        System.out.println("\nInforme seu email.");
        String email = input.next();

        // @ Create's
        Client client = new Client(name, CPF, email);
        Account account = new Account(client);

        bankAccounts.add(account);
        System.out.println("Sua conta em nosso banco foi criada! Agradecemos pela preferência.");

        // @ Operation's
        bankOperations();
    }

    private static Account findAccount(int accountIndex) {
        Account account = null;
        if (bankAccounts.size() > 0) {
            for (Account actualAccount : bankAccounts) {
                if (actualAccount.getAccountIndex() == accountIndex);
                account = actualAccount;
            }
        }
        return account;
    }

    public static void requestDeposit () {
        // @ Information's
        System.out.println("Número da conta que deseja efetuar o depósito.");
        int accountIndex = input.nextInt();

        // @ Account's
        Account account = findAccount(accountIndex);
        if (account != null) {
            // @ Amount
            System.out.println("Qual valor deseja depositar?");
            Double amountDeposit = input.nextDouble();

            // @ Method
            account.requestDeposit(amountDeposit);
            // System.out.println("Você depositou " + Utils.doubleToString(amountDeposit) + " com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }

        // @ Operation's
        bankOperations();
    }

    public static void requestWithdraw() {
        // @ Information's
        System.out.println("Número da conta que deseja sacar.");
        int accountIndex = input.nextInt();

        // @ findAccount's
        Account account = findAccount(accountIndex);
        if (account != null) {
            // @ Amount
            System.out.println("Qual valor deseja sacar?");
            Double amountWithdraw = input.nextDouble();

            // @ Method
            account.requestWithdraw(amountWithdraw);
            // System.out.println("Você sacou " + Utils.doubleToString(amountWithdraw) + " com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }

        // @ Operation's
        bankOperations();
    }

    public static void requestTransfer() {
        // @ Information's
        System.out.println("Número da conta remetente.");
        int accountIndex = input.nextInt();

        // @ findAccount's
        Account account = findAccount(accountIndex);
        if (account != null) {
            // @ Target
            System.out.println("Número da conta destinatária.");
            int accountTarget = input.nextInt();

            // @ findAccount's
            Account target = findAccount(accountTarget);
            if (target != null) {
                // @ Amount
                System.out.println("Qual valor deseja transferir?");
                Double amountTransfer = input.nextDouble();

                // @ Method
                account.requestTransfer(target, amountTransfer);
                // System.out.println("Você transferiu " + Utils.doubleToString(amountTransfer) + " com sucesso!");
            } else {
                System.out.println("Conta destinatária não encontrada.");
            }
        } else {
            System.out.println("Conta remetente não encontrada.");
        }

        // @ Operation's
        bankOperations();
    }

    public static void listAccounts() {
        // @ List's
        if (bankAccounts.size() > 0) {
            for (Account account : bankAccounts) {
                System.out.println(account);
            }
        } else {
            System.out.println("Não há contas cadastradas.");
        }

        // @ Operation's
        bankOperations();
    }
}
