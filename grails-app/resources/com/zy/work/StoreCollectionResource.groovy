package com.zy.work

import javax.ws.rs.QueryParam

import static org.grails.jaxrs.response.Responses.*

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.POST
import javax.ws.rs.core.Response

@Path('/api/store')
@Consumes(['application/xml', 'application/json'])
@Produces(['application/xml', 'application/json'])
class StoreCollectionResource {

    def storeResourceService

    @POST
    Response create(Store dto) {
        created storeResourceService.create(dto)
    }

    @GET
    Response readAll(@QueryParam('max') Long max,
                     @QueryParam('offset') Long offset) {
        def params = [:]
        params.max = max
        params.offset = offset
        ok storeResourceService.readAll(params)
    }

    @Path('/{id}')
    StoreResource getResource(@PathParam('id') Long id) {
        new StoreResource(storeResourceService: storeResourceService, id: id)
    }

    @GET
    @Path('/{id}/tasks')
    Response getStoreTasks(@PathParam('id') Long id) {
        def store = Store.get(id)
        if(store){
            ok store.tasks
        }else{
            'no store with id '+id
        }

    }
}
