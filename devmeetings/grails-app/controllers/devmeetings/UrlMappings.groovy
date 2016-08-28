package devmeetings

class UrlMappings {

    static mappings = {

        "/allUsers"(controller: 'user', action: 'findAllUsers')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
