package org.example;

import com.microsoft.playwright.*;

import javax.swing.JOptionPane;
import java.util.List;

public class Main {

    public static Page openBrowserAndNavigate(Playwright playwright,String url) {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(List.of("--start-maximized")));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));

        Page page = context.newPage();

        page.navigate(url);

        return page;
    }

    public static String buscaPage(String buscar, Page page) {
        System.out.println(buscar);

        page.getByLabel("Digite o que você quer encontrar").fill(buscar);
        page.keyboard().press("Enter");
        String pesquisa = "Buscar OK";
        return pesquisa;
    }

    public static void clickFrete(String xpath, Page page){
        page.locator(xpath).click();
    }


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Page page = openBrowserAndNavigate(playwright, "https://www.mercadolivre.com.br");


            String buscar = "Celular";
            String pesquisa =  buscaPage(buscar, page);

            System.out.println(pesquisa);

            page.getByLabel("Digite o que você quer encontrar").fill("Celular");
            page.keyboard().press("Enter");


            String xpath = "//*[@id=\"root-app\"]/div/div[3]/aside/section[2]/div[2]/ul/li";
            clickFrete(xpath, page);




            JOptionPane.showMessageDialog(null, "Clique em OK para fechar o navegador e finalizar o programa.");

            page.context().browser().close();
        }
    }


}
