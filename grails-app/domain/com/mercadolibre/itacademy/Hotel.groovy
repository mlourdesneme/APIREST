package com.mercadolibre.itacademy

import grails.rest.Resource

@Resource(uri='/hotels')

class Hotel {

    String name

    //un hotel tiene muchas habitaciones, rep un arraylist de habitaciones en java
    static hasMany = [rooms: Room]

    static constraints = {
        name blank: false, nullable: false
    }

}
