


#include <asf.h>

#define LED_VERDE 1<<20
#define LED_AZUL 1<<19
#define BTN 1<<3

int main (void)
{
	/* Insert system clock initialization code here (sysclk_init()). */

	sysclk_init();

	board_init();



	/* Insert application code here, after the board has been initialized. */

	//MESMA COISA Q (*PIOA).PIO_PER
	//BOTAR 1 NA POSIÇAÕ 20 PODE SER, O |= EH DA MASCARA PRA N ZERAR TD  :
	PIOA->PIO_PER |= LED_VERDE |LED_AZUL;
	PIOA->PIO_OER |= LED_VERDE |LED_AZUL;
	//PIOA->PIO_CODR |= LED_VERDE |LED_AZUL;
	
	PIOB->PIO_PER |= BTN;
	PIOB->PIO_ODR |= BTN;

	

	
	while(1){
	
	/*PIOA->PIO_CODR |= LED_VERDE;
	PIOA->PIO_SODR |= LED_AZUL;
	
	while(PIOB->PIO_ODR == BTN){

	PIOA->PIO_CODR |= LED_AZUL;
	PIOA->PIO_SODR |= LED_VERDE;

	
	} */

	//N PRECISA DO == BTN

		if((PIOB->PIO_PDSR & BTN) == BTN){
		PIOA->PIO_SODR |= LED_AZUL;
		
		PIOA->PIO_CODR |= LED_VERDE;
		delay_ms(500);
		//fazer piscar
				
		
		
		}else 
		{
		PIOA->PIO_CODR |= LED_AZUL;
		PIOA->PIO_SODR |= LED_VERDE;
		}



	}



}
