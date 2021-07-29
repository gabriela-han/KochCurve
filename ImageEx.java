/*********************************************************************************/
/**   ACH2002 - Introducao a Analise de Algoritmos                  		**/
/**   EACH-USP - Segundo Semestre de 2020                           		**/
/**   Turma: 94 - Professor: Flavio Luiz Coutinho                               **/
/**                                                                 		**/
/**   Priemiro Exercicio-Programa                                   		**/
/**                                                                 		**/
/**   Nome da aluna: Gabriela Han                  			     	**/
/**                                                                 		**/
/**   Data de entrega: 15/11/2020                                               **/
/*********************************************************************************/

/*********************************************************************************/
/*    Classe que possui os metodos kochCurve() e regionFill(), os quais 	 */
/*	  irao, respectivamente, desenhar a Curva de Koch e preencher a forma	 */
/*    segundo as coordenadas recebidas de um pixel.				 */
/*********************************************************************************/
public class ImageEx extends Image {

	public ImageEx(int w, int h, int r, int g, int b){

		super(w, h, r, g, b);
	}

	public ImageEx(int w, int h){

		super(w, h);
	}
	
/*********************************************************************************/
/*    METODO kochCurve()							 */
/*	  Nos parametros, recebe as coordenadas de P=(px, py) e Q=(qx, qy) e l,	 */
/*	  o valor do limiar.							 */
/*										 */
/*    1) Se comprimento do segmento PQ for menor que l, desenha o segmento PQ    */
/*    	 que esta representado como c.						 */
/*    2) Caso contrario:                                                         */
/*        2.1) Calcula os pontos A=(Ax,Ay), B=(Bx,By), C=(Cx,Cy).                */
/*        2.2) Chama o algoritmo recurivamente para PA, AB, BC e CQ.             */
/*********************************************************************************/
	public void kochCurve(int px, int py, int qx, int qy, int l){
		
        int c = (int)(Math.round(compSegmento(px, py, qx, qy)));

		if(c < l){ 
		
			drawLine(px, py, qx, qy);
		}else{

			/*calculando as coordenadas dos pontos e seus auxiliares*/

			//diferenca entre qx e px
			double difx = qx-px;
			//diferenca entre qy e py
			double dify = qy-py;
			
			//calculando as coordenadas do ponto A
			int Ax = (int)(Math.round(px+((difx)/3)));
			int Ay = (int)(Math.round(py+((dify)/3)));

			//calculando as coordenadas do ponto C
			int Cx = (int)(Math.round(2*((difx)/3)))+px;
			int Cy = (int)(Math.round(2*((dify)/3)))+py;

			//calculando ponto auxiliar para calcular B
			double Ux = ((qy-py)*(Math.sqrt(3)/6));
			double Uy = (-(difx)*(Math.sqrt(3)/6));

			//calculando o ponto medio de c
			double Mx = (px+Math.round((difx)/2));
			double My = (py+Math.round((dify)/2));

			//calculando as coordenadas do ponto B
			int Bx = (int)(Math.round(Mx+Ux)); 
			int By = (int)(Math.round(My+Uy)); 


			/*chamadas recursivas*/

			//segmento PA
			kochCurve(px, py, Ax, Ay, l);

			//segmento AB
			kochCurve(Ax, Ay, Bx, By, l);

			//segmento BC
			kochCurve(Bx, By, Cx, Cy, l);

			//segmento CQ
			kochCurve(Cx, Cy, qx, qy, l);
		}
	}

/*********************************************************************************/
/*    METODO AUXILIAR compSegmento() - calcula o comprimento de cada segmento.   */
/*    Nos parametros, recebe as coordenadas (x, y) das extremidades do segmento	 */
/*	  a ser caclulado. 							 */
/*********************************************************************************/ 
	private static int compSegmento(int px, int py, int qx, int qy) {
			
		int comprimento = (int)(Math.round(Math.sqrt(Math.pow((px-qx), 2)+Math.pow((py-qy), 2))));
		return comprimento;
	}


/*********************************************************************************/
/*    METODO regionFill()  							 */
/*	  Nos parametros, recebe as coordenadas (x, y) do pixel a partir do qual */
/* 	  sera feito o preenchimento e reference_rgb, que determina a partir de  */
/*	  qual cor de pixel serah pintado.					 */
/*    					  					 */
/*    1) Se x e y recebidos como parametro forem maiores ou igual a altura ou	 */
/*		 a lagura jah estabelecidas ou menores que 0, nada acontecera.	 */
/*    2) Mas, se o valor de cor do pixel original(parametro) for igual do    	 */
/*       pixel inicial, entao o mesmo pixel eh colorido e, em seguida, chamara	 */
/*		 o algoritmo recursivamente para os pixels vizinhos.     	 */
/*********************************************************************************/ 
	public void regionFill(int x, int y, int reference_rgb){

		//caso as coordenadas recebidas estiverem fora da area jah determinada nada acontece
		if(x>=getWidth() || x<0 || y<0 || y>=getHeight()) return;

		//corRef == cor que jah esta pintado na imagem
		int corRef = getPixel(x, y);

		//caso contrario, se a cor recebida como parametro == corRef, o pixel eh colorido
		//e, sao realizadas chamadas recursivas para os pixels vizinhos
		if(reference_rgb == corRef){

			setPixel(x, y);
			regionFill(x, y+1, reference_rgb);
			regionFill(x, y-1, reference_rgb);
			regionFill(x+1, y, reference_rgb);
			regionFill(x-1, y, reference_rgb);
		}
	}
}
