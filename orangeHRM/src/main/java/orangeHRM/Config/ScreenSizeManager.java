package orangeHRM.Config;

import com.microsoft.playwright.options.ScreenSize;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia tamanhos de tela (viewport) para diferentes dispositivos.
 * Permite escolher predefinições ou valores customizados.
 */
public class ScreenSizeManager {

    /**
     * Predefinições de tamanhos de tela.
     * Chave = nome amigável (desktop, tablet, etc.)
     * Valor = ViewportSize correspondente.
     */
    private static final Map<String, ScreenSize> PRESETS = new HashMap<>();

    static {
        // Desktop “padrão full HD”
        PRESETS.put("desktop", new ScreenSize(1920, 1080));
        // Notebook 13"
        PRESETS.put("laptop", new ScreenSize(1366, 768));
        // iPad Pro (landscape)
        PRESETS.put("tablet", new ScreenSize(1024, 768));
        // iPhone 14 Pro
        PRESETS.put("mobile", new ScreenSize(390, 844));
        // Galaxy S20
        PRESETS.put("android-phone", new ScreenSize(412, 915));
    }

    /**
     * Retorna uma ViewportSize de acordo com um nome pré-definido.
     * Caso não encontre, retorna o desktop como fallback.
     *
     * @param key nome do preset (desktop, tablet, mobile…)
     * @return ViewportSize para usar no Browser.NewContextOptions
     */
    public static ScreenSize get(String key) {
        if (key == null) return PRESETS.get("desktop");
        return PRESETS.getOrDefault(key.toLowerCase(), PRESETS.get("desktop"));
    }

    /**
     * Permite criar um tamanho customizado rapidamente.
     *
     * @param width  largura em px
     * @param height altura em px
     * @return ViewportSize customizada
     */
    public static ScreenSize custom(int width, int height) {
        return new ScreenSize(width, height);
    }

}
