package homework18.utils;

import java.util.Optional;

public class OptionalHelperClass {

    public Optional optionalHelperMethod (String email) {
        boolean emailMatch = email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        if (!emailMatch || email.isEmpty()) {
            System.out.println("Return empty email optional");
            return Optional.empty();
        } else {
            Optional<String> emailOptional = Optional.of(email);
            System.out.println("Return email Optional");

            return emailOptional;
        }

    }
}
