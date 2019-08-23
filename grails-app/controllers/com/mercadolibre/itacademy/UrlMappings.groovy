package com.mercadolibre.itacademy

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/marcas" (resources:"marca") {
            "/articulos" (resources: "articulo")
        }

        "/articulos" (resources: "articulo")



    }
}
