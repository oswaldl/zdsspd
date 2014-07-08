package com.zy.work

import jline.internal.Log

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SampleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def listByPage = {
        params.max = Math.min(params.max ?: 10, 100)
        render(contentType: "application/json") {
            Sample.list(params)
        }
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        println params
        Log.info "log:"+params
        respond Sample.list(params), model:[sampleInstanceCount: Sample.count()]
    }

    def show(Sample sampleInstance) {
        respond sampleInstance
    }

    def create() {
        respond new Sample(params)
    }

    @Transactional
    def save(Sample sampleInstance) {
        if (sampleInstance == null) {
            notFound()
            return
        }

        if (sampleInstance.hasErrors()) {
            respond sampleInstance.errors, view:'create'
            return
        }

        sampleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sample.label', default: 'Sample'), sampleInstance.id])
                redirect sampleInstance
            }
            '*' { respond sampleInstance, [status: CREATED] }
        }
    }

    def edit(Sample sampleInstance) {
        respond sampleInstance
    }

    @Transactional
    def update(Sample sampleInstance) {
        if (sampleInstance == null) {
            notFound()
            return
        }

        if (sampleInstance.hasErrors()) {
            respond sampleInstance.errors, view:'edit'
            return
        }

        sampleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Sample.label', default: 'Sample'), sampleInstance.id])
                redirect sampleInstance
            }
            '*'{ respond sampleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Sample sampleInstance) {

        if (sampleInstance == null) {
            notFound()
            return
        }

        sampleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Sample.label', default: 'Sample'), sampleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sample.label', default: 'Sample'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
