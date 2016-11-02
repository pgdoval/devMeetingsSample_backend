package product

import tech.UserProduct
import tech.Product
import grails.rest.*
import grails.converters.*

class ProductController {

    def findAllProducts(long userNumber){
        println "oooooooooooooooooooooo"
        findFilteredProducts({true}, userNumber)
    }


    def findProductsByString(long userNumber){

        println params

        String hay = params.hay

        def closure = {
            product->
                if([product.name, product.description].any{it.contains(hay)})
                    return true
        }
        findFilteredProducts(closure, userNumber)
    }

    def findProductsInCartForUser(long userNumber){

        String hay = params.hay

        def closure = {
            product->
                def up = UserProduct.findByUserAndProduct(User.findByUserNumber(userNumber), product)

                return up && up.amount
        }
        findFilteredProducts(closure, userNumber)
    }


    private findFilteredProducts(Closure<Boolean> filter, long userNumber){
        def user = User.findByUserNumber(userNumber)
        def allProducts = Product.list().sort{it.productOrder}

        def result = allProducts.collect{
            product -> [
                    id: product.id,
                    photo: product.photo,
                    name: product.name,
                    description: product.description,
                    price: product.price,
                    amount: UserProduct.findByUserAndProduct(user, product)
            ]
        }

        result = result.findAll(filter)

        render result as JSON

    }

    def addToCart(long userNumber, long productId){
        Product product = Product.get(productId)
        def user = User.findByUserNumber(userNumber)

        def up = UserProduct.findByUserAndProduct(user, product)
        up.amount += params.value.toInteger()

        up.save()

        def result = [
                id: product.id,
                photo: product.photo,
                name: product.name,
                description: product.description,
                price: product.price,
                amount: up.amount
        ]

        render result as JSON
    }

    def processCart(long userNumber)
    {
        def user = User.findByUserNumber(userNumber)

        UserProduct.findAllByUser(user).each{
            it.amount = 0
            it.save()
        }
    }
}


