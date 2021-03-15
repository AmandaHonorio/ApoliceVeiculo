# language: pt

@proposta
Funcionalidade: Preencher proposta de veiculo
	O sistema deve preencher todos os dados refente a proposta de veiculo
	
Esquema do Cenario: Preencher proposta
Dado que o usuario esteja na aba Enter Vehicle Data da pagina tricentis
Quando o usuario preencher os campos da tela Enter Vehicle Data
	| Make	 | Engine Performance   | Date of Manufacture | Number of Seats | Fuel Type   | List Price   | License Plate Number   | Annual Mileage   |
	| <make> | <engine_performance> | <date_manufacture>  | <number_seats>  | <fuel_type> | <list_price> | <license_plate_number> | <annula_mileage> |
E pressionar next da aba Enter Vehicle Data
Entao sera exibida a aba Enter Insurant Data
Quando o usuario preencher os campos da tela Enter Insurant Data
	| First Name | Last Name | Date of Birth | Gender | Street Address | Country  | Zip Code   | City			 | Occupation | Hobbies  | Website  		 |
	| Accentur   | Teste  	 | 02/02/1989    | male   | Rua Teste 12   | Brazil   | 01415001   | Sao Paulo | Employee   | Speeding | www.teste.com |
E pressionar next da aba Enter Insurant Data
Entao sera exibida a aba Enter Product Data
Quando o usuario preencher os campos da tela Enter Product Data
	| Start Date | Insurance Sum | Merit Rating | Damage Insurance | Optional Products | Courtesy Car | 
	| 04/30/2021 | 5000000       | Bonus 4  		| Partial Coverage | Euro Protection   | Yes   			 |
E pressionar next da aba Enter Product Data
Entao sera exibida a aba Select Price Option
Quando o usuario selecionar a opcao de preco "Gold"
E pressionar next da aba Select Price Option
Entao sera exibida a aba Send Quote
Quando o usuario preencher os campos da tela Send Quote
	| E-Mail 					| Phone				| Username | Password | Confirm Password |
	| teste@teste.com | 11999999999 | teste 	 | Teste123 | Teste123  			 | 
E pressionar Send
Entao sera exibida uma mensage de sucesso "Sending e-mail success!"


Exemplos:
| make  | engine_performance | date_manufacture | number_seats | fuel_type | list_price | license_plate_number | annula_mileage |
| Mazda | 123					  		 | 02/01/2021   		| 4   				 | Diesel    | 12345  	  | 546 								 | 5222				    |

