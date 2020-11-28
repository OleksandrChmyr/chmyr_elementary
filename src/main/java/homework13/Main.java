package homework13;
import homework13.entities.Client;
import homework13.services.AccountService;
import homework13.services.ClientService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        List<Client> all = clientService.getAllClients();

        //        all.forEach(System.out::println);
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }

        List<Client> phone;
        phone = clientService.getPhoneSearch(3333333);
        System.out.println("Phone Search: " + phone);

        System.out.println("Client account search test: " + clientService.clientAccountSearch(1));
        System.out.println("Client alias search test: " + clientService.clientAliasSearch(18));
        AccountService accountService = new AccountService();
        accountService.accountsForValueSearch(1000.00);


    }
}
