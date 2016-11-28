package manoamano

class RelatorioController {

    def index() {

		def jogadores = Jogador.findAll {
			order('nome','asc')
			
		}
		
		def lista = Facadas.withCriteria {
			vitima {
				matador{
					order('nome','asc')
				}
			}
			//ge 'dataFacada', new Date().clearTime()
			
		}
		
//		def lista = Facadas.findAll {
//			vitima.matador.nome == 'Kratos'
//		}
		
		
		for(facada in lista){
		
			def nomes = facada.vitima.matador.nome +" - "+ facada.vitima.vitima.nome
			def quantidade = facada.qtdeFacadas
			def resultado = nomes + " - " + quantidade
			println  resultado
		
		}
		
		println jogadores
		render(view:'index',model:[facadasList:lista,jogadoresList:jogadores])
		
		
		
	}
}
