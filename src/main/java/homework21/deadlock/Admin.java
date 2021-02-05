package homework21.deadlock;

public class Admin {
    private User user;
    public static int l = 5;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static synchronized int getValue() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println("Admin get value method operating: " + l++);

        }
        return l;
    }

    public static synchronized int getValueFromUser() {
        System.out.println("Admin get value from User method operating: ");

        return User.getValue();
    }
}
