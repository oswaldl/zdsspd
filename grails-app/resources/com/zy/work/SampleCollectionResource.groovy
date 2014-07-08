package com.zy.work

import jline.internal.Log

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.POST
import javax.ws.rs.core.Response

@Path('/api/sample')
@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class SampleCollectionResource {

    def sampleResourceService

    @POST
    Response create(Sample dto) {
        created sampleResourceService.create(dto)
    }

    @GET
    Response readAll() {
        Log.info "by log:list samples.."
        ok sampleResourceService.readAll()
    }


    @Path('/{id}')
    SampleResource getResource(@PathParam('id') Long id) {
        new SampleResource(sampleResourceService: sampleResourceService, id:id)
    }

}
