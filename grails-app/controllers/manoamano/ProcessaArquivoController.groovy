package manoamano

import java.text.DateFormat
import java.text.SimpleDateFormat

class ProcessaArquivoController {
	
	def redireciona(){
		redirect(action:'upload',controller:'teste')
	}
}
