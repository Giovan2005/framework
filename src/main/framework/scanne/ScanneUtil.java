package main.framework.scanne;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import main.framework.annotation.Controller;

public class ScanneUtil {
       public static List<Class<?>> getClassesAnnotatedWithController(String packageName) {

        List<Class<?>> controllers = new ArrayList<>();

        try {
            String path = packageName.replace('.', '/');

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            URL resource = classLoader.getResource(path);

            if (resource == null) {
                return controllers;
            }

            File directory = new File(resource.toURI());

            File[] files = directory.listFiles();

            if (files == null) {
                return controllers;
            }

            for (File file : files) {

                if (file.getName().endsWith(".class")) {

                    String className = packageName + "." 
                            + file.getName().replace(".class", "");

                    Class<?> clazz = Class.forName(className);

                    if (clazz.isAnnotationPresent(Controller.class)) {
                        controllers.add(clazz);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return controllers;
    }
}
