package com.zy.work

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.core.Response

import org.grails.jaxrs.provider.DomainObjectNotFoundException

@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class TaskResource {

    def taskResourceService
    def id

    @GET
    Response read() {
        ok taskResourceService.read(id)
    }

    @PUT
    Response update(Task dto) {
        dto.id = id
        ok taskResourceService.update(dto)
    }

    @DELETE
    void delete() {
        taskResourceService.delete(id)
    }
}
