package user

import com.sun.org.apache.xpath.internal.operations.Bool
import tech.UserTech
import grails.rest.*
import grails.converters.*

class UserController {

    def findAllUsers(){
        findFilteredUsers({true})
    }


    def findUsersByString(){

        String hay = params.hay

        def closure = {
            user->
                if([user.name, user.twitter].any{it.contains(hay)})
                    return true

                return user.languages.any{it.name.contains(hay) || it.value.contains(hay)}
        }
        findFilteredUsers(closure)
    }

    def findPremiumUsers(){

        String hay = params.hay

        def closure = {
            user->
                user.premium
        }
        findFilteredUsers(closure)
    }


    private findFilteredUsers(Closure<Boolean> filter){
        def allUsers = User.list().sort{it.userOrder}
        def allUserTechsByUser = UserTech.list().groupBy{
            it.user
        }


        def result = allUsers.collect{
            user -> [
                    id: user.id,
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

        result = result.findAll(filter)

        render result as JSON

    }

    def updatePremium(long userId){
        println userId
        User user = User.get(userId)

        user.premium = params.value.toBoolean()

        user.save()

        render user as JSON
    }
}


