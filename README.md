# KochCurve
### Exercício Programa (EP): Desenhando a Curva de Koch e Preenchendo a Região

### Sobre o Programa:
  Esta pasta é composta por este arquivo README.pdf, 3 códigos em "*.java" e 7 arquivos em "*.txt".
  Mais sobre os códigos em java (comentados com mais detalhe em cada arquivo):
  
  1) Image.java possui a classe Image que não deve ser modificada.

  2) ImageEx.java possui a classe ImageEx que estende a classe Image. 
  Esta é composta por 3 métodos principais:
  2.4) kochCurve(), o qual é recursivo e é responsável por desenhar a Curva de Koch. Esse recebe as coordenadas (px, py) do primeiro ponto (P), as coordenadas (qx, qy) do segundo ponto (Q) e l, o valor limiar da curva. Em outras palavras, enquanto o comprimento do segmento PQ for maior que l, novas linhas serão desenhadas para formar a Curva de Koch.
  2.2) compSegmento(), um método auxiliar de kochCurve(), que de acordo com as coordenas de dois pontos, calcula o comprimento do segmento entre esses pontos.
  2.3) regionFill(), é recursivo e é responsável por pintar uma determinada região, isto é, este método recebe as coordenadas de um determinado pixel e a cor (rgb) do mesmo e, enquanto a cor do pixel inicial é igual ao seu e aos do que estão ao seu redor, esses são pintado com a nova cor.

  3) Main.java recebe 2 parâmetros na linha de comando, para que o programa seja executado.

### Mais sobre os arquivos "**.txt*":
  Eles são responsáveis por realizar o teste do programa, isto é, esses contêm as definições para a criação de uma imagem (dimensões e cor de fundo), bem como comandos de desenhos para serem executados.
  <p> entrada.txt = desenha o Logo original da Síntese Jr., a Empresa Júnior de Sistemas de Informações da EACH. 
  <p> entrada1.txt = desenha o Logo da Síntese Jr., porém em 3 tons de verde e com um gorro de Natal.
  <p> entrada2.txt = desenha o Logo da Síntese Jr., porém em 3 tons de verde, com um gorro de Natal e 3 flocos de neve (cada floco realizado com 4 Curva de Koch).
  ![image](https://user-images.githubusercontent.com/65685306/127441008-e94fe753-23c3-477a-b356-54e4ef52fc6d.png)
  <p> entrada3.txt = desenha um abacate em um fundo preto.
  <p> entrada4.txt = desenha um abacate em um fundo branco com "montanhas" cinzas.
  <p> entrada5.txt = desenha um abacate em um fundo cinza com a Curva de Koch preenchida em branco.
  ![image](https://user-images.githubusercontent.com/65685306/127440936-46d26e44-ac16-4a42-9938-b39258a8ce82.png)
  <p> entrada6.txt = desenha um abacate em um fundo branco com a Curva de Koch preenchida em cinza.
  ![image](https://user-images.githubusercontent.com/65685306/127440916-c5f3b567-ca49-4fb4-aa08-8ba4f0eb91c9.png)

  
### Pré Requisitos:
  Para executar este programa é preciso ter somente o java instalado. Porém, para editar os códigos é recomendado 
instalar um editor de texto como o Visual Studio Code ou Notepad++.

### Como compilar:
  1) Abra o Prompt de Comando.
  2) Modifique o diretório do cmd para a pasta onde se encontra este pdf.
  3) Digite "javac Main.java" no terminal e apertar o botão "Enter".
  4) Para ver a imagem do arquivo...
      <p> entrada.txt digite "java -Xss200M Main entrada.txt saida.png" e aperte o botão "Enter".
      <p> entrada1.txt digite "java -Xss200M Main entrada1.txt saida1.png" e aperte o botão "Enter".
      <p> entrada2.txt digite "java -Xss200M Main entrada2.txt saida2.png" e aperte o botão "Enter".
      <p> entrada3.txt digite "java -Xss200M Main entrada3.txt saida3.png" e aperte o botão "Enter".
      <p> entrada4.txt digite "java -Xss200M Main entrada4.txt saida4.png" e aperte o botão "Enter".
      <p> entrada5.txt digite "java -Xss200M Main entrada5.txt saida5.png" e aperte o botão "Enter".
      <p> entrada6.txt digite "java -Xss200M Main entrada6.txt saida6.png" e aperte o botão "Enter".
      
      <p> Por fim, se todos os passos foram seguidos e, se o programa estiver sendo executado corretamente, as 7 imagens que correspondem ao que foi escrito em "Mais sobre os arquivos *.txt" poderão ser encontradas em formato "**.png*".
      
### Observações:
  1) O comprimento dos segmentos pode variar em até 3 unidades, visto que o valor desse foi arredondado para int.
  2) Lembre-se que o ponto x (horizontal) inicia em 0 e é crescente da esquerda para a direita. Já, o ponto y (vertical) inicia em 0 e é crescente de cima para baixo.
  3) Quando compilados, "-Xss200M" é utilizado para aumentar a pilha, pois as chamadas recursivas podem estourar a pilha. Porém, dependendo dos exemplos de entrada, pode ser preciso aumentar mais a pilha. Para isso, substitua o "200" em "-Xss200M" por algum outro valor que ache que será necessário para que a pilha não estoure.
  4) Caso queira fazer algum desenho, crie um arquivo "**.txt*". 
      4.1) primeira linha desse arquivo precisará conter, obrigatoriamente 5 valores inteiros que definem as dimensões da imagem (altura e largura) e as componentes r, g, b da cor de fundo da mesma. 
      4.2) Cada uma das demais linhas especifica um comando de desenho e os parâmetros exigidos por cada comando. Os seguintes comandos de desenho são válidos: SET_COLOR, SET_PIXEL, DRAW_LINE, KOCH_CURVE e REGION_FILL.
      4.3) Sobre os comandos:
            <p> SET_COLOR devem ser especificados 3 parâmetros inteiros, correspondentes às componentes r, g e b da cor de primeiro plano (cor esta que será usada pelos comandos de desenho subsequentes).
            <p> SET_PIXEL devem ser especificados 2 parâmetros inteiros, que são as coordenadas x e y do pixel a ser colorido.
            <p> DRAW_LINE devem ser especificados 4 valores inteiros: x1 e y1, (coordenadas de um dos pontos da reta), e x2 e y2 (coordenadas do outro ponto da reta).
            <p> KOCH_CURVE devem ser especificados 5 valores inteiros: px e py (coordenada do ponto P), qx e qy (coordenada do ponto Q), e o valor l do limiar. 
            <p> REGION_FILL devem ser especificados 2 valores inteiros referentes às coordenadas x e y do ponto a partir do qual o preenchimento será feito.

### Créditos:
  Programa realizado como exercício programa por Gabriela Jie Han, com o auxílio do "códigos esqueletos" do professor Flávio Luiz Coutinho da Escola de Artes, Ciências e Humanidades da Universidade de São Paulo, para matéria de Introdução à Análise de Algoritmos.
