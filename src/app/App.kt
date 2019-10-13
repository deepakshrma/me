package app

import kotlinx.html.*
import logo.workInProgress
import react.*
import react.dom.*
import react.router.dom.*

interface EmptyProps : RProps {
}

interface EmptyState : RState {
}

data class Link(val name: String, val route: String)
class HeaderComponent(props: EmptyProps) : RComponent<EmptyProps, EmptyState>(props) {
    override fun RBuilder.render() {
        val links = listOf(Link("Home", "/"), Link("About Me", "/me"), Link("Resume", "/resume"))
        div("App-header") {
            ul("links") {
                for (link in links) {
                    li("links__link") {
                        navLink(link.route) {
                            +link.name
                        }
                    }
                }
            }

        }
    }
}

fun RBuilder.header() = child(HeaderComponent::class) {}
class HomeComponent(props: EmptyProps) : RComponent<EmptyProps, EmptyState>(props) {
    override fun RBuilder.render() {
        header()
        h2 {
            +"Welcome to my website "
            a("https://github.com/deepakshrma") { +"{Deepak Vishwakarma}" }
        }
        p("App-intro") {
            +"This website build on Koltin"
        }
        workInProgress()
    }
}

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        browserRouter {
            switch {
                route("/", HomeComponent::class, exact = true)
                route("/me", strict = true) {
                    div {
                        header()
                        workInProgress()
                    }
                }
                route<EmptyProps>("/resume") { _ ->
                    div {
                        header()
                        div("content") {

                            a {
                                attrs {
                                    href = "https://docs.google.com/document/d/1oZ6iGdiALawzS6xlFC_Uwcms04SrD6Wk6NML6CDhxjM/export?format=pdf"
                                    +"Download"
                                }
                            }
                            iframe(IframeSandbox.allowSameOrigin, "full__screen__iframe") {
                                attrs {
                                    src = "https://docs.google.com/document/d/e/2PACX-1vTR3ndWxpXUwpZOKL81B46wxNw1CfvVFWE9nzve5gGxz8qqKi8u_jFrxdL-NgDEEPRRjGFDTuL-hQEy/pub?embedded=true"
                                }
                            }
                        }
                    }

                }
                redirect(from = "*", to = "/")
            }
        }


    }
}

fun RBuilder.app() = child(App::class) {}
