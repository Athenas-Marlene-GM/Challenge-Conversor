//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("""
                        
                        **************************************************
                        Bienvenido al conversor de moneda :D
                        **************************************************
                        
                        Menú
                        
                        1)  Dolar a peso mexicano
                        2)  Dolar a euro
                        3)  Dolar a peso colombiano
                        4)  Peso mexicano a dolar
                        5)  Peso mexicano a euro
                        6)  Peso mexicano a peso colombiano
                        7)  Euro a peso mexicano
                        8)  Euro a peso dolar
                        9)  Euro a peso colombiano
                        10) Peso colombiano a peso mexicano
                        11) Peso colombiano a dolar
                        12) Peso colombiano a euro
                        13) Salir
                        
                        Elije una opción válida:
                        """);

            try{
                int option = Integer.parseInt(scan.nextLine());


                if(option == 13){
                    break;
                }else if(option >= 1 && option <= 12){
                    String baseCode, targetCode;
                    GetConversion getConversion = new GetConversion();
                    baseCode = getConversion.getBaseCode(option);
                    targetCode = getConversion.getTargetCode(option);
                    System.out.printf("\nEscribe la cantidad de [%s] que deseas convertir a [%s]: ",baseCode,targetCode);
                    double amount = scan.nextDouble();
                    scan.nextLine();
                    Conversion convertion = getConversion.getConversion(baseCode,targetCode,amount);

                    System.out.printf("""
                            
                            **********************************************************
                            %.2f [%s] equivalen a %.2f [%s]
                            **********************************************************
                            
                            %n""", amount,baseCode,convertion.conversion_result(),targetCode);

                    System.out.println("Presiona Enter para continuar...");
                    scan.nextLine();
                }else{
                    System.out.println("Opción no válida, vuelve a intentarlo.");
                }

            } catch (NumberFormatException e){
                System.out.println("La entrada debe ser un número");
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }
        }
    }

}