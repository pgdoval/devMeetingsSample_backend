package user


import tech.UserTech
import grails.rest.*
import grails.converters.*

class UserController {

    def findAllUsers(){
        def allUsers = User.list()
        def allUserTechsByUser = UserTech.list().groupBy{
            it.user
        }

        def result = allUsers.collect{
            user -> [
                    photo: user.photo,
                    name: user.name,
                    twitter: user.twitter,
                    premium: user.premium,
                    languages: allUserTechsByUser[user].collect{
                        userTech -> [
                                name: userTech.tech.name,
                                value: userTech.value
                        ]
                    }.unique()
            ]
        }

        render result as JSON;

    }
}
