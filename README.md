## KochCurve
#Exercício Programa (EP): Desenhando a Curva de Koch e Preenchendo a Região

#SOBRE O PROGRAMA:
  Esta pasta é composta por este arquivo README.pdf, 3 códigos em "*.java" e 7 arquivos em "*.txt".
  Mais sobre os códigos em java (comentados com mais detalhe em cada arquivo):
  
  1) Image.java possui a classe Image que não deve ser modificada.

  2) ImageEx.java possui a classe ImageEx que estende a classe Image. 
  Esta é composta por 3 métodos principais:
  2.4) kochCurve(), o qual é recursivo e é responsável por desenhar a Curva de Koch. Esse recebe as coordenadas (px, py) do primeiro ponto (P), as coordenadas (qx, qy) do segundo ponto (Q) e l, o valor limiar da curva. Em outras palavras, enquanto o comprimento do segmento PQ for maior que l, novas linhas serão desenhadas para formar a Curva de Koch.
  2.2) compSegmento(), um método auxiliar de kochCurve(), que de acordo com as coordenas de dois pontos, calcula o comprimento do segmento entre esses pontos.
  2.3) regionFill(), é recursivo e é responsável por pintar uma determinada região, isto é, este método recebe as coordenadas de um determinado pixel e a cor (rgb) do mesmo e, enquanto a cor do pixel inicial é igual ao seu e aos do que estão ao seu redor, esses são pintado com a nova cor.

  3) Main.java recebe 2 parâmetros na linha de comando, para que o programa seja executado.

#Mais sobre os arquivos "**.txt*":
  Eles são responsáveis por realizar o teste do programa, isto é, esses contêm as definições para a criação de uma imagem (dimensões e cor de fundo), bem como comandos de desenhos para serem executados.
  entrada.txt = desenha o Logo original da Síntese Jr., a Empresa Júnior de Sistemas de Informações da EACH. 
  entrada1.txt = desenha o Logo da Síntese Jr., porém em 3 tons de verde e com um gorro de Natal.
  entrada2.txt = desenha o Logo da Síntese Jr., porém em 3 tons de verde, com um gorro de Natal e 3 flocos de neve (cada floco realizado com 4 Curva de Koch
