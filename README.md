# Projeto que realiza a leitura de arquivos .txt .CSV e outros arquivos de texto.

###### OBS: Criado usando IDE - Intelijj. Ao clonar o projeto, certifique-se de buildar para gerar a pasta .idea para execução correta do projeto.

## Conteúdo do arquivo .txt
```
Name,Price,Quantity
Notebook Gamer,2100.90,10
Smartphone X,1890.00,23
TV LED 70,3500.89,8
```
## Conteúdo do arquivo .CSV
```
Name;Price;Quantity
Notebook Gamer;2100,90;10
Smartphone X;1890,00;23
TV LED 70;3500,89;8
```

## Código

### Utilizando (Try With Resources)

```java
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        /**
         * Try With Resources.
         * Permite instanciar os recursos na mesma linha do Try.
         * Tudo que for instanciado na linha do Try, será desalocado automaticamente ao final do Bloco Try.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            //--- CONTEÚDO.. ---
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```
### Lendo arquivo .txt e transformando seus valores em uma Lista de Objetos do tipo Product

```java
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

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
                Integer qte = Integer.parseInt(vect[2]);

                Product product = new Product(name, price, qte);
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
```
### Class Product.java

```java
package model;

import java.io.Serializable;

/**
 * Class Product
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Double price;
	private Integer quantity;
    
    //--- Empty Constructor ---
	public Product() {
	}

    //--- Constructor ---
	public Product(String name, Double price, Integer quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
}
```

