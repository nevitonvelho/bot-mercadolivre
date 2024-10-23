package org.example;
import com.microsoft.playwright.*;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {


        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            page.navigate("http://mercadolivre.com.br");



            JOptionPane.showMessageDialog(null, "Clique em OK para fechar o navegador e finalizar o programa.");

            browser.close();

        }
    }
}