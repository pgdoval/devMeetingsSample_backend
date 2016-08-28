package user

class User {

    String photo
    String name
    String twitter
    boolean premium

    static constraints = {
        photo nullable: true
    }
}
