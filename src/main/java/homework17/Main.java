package homework17;

import homework17.entities.Client;
import homework17.services.ClientService;
import homework17.services.ClientServiceImpl;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client();
        client1.setName("Alex11");
        client1.setEmail("Alex11@gmail.com");
        client1.setAge(15);
        client1.setPhone(2341212);
        client1.setAbout("guy111");

        Client client2 = new Client();
        client2.setName("Alex22");
        client2.setEmail("Alex22@gmail.com");
        client2.setAge(12);
        client2.setPhone(2342112);
        client2.setAbout("guy222");
        Client client3 = new Client();
        client3.setName("Alex33");
        client3.setEmail("Alex33@gmail.com");
        client3.setAge(13);
        client3.setPhone(256552412);
        client3.setAbout("guy333");
        Client client4 = new Client();
        client4.setName("Alex44");
        client4.setEmail("Alex44@gmail.com");
        client4.setAge(14);
        client4.setPhone(23344412);
        client4.setAbout("guy444");
        Client client5 = new Client();
        client5.setName("Alex55");
        client5.setEmail("Alex55@gmail.com");
        client5.setAge(23);
        client5.setPhone(23224112);
        client5.setAbout("guy555");

        ClientService clientService = new ClientServiceImpl();
        clientService.save(client1);
        clientService.save(client2);
        clientService.save(client3);
        clientService.save(client4);
        clientService.save(client5);


    }
}
