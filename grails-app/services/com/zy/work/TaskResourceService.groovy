package com.zy.work

import org.grails.jaxrs.provider.DomainObjectNotFoundException

class TaskResourceService {

    def create(Task dto) {
        dto.save()
    }

    def read(id) {
        def obj = Task.get(id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Task.class, id)
        }
        obj
    }

    def readAll() {
        Task.findAll()
    }

    def readAll(def params) {
        Task.list(params)
    }

    def findAllByAssignee(def params,def assignee){
        Task.findAllByExecutor(assignee,params)
    }

    def update(Task dto) {
        def obj = Task.get(dto.id)
        if (!obj) {
            throw new DomainObjectNotFoundException(Task.class, dto.id)
        }
        obj.properties = dto.properties
        obj
    }

    void delete(id) {
        def obj = Task.get(id)
        if (obj) {
            obj.delete()
        }
    }
}
