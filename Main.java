/*********************************************************************************/
/**   ACH2002 - Introducao a Analise de Algoritmos                  			**/
/**   EACH-USP - Segundo Semestre de 2020                           			**/
/**   Turma: 94 - Professor: Flavio Luiz Coutinho                               **/
/**                                                                 			**/
/**   Priemiro Exercicio-Programa                                   			**/
/**                                                                 			**/
/**   Nome da aluna: Gabriela Jie Han                  Numero USP: 11877423     **/
/**                                                                 			**/
/**   Data de entrega: 15/11/2020                                               **/
/*********************************************************************************/

import java.util.*;
import java.io.*;

/*********************************************************************************/
/*    PROGRAMA PRINCIPAL.													     */
/*********************************************************************************/
public class Main {

	public static void generateImage(String inputFileName, String outputFileName) throws IOException {

		Scanner scanner = new Scanner(new File(inputFileName));

		ImageEx image = new ImageEx(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
	
		while(scanner.hasNext()){

			String command = scanner.next();

			if(command.equals("SET_COLOR")){

				image.setColor(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}

			if(command.equals("SET_PIXEL")){

				image.setPixel(scanner.nextInt(), scanner.nextInt());
			}

			if(command.equals("DRAW_LINE")){

				image.drawLine(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}

			/*********************************************************************/
			/*    COMANDO KOCH_CURVE, no qual 5 comandos serao especificados:    */
			/*    	- Coordenadas do ponto P (px e py)							 */
			/*    	- Coordenadas do ponto Q (qx e qy)							 */
			/*    	- O valor l do limiar										 */
			/*********************************************************************/
			if(command.equals("KOCH_CURVE")){

				image.kochCurve(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}

			/*********************************************************************/
			/*    COMANDO REGION_FILL, no qual 2 comandos serao especificados:   */
			/*    	- Coordenadas x e y do ponto a partir do qual o 			 */
			/*    	  preenchimento serah realizado								 */
			/*    Alem disso, pegara a cor que jah esta pintada no pixel x e y	 */
			/*    escolhido pelo usuario.		 								 */
			/*********************************************************************/
			if(command.equals("REGION_FILL")){

				int x = scanner.nextInt();
				int y = scanner.nextInt();
				image.regionFill(x, y, image.getPixel(x, y));
			}
		}

		image.save(outputFileName);
	}

	public static void main(String [] args){


		if(args.length != 2){
	
			System.out.println("Uso: java " + Main.class.getName() + " entrada.txt saida.png");
			System.exit(1);
		}

		try{
			generateImage(args[0], args[1]);
		}
		catch(IOException e){
			
			System.out.println("Problem generating image... :(");
			e.printStackTrace();
		}
	}
}
