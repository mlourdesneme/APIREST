package com.mercadolibre.itacademy

import grails.rest.Resource

class Articulo {

    int id
    String name
    String picture
    int total_items_in_this_category
    static belongsTo = [marca: Marca]


    static constraints = {
        name blank: false, nullable: false
    }
}
