package com.mercadolibre.itacademy

import grails.converters.JSON

import java.text.SimpleDateFormat

//se corre solo al inicializar

class BootStrap {

    def init = { servletContext ->

        def hotel1= new Hotel(name:'vista').save(flush:true) //obligando a grabar
        def hotel2= new Hotel(name:'Gran Hotel').save(flush:true)

        hotel1.addToRooms(new Room(number: 201)).save()
        hotel1.addToRooms(new Room(number: 202)).save()
        hotel1.addToRooms(new Room(number: 203)).save()

        hotel2.addToRooms(new Room(number: 204)).save()
        hotel2.addToRooms(new Room(number: 205)).save()
        hotel2.addToRooms(new Room(number: 206)).save()

        def marca1= new Marca(name:"Gafa").save(flush:true)
        def marca2= new Marca(name:"BGH").save(flush:true)
        def marca3= new Marca(name:"Electrolux").save(flush:true)
        def marca4= new Marca(name:"Philco").save(flush:true)


        marca1.addToArticulos(new Articulo(name: "Heladera", picture:"https://d34zlyc2cp9zm7.cloudfront.net/products/96ecf556" +
                "362ac933d23e5cf0884fb8aaf5f30494b1c61de592734a0cdab8e6e4.jpg_500", total_items_in_this_category: 15)).save()

        marca1.addToArticulos(new Articulo(name: "Freezer", picture:"https://d34zlyc2cp9zm7.cloudfront.net/products/a0588740683" +
                "bab9c99548a5f454f7db12aeaf4d720d7658cca076ff651cece34.jpg_500", total_items_in_this_category:20)).save()

        marca1.addToArticulos(new Articulo(name: "Pava electrica", picture:"https://www.authogar.com/media/catalog/product/cache/1" +
                "/thumbnail/600x/17f82f742ffe127f42dca9de82fb58b1/h/d/hd469120.jpg", total_items_in_this_category:345)).save()

        marca2.addToArticulos(new Articulo(name: "Horno", picture:"https://www.bringerihogar.com.ar/media/catalog/product/cache/1/imag" +
                "e/1000x1000/9df78eab33525d08d6e5fb8d27136e95/h/g/hgp2117e-hgp3017e-hgp4517e_gr_1.jpg", total_items_in_this_category:345)).save()

        marca2.addToArticulos(new Articulo(name: "Televisor", picture:"https://jumbocolombiafood.vteximg.com.br/arquivos/ids/3344522-750" +
                "-750/image-e8180d48663943a8bc3d6c4645f5cda9.jpg?v=636754675744000000", total_items_in_this_category:345)).save()

        marshaller()

    }
    def destroy = {

    }
    //recibimos un hotel y le damos una estructura diferente (lo convierte)
    private void marshaller(){
        JSON.registerObjectMarshaller(Hotel){
            hotel -> [
                    id: hotel.id,
                    name: hotel.name,
                    rooms: hotel.rooms.collect{
                        room -> [
                                id: room.id,
                                number: room.number
                        ]
                    }
            ]
        }
        JSON.registerObjectMarshaller(Room){
            room -> [
                    id: room.id,
                    number: room.number,
                    hotel: room.hotel.name,
                    date: new SimpleDateFormat("dd/MM/yyyy").format(new Date())
            ]
        }
        JSON.registerObjectMarshaller(Marca){
            marca -> [
                    id: marca.id,
                    name: marca.name
            ]
        }
        JSON.registerObjectMarshaller(Articulo){
            articulo -> [
                    id: articulo.id,
                    name: articulo.name,
                    picture: articulo.picture,
                    children_categories: [],
                    total_items_in_this_category: articulo.total_items_in_this_category
            ]
        }
    }
}
