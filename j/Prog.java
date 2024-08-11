import java.util.Scanner;

public class Prog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String perg;
        System.out.println("Enter product data !");
        System.out.print("Name, price and quantity ");
        String str = sc.nextLine();
        String[] x = str.split(" ");
        Product p = new Product(x[0],Double.parseDouble(x[1]) , Integer.parseInt(x[2]));
        System.out.println("Digite ou Add ou Rem");
        while ((perg = sc.nextLine()).equals("Add")||(perg = sc.nextLine()).equals("Rem"))
        {
            int y = sc.nextInt();
            if (perg.equals("Add"))
                p.add(y);
            else 
                p.sub(y);
            System.out.println(p.toString());
            System.out.println("Digite ou Add ou Rem");
        }
        sc.close();
    }
}
