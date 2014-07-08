package com.zy.work

import grails.converters.XML
import jline.internal.Log

import javax.ws.rs.Path

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.PUT
import javax.ws.rs.POST
import javax.ws.rs.core.Response

import org.grails.jaxrs.provider.DomainObjectNotFoundException

@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class SampleResource {

    def sampleResourceService
    def id


    @GET
    Response read() {
        println "one sample.."
        ok sampleResourceService.read(id)
    }

    @PUT
    Response update(Sample dto) {
        dto.id = id
        ok sampleResourceService.update(dto)
    }


    @DELETE
    void delete() {
        sampleResourceService.delete(id)
    }
}
