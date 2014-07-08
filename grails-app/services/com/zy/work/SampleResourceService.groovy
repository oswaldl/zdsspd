package com.zy.work

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class SampleResourceService {

    def create(Sample dto) {
        println "saving "+dto
        dto.save(failOnError: true)
    }

    def read(id) {
        def obj = Sample.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Sample.class, id)
        }
        obj
    }

    def readAll() {
        Sample.findAll()
    }

    def readAll(params) {
        Sample.list(params)
    }

    def update(Sample dto) {
        def obj = Sample.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Sample.class, dto.id)
        }
        obj.properties = dto.properties
        obj
    }

    void delete(id) {
        def obj = Sample.get(id)
        if (obj) {
            obj.delete()
        }
    }
}
