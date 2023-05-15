package application;

import model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        //--- Caminho do arquivo a ser lido ---
        String path = "src/temp/in.txt";
        //--- Lista do tipo Product ---
        List<Product> listProduct = new ArrayList<>();

        /**
         * Try With Resources.
         * Permite instanciar os recursos na mesma linha do Try.
         * Tudo que for instanciado na linha do Try será desalocado automaticamente ao final do Bloco Try.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //--- Realiza a leitura da linha do arquivo até quebra de linha ---
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] vect = line.split(",");
                //--- Variáveis para cada posição do Vetor 'vect' ---
                String name = vect[0];
                Double price = Double.parseDouble(vect[1]);
                Integer quantity = Integer.parseInt(vect[2]);

                Product product = new Product(name, price, quantity);
                listProduct.add(product);

                line = br.readLine();
            }

            System.out.println("PRODUCTS:");
            for (Product p : listProduct) {
                System.out.println(p);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
