package devmeetings

class UrlMappings {

    static mappings = {

        get "/allProducts/$userNumber"(controller: 'product', action: 'findAllProducts')
        get "/findProducts/$userNumber"(controller: 'product', action: 'findProductsByString')
        get "/productsInCart/$userNumber"(controller: 'product', action: 'findProductsInCartForUser')
        post "/cart/$userNumber/$productId"(controller: 'product', action: 'addToCart')
        post "/cart/$userNumber"(controller: 'product', action: 'processCart')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
