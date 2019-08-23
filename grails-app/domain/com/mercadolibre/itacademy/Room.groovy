package com.mercadolibre.itacademy

import grails.rest.Resource

@Resource(uri='/rooms')//path a traves del que accedo por medio de una API REST

class Room {

    int number

    static belongsTo = [hotel: Hotel]

    static constraints = {
        number min: 100, max:530
    }



}
