package user

class User {

    String photo
    String name
    String twitter
    boolean premium
    int userOrder

    static constraints = {
        photo nullable: true
        userOrder nullable: true
    }
}
