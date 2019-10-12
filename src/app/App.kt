package app

import react.*
import react.dom.*
import logo.*
import ticker.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            h2 {
                +"Welcome to my website "
                a("https://github.com/deepakshrma") { +"{Deepak Vishwakarma}" }
            }
            
        }
        p("App-intro") {
            +"This website build on Koltin => L0v3 "
        }
    }
}

fun RBuilder.app() = child(App::class) {}
