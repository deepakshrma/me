package app

import kotlinx.html.*
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
            +"This website build on Koltin"
        }
        p("App-intro") {
            +"[<==< WORK IN PROGRESS >==>]"
        }
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

fun RBuilder.app() = child(App::class) {}
