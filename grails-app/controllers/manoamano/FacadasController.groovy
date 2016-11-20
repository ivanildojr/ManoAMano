package manoamano



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FacadasController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    
	
	def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Facadas.list(params), model:[facadasInstanceCount: Facadas.count()]
    }

    def show(Facadas facadasInstance) {
        respond facadasInstance
    }

    def create() {
        respond new Facadas(params)
    }

    @Transactional
    def save(Facadas facadasInstance) {
        if (facadasInstance == null) {
            notFound()
            return
        }

        if (facadasInstance.hasErrors()) {
            respond facadasInstance.errors, view:'create'
            return
        }

        facadasInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'facadas.label', default: 'Facadas'), facadasInstance.id])
                redirect facadasInstance
            }
            '*' { respond facadasInstance, [status: CREATED] }
        }
    }

    def edit(Facadas facadasInstance) {
        respond facadasInstance
    }

    @Transactional
    def update(Facadas facadasInstance) {
        if (facadasInstance == null) {
            notFound()
            return
        }

        if (facadasInstance.hasErrors()) {
            respond facadasInstance.errors, view:'edit'
            return
        }

        facadasInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Facadas.label', default: 'Facadas'), facadasInstance.id])
                redirect facadasInstance
            }
            '*'{ respond facadasInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Facadas facadasInstance) {

        if (facadasInstance == null) {
            notFound()
            return
        }

        facadasInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Facadas.label', default: 'Facadas'), facadasInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'facadas.label', default: 'Facadas'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
