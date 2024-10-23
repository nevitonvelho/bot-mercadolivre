package org.example;

import com.microsoft.playwright.*;

import javax.swing.JOptionPane;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(List.of("--start-maximized")));

            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));

            Page page = context.newPage();

            page.navigate("https://www.mercadolivre.com.br");

            page.getByLabel("Digite o que você quer encontrar").fill("Celular");
            page.keyboard().press("Enter");

            JOptionPane.showMessageDialog(null, "Clique em OK para fechar o navegador e finalizar o programa.");

            browser.close();
        }
    }
}
