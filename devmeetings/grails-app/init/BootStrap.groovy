import user.User
import tech.UserTech
import tech.Tech

class BootStrap {

    def init = { servletContext ->

        User pablo = new User(
                name :"Pablo González Doval",
                premium: true,
                twitter: "@dovaleac",
                userOrder: 1
        ).save()

        User rafa = new User(
                name :"Rafael Bermúdez Míguez",
                premium: false,
                twitter: "@rafbermudez",
                userOrder: 4
        ).save()

        User fer = new User(
                name :"Fernando García Pichel",
                premium: false,
                twitter: "@fergpichel",
                userOrder: 5
        ).save()

        User macaco = new User(
                name :"Macaco",
                photo: "monito.png",
                premium: true,
                twitter: "@inf_monkeys",
                userOrder: 3
        ).save()

        User dartagnan = new User(
                name :"D'Artagnan",
                photo: "dart.png",
                premium: true,
                twitter: "@madriddug",
                userOrder: 2
        ).save()

        Tech dart = new Tech(name:"Dart").save()
        Tech polymer = new Tech(name:"Polymer").save()
        Tech interview = new Tech(name:"Interview problem-solving").save()
        Tech groovy = new Tech(name:"Groovy").save()
        Tech spread = new Tech(name:"Spreading knowledge").save()

        new UserTech(user:pablo, tech: dart, value: "I love it!").save()
        new UserTech(user:pablo, tech: polymer, value: "Totally amazing!").save()
        new UserTech(user:pablo, tech: groovy, value: "So easy!").save()
        new UserTech(user:pablo, tech: spread, value: "Ask me whatcha want, baby").save()

        new UserTech(user:rafa, tech: dart, value: "It will rule the world").save()
        new UserTech(user:rafa, tech: interview, value: "I beat you!").save()
        new UserTech(user:rafa, tech: groovy, value: "Please, so so easy!").save()
        new UserTech(user:rafa, tech: spread, value: "Ask me whatcha want, baby").save()

        new UserTech(user:fer, tech: dart, value: "Whatever...").save()
        new UserTech(user:fer, tech: polymer, value: "I will build you by parts").save()
        new UserTech(user:fer, tech: spread, value: "Ask me whatcha want, baby").save()

        new UserTech(user:macaco, tech: polymer, value: "I like it!").save()
        new UserTech(user:macaco, tech: interview, value: "This is what I'm all about").save()
        new UserTech(user:macaco, tech: groovy, value: "You will understand me better").save()
        new UserTech(user:macaco, tech: spread, value: "Mmm I love it!").save()

        new UserTech(user:dartagnan, tech: dart, value: "I created it").save()
        new UserTech(user:dartagnan, tech: polymer, value: "We could get on well, sir").save()
    }
    def destroy = {
    }
}
