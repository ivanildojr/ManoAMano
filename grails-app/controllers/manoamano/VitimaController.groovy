package manoamano



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VitimaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Vitima.list(params), model:[vitimaInstanceCount: Vitima.count()]
    }

    def show(Vitima vitimaInstance) {
        respond vitimaInstance
    }

    def create() {
        respond new Vitima(params)
    }

    @Transactional
    def save(Vitima vitimaInstance) {
        if (vitimaInstance == null) {
            notFound()
            return
        }

        if (vitimaInstance.hasErrors()) {
            respond vitimaInstance.errors, view:'create'
            return
        }

        vitimaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vitima.label', default: 'Vitima'), vitimaInstance.id])
                redirect vitimaInstance
            }
            '*' { respond vitimaInstance, [status: CREATED] }
        }
    }

    def edit(Vitima vitimaInstance) {
        respond vitimaInstance
    }

    @Transactional
    def update(Vitima vitimaInstance) {
        if (vitimaInstance == null) {
            notFound()
            return
        }

        if (vitimaInstance.hasErrors()) {
            respond vitimaInstance.errors, view:'edit'
            return
        }

        vitimaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Vitima.label', default: 'Vitima'), vitimaInstance.id])
                redirect vitimaInstance
            }
            '*'{ respond vitimaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Vitima vitimaInstance) {

        if (vitimaInstance == null) {
            notFound()
            return
        }

        vitimaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Vitima.label', default: 'Vitima'), vitimaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vitima.label', default: 'Vitima'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
