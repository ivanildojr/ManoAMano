package manoamano

import jprogress.JProgressTagLib

class TesteController {
	def progressService
	def rodar() {


		def linha;
		int n_arquivo=0;
		int atual=0
		int progresso = 0
		int n_linha=0

		if(new File("uploadLogs/").exists()) {
			new File("uploadLogs/").eachFile { file-> n_arquivo++; }
			new File("uploadLogs/").eachFile { file->
				//Renderiza o numero do arquivo
				progresso = 100 * atual / n_arquivo
				atual++
				progressService.setProgressBarValue("barraProgresso", progresso)

				println "Quantidade de arquivos: $n_arquivo"

				file.withReader { reader->
					while ((linha = reader.readLine())!=null) {
						n_linha++;
						if(linha.contains("with \"knife\"")) {




							//Nome do Matador
							def nomeMatador = linha.substring(linha.indexOf("\"") + 1, linha.indexOf("<"));



							def existeMatador = Jogador.findAll { nome == nomeMatador }

							Jogador matador = new Jogador()



							if(existeMatador.empty){
								matador.nome = nomeMatador
								matador.save(flush:true)
								println "Salvou Jogador com sucesso!"
							}else{
								matador = existeMatador.get(0)
							}

							//Somente para achar o nome Killed
							def subLinha = linha.substring(linha.indexOf("killed \""));


							//Extrai o nome da Vitima
							def nomeVitima = subLinha.substring(subLinha.indexOf("\"") + 1, subLinha.indexOf("<"));


							def existeVitima = Jogador.findAll { nome == nomeVitima }

							Jogador vitima = new Jogador()

							if(existeVitima.empty){
								vitima.nome = nomeVitima
								vitima.save(flush:true)
								println "Salvou com sucesso!"
							}else{
								vitima = existeVitima.get(0)
							}

							Vitima assassinato = new Vitima()

							assassinato.matador = matador
							assassinato.vitima = vitima


							Facadas facada = new Facadas()

							facada.qtdeFacadas = 1;

							String dataFacada =  linha.substring(2, 12);

							println "Data original: " + dataFacada

							Date dataFacadaFormatada = Date.parse('MM/dd/yyyy',dataFacada)

							println "Data convertida: " + dataFacadaFormatada.format('yyyy-MM-dd')

							String dataFormatada = dataFacadaFormatada.format('yyyy-MM-dd')

							Date dataFinal = Date.parse('yyyy-MM-dd',dataFormatada)

							facada.dataFacada =  dataFinal

							facada.vitima = assassinato

							assassinato.dataFacada = dataFinal


							def existeAssassianto = Vitima.findAllByMatadorAndVitimaAndDataFacada(matador,vitima,dataFinal)
							println "O assassinato encontrato �: " + assassinato

							if(existeAssassianto.empty){
								assassinato.save(flush:true)
								println "Salvou com sucesso o assassinato!"
							}else{
								assassinato = existeAssassianto.get(0)
								println "Acho o assassinato: " + assassinato
							}



							def existeFacadas = Facadas.findAllByVitima(assassinato)
							println "Foram encontradas as seguintes facadas: " + existeFacadas

							if(existeFacadas.empty){
								facada.save(flush:true)
								println "Salvou com sucesso a facada!"
							}else{
								facada = existeFacadas.get(0)
								println "Facada:" + facada + " Quantidade de facadas antes: " + facada.qtdeFacadas
								//Automatic Dirty Detection - persiste a altera��o mesmo sem mandarmos salvar. Caso n�o se queira
								//o comportamento, usar read ao inv�s de get()
								//fonte: http://stackoverflow.com/questions/32503852/grails-2-4-4-updating-a-user-auto-saves-user-before-hitting-back-end-code
								facada.qtdeFacadas +=1
								println "Facada:" + facada + " Quantidade de facadas depois: " + facada.qtdeFacadas
							}








						}
					}
				}


			}
			progressService.setProgressBarValue("barraProgresso", 100)
			
			//apaga o diretorio com os logs apos o processamento
			File dir = new File("uploadLogs");
			if(!dir.isHidden()){  //se a pasta existe, apague-a
				dir.deleteDir();
				println "Apagou a pasta uploadLogs!"
			}
		}
		redirect(action:'principal', controller:'relatorio')
	}

	def upload(){
		render(view: "/teste/upload")

	}

	def progressAction = {
		for (int i = 1; i <= 100; i++) {

			//this updates the progress bar value for the progress id 123
			progressService.setProgressBarValue("barraProgresso", i)

			//let's waste some time
			for (int a = 0; a < 5000; a++) {

				for (int b = 0; b < 1000; b++) {

				}
			}
		}

		render "the progress is done"
	}


}
