package com.mercadolibre.itacademy

import grails.rest.Resource

class Articulo {

    int id
    String name
    String picture
    static belongsTo = [marca: Marca]
    int total_items_in_this_category

    static constraints = {
        name blank: false, nullable: false
    }
}
