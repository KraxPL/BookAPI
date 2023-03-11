package pl.krax.Initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.krax.Configuration.AppConfig;

public class AppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { return null; }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};  }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};   }
}