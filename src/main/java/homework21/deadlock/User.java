package homework21.deadlock;

public class User {
    private Admin admin;
    public static int k = 1;
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public static synchronized int getValue() {
        for (int i = 0; i < 50; i++) {
            System.out.println("User get value method operating: " + k++);

        }
        return k;
    }

    public static synchronized int getValueFromAdmin() {
        System.out.println("User get value from Admin method operating: ");

        return Admin.getValue();


    }
}
