package com.mercadolibre.itacademy

import grails.rest.RestfulController

import javax.xml.bind.ValidationException

class ArticuloController extends RestfulController<Articulo>{

    static responseFormats = ['json']

    ArticuloController() {
        super(Articulo)
    }

    def index() {
        def marcaId = params.marcaId
        if(marcaId != null) {
            respond Articulo.where {
                marca.id == marcaId
            }.list()
        } else {
            respond Articulo.list()
        }
    }

}
