package manoamano

import java.text.DateFormat
import java.text.SimpleDateFormat

class ProcessaArquivoController {

 	def rodar() {
		def linha;
		def int n=0;
		new File("uploadLogs/").eachFile { file->
			file.withReader { reader->
				while ((linha = reader.readLine())!=null) {
					if(linha.contains("with \"knife\"")) {
						
						Facadas checkDatafacada = new Facadas()
						String dataArquivo =  linha.substring(2, 12);
						Date dataArquivoFormatada = Date.parse('MM/dd/yyyy',dataArquivo)
						String dataArquivoFormatadaFinal = dataArquivoFormatada.format('yyyy-MM-dd')
						Date dataFinalArquivo = Date.parse('yyyy-MM-dd',dataArquivoFormatadaFinal)
						def processaArquivo = Facadas.findAllByDataFacada(dataFinalArquivo)
						
						if(processaArquivo.empty){
						
						
						//Nome do Matador
						def nomeMatador = linha.substring(linha.indexOf("\"") + 1, linha.indexOf("<"));
						
						
						
						def existeMatador = Jogador.findAll {
							nome == nomeMatador
						}
						
						Jogador matador = new Jogador()
						
						println existeMatador.empty
						
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

												
						def existeVitima = Jogador.findAll {
							nome == nomeVitima
						}
						
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
						
						
						def existeAssassianto = Vitima.findAllByMatadorAndVitima(matador,vitima)
						println "O assassinato encontrato é: " + assassinato
						
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
							facada.qtdeFacadas +=1
							println "Facada:" + facada + " Quantidade de facadas depois: " + facada.qtdeFacadas
						}



						
						
						
						
						}else{
							println "O arquivo ja havia sido processado no banco de dados: " + file.getName() + " !!!!"
							break
						}
					}	
				}
			}
			
			
		}
		//apaga o diretorio com os logs apos o processamento
		File dir = new File("uploadLogs");
		if(!dir.isHidden()){  //se a pasta existe, apague-a
			dir.deleteDir();
			println "Apagou a pasta uploadLogs!"
		}

	}	
	
	def teste() {
		File dir = new File("uploadLogs");
		new File("uploadLogs").eachFile() { file->
			println file.getAbsolutePath()
		}
	}
}
