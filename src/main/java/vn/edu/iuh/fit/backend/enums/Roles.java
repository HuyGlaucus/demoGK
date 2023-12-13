package vn.edu.iuh.fit.backend.enums;

public enum Roles {
    ADMINISTRARION(1),
    STAFF(2),
    MANAGER(3),
    EXECUTIVE(4);

    private int value;

    private Roles() {
    }

    Roles(int value) {
        this.value = value;
    }

    public int getRole() {
        return value;
    }
}
