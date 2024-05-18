package org.oizehsgl.javaLearning.library.javax.script.util;

import lombok.extern.slf4j.Slf4j;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * JavaScript工具类
 *
 * @author oizehsgl
 */
@Slf4j
public class JavaScriptUtil {

    public static void main1(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = manager.getEngineFactories();

        System.out.println("Available Script Engines:");
        for (ScriptEngineFactory factory : engineFactories) {
            System.out.println("Engine Name: " + factory.getEngineName());
            System.out.println("Language Name: " + factory.getLanguageName());
            System.out.println("Extensions: " + factory.getExtensions());
            System.out.println("Mime Types: " + factory.getMimeTypes());
            System.out.println("-----");
        }
    }

    public static void main(String[] args) {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            //ScriptEngine engine = manager.getEngineByName("JavaScript");
            ScriptEngine engine = manager.getEngineByName("js");
            String scriptCode = "function test(param){return typeof(param);}";
            String scriptFunction = "test";
            engine.eval(scriptCode);
            Invocable invocableEngine = (Invocable) engine;
            Object returnObject = invocableEngine.invokeFunction(scriptFunction);
            System.out.println(returnObject);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}