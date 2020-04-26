package com.sda.springapporderclient;

import com.sda.springapporderclient.model.*;
import com.sda.springapporderclient.service.AddressService;
import com.sda.springapporderclient.service.MailService;
import com.sda.springapporderclient.service.OrderService;
import com.sda.springapporderclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.util.List;

@SpringBootApplication
public class SpringAppOrderClientApplication implements CommandLineRunner {
    private UserService userService;
    private AddressService addressService;
    private OrderService orderService;
    private MailService mailService;

    @Autowired
    public SpringAppOrderClientApplication(UserService userService, AddressService addressService, OrderService orderService, MailService mailService) {
        this.userService = userService;
        this.addressService = addressService;
        this.orderService = orderService;
        this.mailService = mailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAppOrderClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        tryUserSrv();
//        tryAddressSrv();
////        System.out.println(getUserByUsername("portmann"));
//        List<Address> portmann = getUserAddresses("portmann");
//        portmann.forEach(System.out::println);
//        User user = new User("DamianSoltysiuk", "Damian", "Soltysiuk", "ds@ex.ex");
//        Role r1 = new Role("Normal user", Role.RoleEnum.USER);
//        Role r2 = new Role("Read auth", Role.RoleEnum.READER);
//        Role r3 = new Role("Write auth", Role.RoleEnum.WRITER);
//        user.setRole(Stream.of(r1, r2, r3).collect(Collectors.toSet()));
//        final User user1 = createUser(user);
//        System.out.println(user1);
//        orderService.getOrders().forEach(System.out::println);
sendEmail();

    }

    private User createUser(User user) {
        return userService.saveUser(user);
    }

    private User readUser(Long id) {
        return userService.getOneById(id);
    }

    private User updateUser(Long id, User user) {
        return userService.updateUser(id, user);
    }

    private void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    private List<User> readUsers() {
        return userService.getAll();
    }

    private List<User> readUserByFullName(String firstName, String lastName) {
        return userService.getUserByFirstNameAndLastName(firstName, lastName);
    }

    private void tryUserSrv() {
        System.out.print("\t\tUSER\n\n");
        //CREATE
        User user = createUser(new User("danyyPL", "Damian", "Soltysiuk", "danyy@wp.pl"));
        System.out.println(user);
        //READ
        System.out.println(readUser(user.getId()));
        //UPDATE
        user = updateUser(user.getId(), new User("ddv", "Danyy", "de Vito", user.getEmail()));
        System.out.println(user);
        //DELETE
        deleteUser(user.getId());

        System.out.println("USERS");
        readUsers().stream().forEach(System.out::println);

        System.out.println("USERS BY FULLNAME");
        readUserByFullName("na", "").forEach(System.out::println);
    }

    private Address createAddress(Address address) {
        return addressService.saveAddress(address);
    }

    private Address readAddress(Long id) {
        return addressService.getOneById(id);
    }

    private List<Address> readAddresses() {
        return addressService.getAddresses();
    }

    private Address updateAddress(Long id, Address address) {
        return addressService.updateAddress(id, address);
    }

    private void deleteAddress(Long id) {
        addressService.deleteAddress(id);
    }

    private void tryAddressSrv() {
        System.out.print("\t\tADDRESS\n\n");
        //CREATE
        Address address = createAddress(new Address("PL", "Szczytno", "Blotna", 12, readUser(3L)));
        System.out.println(address);
        //READ
        System.out.println(readAddress(2L));
        //UPDATE
        address = updateAddress(address.getId(), new Address(address.getCountry(), "Suwalki", address.getStreet(), 23, readUser(2L)));
        System.out.println(address);
        //DELETE
        deleteAddress(address.getId());

        System.out.println("ADDRESSES");
        readAddresses().forEach(System.out::println);
    }

    private List<Address> getUserAddresses(String username) {
        return addressService.getUserAddress(username);
    }

    private User getUserByUsername(String username) {
        return userService.findUserByUsername(username);
    }

    private void sendEmail() {
//        String email = "dzzzimxicmvbflfndj@ttirv.org";
//        User user = new User("MrBean", "Mr", "Bean", email);
//        user.setRole(Stream.of(new Role("", Role.RoleEnum.READER)).collect(Collectors.toSet()));
//        User saveUser = userService.saveUser(user);
        Order saveOrder = orderService.getOrder(6l);

        StringBuilder sbUser = new StringBuilder("Order user: ").append(saveOrder.getUser().getUsername() + " (").append(saveOrder.getUser().getFirstName() + " ").append(saveOrder.getUser().getLastName() + ")");
        StringBuilder sbOrder = new StringBuilder("Your order:\n");
        saveOrder.getProductList().forEach(p -> {sbOrder.append(p).append("\n");});
        try {
            mailService.sendMain(saveOrder.getUser().getEmail(), sbUser.toString(), sbOrder.toString(), false);
            System.out.println("Sending email to " + saveOrder.getUser().getEmail() +".");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
