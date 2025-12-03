package org.ies.tierno.objects.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ies.tierno.objects.bank.readers.BankReader;

import java.util.Scanner;
@Data
@AllArgsConstructor
public class BankMenuApp {
    private final Scanner sc;
    private final BankReader bankReader;


    public int chooseOption(){
        int opt;
        do {
            System.out.println("//Banco//");
            System.out.println("1. Mostrar las cuentas del banco");
            System.out.println("2. Mostrar datos de una cuenta");
            System.out.println("3. Mostrar datos de una cuenta del cliente");
            System.out.println("4. Ingresar dinero en cuenta");
            System.out.println("5. Sacar dinero de una cuenta");
            System.out.println("6. Contar cuentas de cliente");
            System.out.println("7. Mostrar cliente de cuenta");
            System.out.println("8. Realizar transferencia");
            opt= sc.nextInt(); sc.nextLine();
            if (opt==1){

            }
            else if(opt==2){

            }
            else if(opt==3){

            }
            else if(opt==4){

            }
            else if(opt==5){

            }
            else if(opt==6){

            } else if (opt==7) {

            }
            else if(opt==8){
                System.out.println("Saliendo...");
            }
            else {
                System.out.println("Opción inválida");
            }

        }while(opt!=8);
        return opt;
    }
}
