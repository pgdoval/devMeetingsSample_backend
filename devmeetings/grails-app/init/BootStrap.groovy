import user.User
import product.UserProduct
import product.Product

class BootStrap {

    def init = { servletContext ->

        def users = (1..40).collect{
            it-> new User(userNumber: it)
        }

        users*.save()


        Product astrolabio = new Product(
                name: "Astrolabio parlante",
                photo: "astrolabio.jpg",
                description: "Un magnífico astrolabio parlante",
                price: 20.0)

        Product rarisimo = new Product(
                name: "Objeto rarísimo",
                photo: "rarisimo.jpg",
                description: "Nunca te habrías imaginado que esto existía...",
                price: 200.0)

        Product gorro = new Product(
                name: "Casco para cervezas",
                photo: "casco.jpg",
                description: "Para pasar el rato, el casco más enrollado!",
                price: 6.5)

        Product anillo = new Product(
                name: "Anillo único",
                photo: "anillo.jpg",
                description: "Nueva edición del anillo único, sólo tenemos 100 copias!",
                price: 45.0)

        Product flor = new Product(
                name: "Flor de fuego",
                photo: "flor.jpg",
                description: "Para entrar en los pubs gritando: 'Cuidado, nenas, que quemo!'",
                price: 80.0)

        def products = [astrolabio, rarisimo, gorro, anillo, flor]

        products*.save()

        users.each{
            user->
                products.each{
                    product -> new UserProduct(
                            user: user,
                            product:product,
                            amount:0
                    ).save()
                }
        }

    }
    def destroy = {
    }
}
