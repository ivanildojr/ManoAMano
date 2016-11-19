package manoamano

class Vitima {
	
	//Mapeia o atributo da classe Jogador
	static mappedBy = [matador: 'nome',vitima: 'nome']
	
	static belongsTo = [matador:Jogador, vitima:Jogador]
	
	
	
    static constraints = {
		matador nullable:false
		vitima nullable:false
    }
	
	String toString() {
		"$matador - $vitima"
	}
	
	
	
}
