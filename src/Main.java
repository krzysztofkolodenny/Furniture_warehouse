import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws SQLException {
            System.out.println("Aby wybrać SELECT wciśnij 1: ");
            System.out.println("Aby wybrać INSERT wciśnij 2: ");
            System.out.println("Aby wybrać UPDATE wciśnij 3: ");
            System.out.println("Aby wybrać DELETE wciśnij 4: ");
            System.out.print("Podaj numer operacji: ");
            Scanner scan = new Scanner(System.in);
            int expression = scan.nextInt();
            switch (expression) {

                case 1:
                    Select sel = new Select();
                    sel.selectLog4j();
                    sel.formatSelect();
                    sel.setSelect();
                    break;

                case 2:
                    Insert ins = new Insert();
                    System.out.print("Podaj nazwe produktu: ");
                    String insert_produkt = scan.next();
                    ins.setInsert_produkt(insert_produkt);
                    System.out.print("Podaj nazwe materialu: ");
                    String insert_material = scan.next();
                    ins.setInsert_material(insert_material);
                    System.out.print("Podaj typ: ");
                    String insert_typ = scan.next();
                    ins.setInsert_typ(insert_typ);
                    System.out.print("Podaj cene: ");
                    float insert_cena = scan.nextFloat();
                    ins.setInsert_cena(insert_cena);
                    ins.setInsert();
                    ins.insertLog4j();
                    break;

                case 3:
                    Update upd = new Update();
                    System.out.print("Podaj id produktu na ktorym chcesz zmodyfikowac dane: ");
                    int update_id = scan.nextInt();
                    upd.setUpdate_id(update_id);
                    System.out.print("Podaj nazwe produktu: ");
                    String update_produkt = scan.next();
                    upd.setUpdate_produkt(update_produkt);
                    System.out.print("Podaj nazwe materialu: ");
                    String update_material = scan.next();
                    upd.setUpdate_material(update_material);
                    System.out.print("Podaj typ: ");
                    String update_typ = scan.next();
                    upd.setUpdate_typ(update_typ);
                    System.out.print("Podaj cene: ");
                    float update_cena = scan.nextFloat();
                    upd.setUpdate_cena(update_cena);
                    upd.setUpdate();
                    upd.updateLog4j();
                    break;

                case 4:
                    Delete del = new Delete();
                    System.out.print("Podaj id produktu wraz z ktorym usuniesz wiersz: ");
                    int delete_id = scan.nextInt();
                    del.setDelete_id(delete_id);
                    del.setDelete();
                    del.deleteLog4j();
                    break;

                default:
                    System.out.println("Brak odpowiedzi");

            }

    }


}