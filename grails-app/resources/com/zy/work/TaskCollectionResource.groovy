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

@Path('/api/task')
@Consumes(['application/xml','application/json'])
@Produces(['application/xml','application/json'])
class TaskCollectionResource {

    def taskResourceService

    @POST
    Response create(Task dto) {
        created taskResourceService.create(dto)
    }

    @GET
    Response readAll(
            @QueryParam('max') Long max,
            @QueryParam('offset') Long offset) {
        def params = [:]
        params.max = max
        params.offset = offset
        ok taskResourceService.readAll(params)
    }

    @Path('/{id}')
    TaskResource getResource(@PathParam('id') Long id) {
        new TaskResource(taskResourceService: taskResourceService, id:id)
    }


    @GET
    @Path('/assignee/{assignee}')
    Response getTaskByAssignee(
            @PathParam('assignee') String assignee,
            @QueryParam('max') Long max,
            @QueryParam('offset') Long offset) {
        def params = [:]
        params.max = max
        params.offset = offset
        ok taskResourceService.findAllByAssignee(params , assignee)
    }
}
