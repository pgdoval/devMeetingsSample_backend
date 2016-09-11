package devmeetings

class UrlMappings {

    static mappings = {

        get "/allUsers"(controller: 'user', action: 'findAllUsers')
        get "/findUsers"(controller: 'user', action: 'findUsersByString')
        get "/premiumUsers"(controller: 'user', action: 'findPremiumUsers')
        post     "/premium/$userId"(controller: 'user', action: 'updatePremium')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
