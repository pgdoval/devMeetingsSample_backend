package devmeetings

class UrlMappings {

    static mappings = {

        "/allUsers"(controller: 'user', action: 'findAllUsers')
        "/findUsers"(controller: 'user', action: 'findUsersByString')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
