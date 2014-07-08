package com.zy.work

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class StoreResourceService {

    def create(Store dto) {
        dto.save()
    }

    def read(id) {
        def obj = Store.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Store.class, id)
        }
        obj
    }

    def readAll() {
        Store.findAll()
    }

    def readAll(def params) {
        Store.list(params)
    }

    def update(Store dto) {
        def obj = Store.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Store.class, dto.id)
        }
        obj.properties = dto.properties
        obj
    }

    void delete(id) {
        def obj = Store.get(id)
        if (obj) {
            obj.delete()
        }
    }
}
