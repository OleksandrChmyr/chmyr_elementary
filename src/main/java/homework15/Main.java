package homework15;

import homework15.entities.Client;
import homework15.services.ClientService;
import homework15.services.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client();
        client1.setName("Alex1");
        client1.setEmail("Alex1@gmail.com");
        client1.setAge(15);
        client1.setPhone(23412412);
        client1.setAbout("guy111");

        Client client2 = new Client();
        client2.setName("Alex2");
        client2.setEmail("Alex2@gmail.com");
        client2.setAge(12);
        client2.setPhone(234122112);
        client2.setAbout("guy222");
        Client client3 = new Client();
        client3.setName("Alex3");
        client3.setEmail("Alex3@gmail.com");
        client3.setAge(13);
        client3.setPhone(256512412);
        client3.setAbout("guy333");
        Client client4 = new Client();
        client4.setName("Alex4");
        client4.setEmail("Alex4@gmail.com");
        client4.setAge(14);
        client4.setPhone(233443412);
        client4.setAbout("guy444");
        Client client5 = new Client();
        client5.setName("Alex5");
        client5.setEmail("Alex5@gmail.com");
        client5.setAge(23);
        client5.setPhone(232124112);
        client5.setAbout("guy555");

        ClientService clientService = new ClientServiceImpl();
        clientService.save(client1);
        clientService.save(client2);
        clientService.save(client3);
        clientService.save(client4);
        clientService.save(client5);


    }
}
