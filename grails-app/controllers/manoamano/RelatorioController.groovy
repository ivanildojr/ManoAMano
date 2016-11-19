package manoamano

class RelatorioController {

    def index() {
		def facadas = Facadas.executeQuery("select qtde_facadas from Facadas")
		for (facada in facadas){
			println "$facada"
		}
		
	}
}
